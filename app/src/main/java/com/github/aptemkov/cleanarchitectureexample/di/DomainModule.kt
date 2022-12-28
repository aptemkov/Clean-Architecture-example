package com.github.aptemkov.cleanarchitectureexample.di

import com.github.aptemkov.cleanarchitectureexample.domain.usecase.GetUsernameUseCase
import com.github.aptemkov.cleanarchitectureexample.domain.usecase.SaveUsernameUseCase
import org.koin.dsl.module


val domainModule = module {

    factory<GetUsernameUseCase> {
        GetUsernameUseCase(userRepository = get())
    }

    factory<SaveUsernameUseCase> {
        SaveUsernameUseCase(userRepository = get())
    }

}