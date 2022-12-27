package com.github.aptemkov.cleanarchitectureexample.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.aptemkov.aptemkov.cleanarchitectureexpample.data.repository.UserRepositoryImpl
import com.github.aptemkov.aptemkov.cleanarchitectureexpample.data.storage.sharedprefs.SharedPrefUserStorage
import com.github.aptemkov.cleanarchitectureexample.databinding.ActivityMainBinding
import com.github.aptemkov.cleanarchitectureexample.domain.models.SaveUserNameParameter
import com.github.aptemkov.cleanarchitectureexample.domain.usecase.GetUsernameUseCase
import com.github.aptemkov.cleanarchitectureexample.domain.usecase.SaveUsernameUseCase
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val userRepository by lazy {
        UserRepositoryImpl(
            userStorage = SharedPrefUserStorage(context = applicationContext)
        )
    }

    private val getUsernameUseCase by lazy {
        GetUsernameUseCase(userRepository)
    }
    private val saveUsernameUseCase by lazy {
        SaveUsernameUseCase(userRepository)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.sendButton.setOnClickListener {
            val text = binding.dataEditText.text.toString()
            val param = SaveUserNameParameter(
                firstName = text)
            val result = saveUsernameUseCase.execute(param = param)
            Snackbar.make(it, "$result", Snackbar.LENGTH_SHORT).show()
        }

        binding.receiveButton.setOnClickListener {
            val userName = getUsernameUseCase.execute()
            binding.dataTextView.text =
                "Name: ${userName.firstName}\n" +
                        "Lastname: ${userName.lastName}"
        }

    }
}