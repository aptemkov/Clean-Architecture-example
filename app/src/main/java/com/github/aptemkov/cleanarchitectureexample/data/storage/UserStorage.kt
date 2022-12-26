package com.github.aptemkov.cleanarchitectureexample.data.storage

import com.github.aptemkov.cleanarchitectureexample.data.storage.sharedprefs.User

interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User

}