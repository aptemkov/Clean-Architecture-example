package com.github.aptemkov.cleanarchitectureexample.di

import com.github.aptemkov.cleanarchitectureexample.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<MainViewModel> {
        MainViewModel(
            getUsernameUseCase = get(),
            saveUsernameUseCase = get(),
        )
}

}