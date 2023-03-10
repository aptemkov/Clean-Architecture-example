package com.github.aptemkov.aptemkov.cleanarchitectureexpample.data.repository

import com.github.aptemkov.aptemkov.cleanarchitectureexpample.data.storage.UserStorage
import com.github.aptemkov.aptemkov.cleanarchitectureexpample.data.storage.models.User
import com.github.aptemkov.cleanarchitectureexample.domain.models.SaveUserNameParameter
import com.github.aptemkov.cleanarchitectureexample.domain.models.UserName
import com.github.aptemkov.cleanarchitectureexample.domain.repository.UserRepository


class UserRepositoryImpl(private val userStorage: UserStorage): UserRepository {


    override fun saveUserName(saveParam: SaveUserNameParameter): Boolean {

        val user = mapToStorage(saveParam)

        val result = userStorage.save(user)
        return result
    }

    override fun getUserName(): UserName {
        val user = userStorage.get()

        val userName = mapToDomain(user)
        return userName
    }

    private fun mapToStorage(saveParam: SaveUserNameParameter): User {
        return User (firstName = saveParam.firstName, lastName = "default")
    }

    private fun mapToDomain(user: User): UserName {
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }

}