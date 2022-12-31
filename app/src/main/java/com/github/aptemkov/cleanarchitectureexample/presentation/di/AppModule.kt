package com.github.aptemkov.cleanarchitectureexample.presentation.di

import android.content.Context
import com.github.aptemkov.cleanarchitectureexample.domain.usecase.GetUsernameUseCase
import com.github.aptemkov.cleanarchitectureexample.domain.usecase.SaveUsernameUseCase
import com.github.aptemkov.cleanarchitectureexample.presentation.presentation.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {

    @Provides
    fun providerContext():Context {
        return context
    }

    @Provides
    fun provideMainViewModelFactory(
        getUsernameUseCase: GetUsernameUseCase,
        saveUsernameUseCase: SaveUsernameUseCase,
    ): MainViewModelFactory {
        return MainViewModelFactory(
            getUsernameUseCase = getUsernameUseCase,
            saveUsernameUseCase = saveUsernameUseCase)
    }

}