package space.doky.andadv2.firebase.repository.di

import space.doky.andadv2.firebase.repository.FirebaseRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import space.doky.andadv2.domain.output.FirebaseInterface
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindFirebaseRepository(firebaseRepository: FirebaseRepository): FirebaseInterface
}