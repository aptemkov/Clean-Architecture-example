package com.github.aptemkov.cleanarchitectureexample.presentation.di

import android.content.Context
import com.github.aptemkov.aptemkov.cleanarchitectureexpample.data.repository.UserRepositoryImpl
import com.github.aptemkov.aptemkov.cleanarchitectureexpample.data.storage.UserStorage
import com.github.aptemkov.aptemkov.cleanarchitectureexpample.data.storage.sharedprefs.SharedPrefUserStorage
import com.github.aptemkov.cleanarchitectureexample.domain.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideUserStorage(context: Context): UserStorage {
        return SharedPrefUserStorage(context = context)
    }

    @Provides
    fun provideUserRepositoryImpl(userStorage: UserStorage): UserRepository {
        return UserRepositoryImpl(userStorage = userStorage)
    }
}