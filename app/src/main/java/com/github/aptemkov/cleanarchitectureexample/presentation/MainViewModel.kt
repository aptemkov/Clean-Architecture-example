package com.github.aptemkov.cleanarchitectureexample.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.aptemkov.cleanarchitectureexample.domain.models.SaveUserNameParameter
import com.github.aptemkov.cleanarchitectureexample.domain.usecase.GetUsernameUseCase
import com.github.aptemkov.cleanarchitectureexample.domain.usecase.SaveUsernameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


/**
*ViewModel can't contain context
 * and should not return anything.
 * *MVVM is not an architecture, but pattern
 ***/

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUsernameUseCase: GetUsernameUseCase,
    private val saveUsernameUseCase: SaveUsernameUseCase
) : ViewModel() {

    private val _stateLiveMutable = MutableLiveData<MainState>()
    val stateLive = _stateLiveMutable

    init {
        _stateLiveMutable.value = MainState(
            saveResult = false,
            firstName = "",
            lastName = "",
        )
    }

    fun send(event: MainEvent) {
        when(event) {
            is SaveEvent -> {
                save(text = event.text)
            }
            is LoadEvent -> {
                load()
            }
        }

    }

    private fun save(text: String) {
        val param = SaveUserNameParameter(
            firstName = text)
        val resultData = saveUsernameUseCase.execute(param = param)
        _stateLiveMutable.value = MainState(
            saveResult = resultData,
            firstName = _stateLiveMutable.value!!.firstName,
            lastName = _stateLiveMutable.value!!.lastName,
        )
    }

    private fun load () {
        val userName = getUsernameUseCase.execute()
        _stateLiveMutable.value = MainState(
            saveResult = _stateLiveMutable.value!!.saveResult,
            firstName = userName.firstName,
            lastName = userName.lastName,
        )
    }


}