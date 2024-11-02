package space.doky.andadv2.data.datasource.datastore.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import space.doky.andadv2.data.datasource.datastore.AppPreferencesSerializer
import space.doky.andadv2.util.di.ApplicationScope
import space.doky.andadv2.util.di.IODispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import space.doky.andadv2.AppPreferences
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PreferencesModule {
    @Singleton
    @Provides
    fun provideAppPreferencesDataStore(
        @ApplicationContext context: Context,
        @ApplicationScope scope: CoroutineScope,
        @IODispatcher ioDispatcher: CoroutineDispatcher,
        appPreferencesSerializer: AppPreferencesSerializer
    ): DataStore<AppPreferences> = DataStoreFactory.create(
        serializer = appPreferencesSerializer,
        scope = CoroutineScope(scope.coroutineContext + ioDispatcher),
        produceFile = { context.dataStoreFile("app_preferences.pb") }
    )
}