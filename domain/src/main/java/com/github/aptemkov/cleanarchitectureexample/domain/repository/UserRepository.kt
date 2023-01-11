package com.github.aptemkov.cleanarchitectureexample.domain.repository

import com.github.aptemkov.cleanarchitectureexample.domain.models.SaveUserNameParameter
import com.github.aptemkov.cleanarchitectureexample.domain.models.UserName

interface UserRepository {

    fun saveUserName(saveParam: SaveUserNameParameter): Boolean

    fun getUserName(): UserName

}