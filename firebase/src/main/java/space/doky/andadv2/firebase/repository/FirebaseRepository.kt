package space.doky.andadv2.firebase.repository

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import space.doky.andadv2.domain.output.FirebaseInterface
import space.doky.andadv2.firebase.datasource.FirebaseManager
import space.doky.andadv2.util.AppLog
import javax.inject.Inject

class FirebaseRepository @Inject constructor(
    @ApplicationContext private val context: Context,
    private val firebaseManager: FirebaseManager
) : FirebaseInterface {
    private var session: Flow<String>? = null

    override suspend fun start(): Flow<String> {

        AppLog.e("============", "start", "session: $session")

        session?.run {
            return this
        }

        firebaseManager.init(APP_ID)
        return callbackFlow<String> {
            val listener = { value: String ->
                trySend(value)
                Unit
            }
            firebaseManager.start(listener)

            awaitClose {
                firebaseManager.stop()
            }
        }.apply { session = this }
    }

    override fun stop() {
        AppLog.e("============", "stop", "session: $session")
        firebaseManager.stop()
        session = null
    }

    override fun sendData(value: String) {
        firebaseManager.send(value)
    }

    companion object {
        const val APP_ID = "20101"
        val TAG = FirebaseRepository::class.java.simpleName
    }
}