package com.github.aptemkov.cleanarchitectureexample.presentation.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.aptemkov.aptemkov.cleanarchitectureexpample.data.repository.UserRepositoryImpl
import com.github.aptemkov.aptemkov.cleanarchitectureexpample.data.storage.sharedprefs.SharedPrefUserStorage
import com.github.aptemkov.cleanarchitectureexample.domain.usecase.GetUsernameUseCase
import com.github.aptemkov.cleanarchitectureexample.domain.usecase.SaveUsernameUseCase


class MainViewModelFactory(
    val getUsernameUseCase: GetUsernameUseCase,
    val saveUsernameUseCase: SaveUsernameUseCase,
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getUsernameUseCase = getUsernameUseCase,
            saveUsernameUseCase = saveUsernameUseCase,
        ) as T
    }

}