package com.github.aptemkov.cleanarchitectureexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.github.aptemkov.cleanarchitectureexample.databinding.ActivityMainBinding
import com.github.aptemkov.cleanarchitectureexample.domain.models.SaveUserNameParameter
import com.github.aptemkov.cleanarchitectureexample.domain.usecase.GetUsernameUseCase
import com.github.aptemkov.cleanarchitectureexample.domain.usecase.SaveUsernameUseCase
import com.google.android.material.snackbar.Snackbar

private lateinit var binding: ActivityMainBinding
private val  getUsernameUseCase = GetUsernameUseCase()
private val  saveUsernameUseCase = SaveUsernameUseCase()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.sendButton.setOnClickListener {
            val text = binding.dataEditText.text.toString()
            val param = SaveUserNameParameter(firstName = text)
            val result = saveUsernameUseCase.execute(param = param)
            Snackbar.make(it, "$result", Snackbar.LENGTH_SHORT).show()
        }

        binding.receiveButton.setOnClickListener {
            val userName = getUsernameUseCase.execute()
            binding.dataTextView.text = "${userName.firstName} ${userName.lastName}"
        }

    }
}