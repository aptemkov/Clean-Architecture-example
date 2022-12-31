package com.github.aptemkov.cleanarchitectureexample.presentation.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.aptemkov.cleanarchitectureexample.domain.models.SaveUserNameParameter
import com.github.aptemkov.cleanarchitectureexample.domain.usecase.GetUsernameUseCase
import com.github.aptemkov.cleanarchitectureexample.domain.usecase.SaveUsernameUseCase


/**
*ViewModel can't contain context
 * and should not return anything.
 * *MVVM is not an architecture, but pattern
 ***/

class MainViewModel(
    private val getUsernameUseCase: GetUsernameUseCase,
    private val saveUsernameUseCase: SaveUsernameUseCase
) : ViewModel() {

    private val _resultUserNameLive = MutableLiveData<String>()
    val resultUserNameLive = _resultUserNameLive

    private  val _resultStatus = MutableLiveData<String>()
    val resultStatus = _resultStatus

    fun save(text: String) {
        val param = SaveUserNameParameter(
            firstName = text)
        val resultData = saveUsernameUseCase.execute(param = param)
        _resultStatus.value =  "Result = $resultData"
    }

    fun load () {
        val userName = getUsernameUseCase.execute()
        _resultUserNameLive.value = "Name: ${userName.firstName}\n" +
                "Lastname: ${userName.lastName}"
    }


}