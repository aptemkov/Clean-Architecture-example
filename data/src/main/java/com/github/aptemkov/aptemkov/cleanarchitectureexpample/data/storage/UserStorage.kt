package com.github.aptemkov.aptemkov.cleanarchitectureexpample.data.storage

import com.github.aptemkov.aptemkov.cleanarchitectureexpample.data.storage.models.User

interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User

}