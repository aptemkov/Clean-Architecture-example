package com.github.aptemkov.cleanarchitectureexample.data.repository

import android.content.Context
import com.github.aptemkov.cleanarchitectureexample.domain.models.SaveUserNameParameter
import com.github.aptemkov.cleanarchitectureexample.domain.models.UserName
import com.github.aptemkov.cleanarchitectureexample.domain.repository.UserRepository

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_LAST_NAME = "lastName "
private const val DEFAULT_FIST_NAME = "firstName "
private const val DEFAULT_LAST_NAME = "lastName "

class UserRepositoryImpl(context: Context): UserRepository {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveUserName(saveParam: SaveUserNameParameter): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, saveParam.firstName ).apply()
        return true
    }

    override fun getUserName(): UserName {
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, "empty") ?: DEFAULT_FIST_NAME
        val lastName = sharedPreferences.getString(KEY_LAST_NAME, "empty ") ?: DEFAULT_LAST_NAME

        return UserName(firstName = firstName, lastName = lastName)
    }


}