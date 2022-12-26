package com.github.aptemkov.cleanarchitectureexample.domain.usecase

import com.github.aptemkov.cleanarchitectureexample.domain.models.UserName
import com.github.aptemkov.cleanarchitectureexample.domain.repository.UserRepository

class GetUsernameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName {
        return userRepository.getUserName()
    }

}