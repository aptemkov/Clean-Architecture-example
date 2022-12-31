package com.github.aptemkov.cleanarchitectureexample.presentation.di

import com.github.aptemkov.cleanarchitectureexample.domain.repository.UserRepository
import com.github.aptemkov.cleanarchitectureexample.domain.usecase.GetUsernameUseCase
import com.github.aptemkov.cleanarchitectureexample.domain.usecase.SaveUsernameUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetUsernameUseCase(userRepository: UserRepository): GetUsernameUseCase {
        return GetUsernameUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideSaveUsernameUseCase(userRepository: UserRepository): SaveUsernameUseCase {
        return SaveUsernameUseCase(userRepository = userRepository)
    }

}