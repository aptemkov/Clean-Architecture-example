package com.github.aptemkov.cleanarchitectureexample.domain.usecase

import com.github.aptemkov.cleanarchitectureexample.domain.models.SaveUserNameParameter
import com.github.aptemkov.cleanarchitectureexample.domain.repository.UserRepository

class SaveUsernameUseCase(private val repository: UserRepository) {

    fun execute(param: SaveUserNameParameter): Boolean {

        val oldUserName = repository.getUserName()
        var newParam = param
        if(param.firstName == oldUserName.firstName) {
            newParam = SaveUserNameParameter(param.firstName + "*")
        }

        val result = repository.saveUserName(saveParam = newParam)
        return result
    }

}