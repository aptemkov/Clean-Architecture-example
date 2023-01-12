package com.github.aptemkov.cleanarchitectureexample.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.github.aptemkov.cleanarchitectureexample.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViews()

        viewModel.stateLive.observe(this) { state ->
            binding.dataTextView.text = "${state.firstName} ${state.lastName} ${state.saveResult}"
        }

    }

    private fun initViews() {
        binding.sendButton.setOnClickListener {
            val text = binding.dataEditText.text.toString()
            viewModel.send(SaveEvent(text = text))
        }

        binding.receiveButton.setOnClickListener {
            viewModel.send(LoadEvent())
        }
    }
}