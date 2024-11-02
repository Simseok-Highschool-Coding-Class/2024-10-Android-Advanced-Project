package space.doky.andadv2.data.repository.di

import space.doky.andadv2.data.repository.AppPreferencesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import space.doky.andadv2.domain.output.AppPreferenceInterface
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindAppPreferenceRepository(appPreferenceRepository: AppPreferencesRepository): AppPreferenceInterface
}