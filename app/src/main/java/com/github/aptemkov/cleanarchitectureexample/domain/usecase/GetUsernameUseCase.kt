package com.github.aptemkov.cleanarchitectureexample.domain.usecase

import com.github.aptemkov.cleanarchitectureexample.domain.models.UserName

class GetUsernameUseCase {

    fun execute(): UserName {
        return UserName("Hello", "world")
    }

}