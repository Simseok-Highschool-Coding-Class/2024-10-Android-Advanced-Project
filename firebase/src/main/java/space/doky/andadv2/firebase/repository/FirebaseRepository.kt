package space.doky.andadv2.firebase.repository

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import space.doky.andadv2.domain.output.FirebaseInterface
import space.doky.andadv2.firebase.datasource.FirebaseManager
import space.doky.andadv2.util.AppLog
import space.doky.andadv2.util.AppPolicy.FIREBASE_APP_ID
import javax.inject.Inject

class FirebaseRepository @Inject constructor(
    private val firebaseManager: FirebaseManager
) : FirebaseInterface {
    private var session: Flow<String>? = null

    // TODO: 인터넷이 안될 때 처리

    override suspend fun start(): Flow<String> {
        AppLog.e(TAG, "start", "session: $session")

        session?.run {
            return this
        }

        firebaseManager.init(FIREBASE_APP_ID)
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
        AppLog.e(TAG, "stop", "session: $session")
        firebaseManager.stop()
        session = null
    }

    override fun sendData(value: String) {
        firebaseManager.send(value)
    }

    companion object {
        val TAG = FirebaseRepository::class.java.simpleName
    }
}