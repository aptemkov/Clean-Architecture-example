package com.github.aptemkov.cleanarchitectureexample.di

import com.github.aptemkov.aptemkov.cleanarchitectureexpample.data.repository.UserRepositoryImpl
import com.github.aptemkov.aptemkov.cleanarchitectureexpample.data.storage.UserStorage
import com.github.aptemkov.aptemkov.cleanarchitectureexpample.data.storage.sharedprefs.SharedPrefUserStorage
import com.github.aptemkov.cleanarchitectureexample.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {

    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }
}