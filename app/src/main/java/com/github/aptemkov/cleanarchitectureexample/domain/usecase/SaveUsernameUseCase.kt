package com.github.aptemkov.cleanarchitectureexample.domain.usecase

import com.github.aptemkov.cleanarchitectureexample.domain.models.SaveUserNameParameter

class SaveUsernameUseCase {

    fun execute(param: SaveUserNameParameter): Boolean {
        return param.firstName.isNotEmpty()
    }

}