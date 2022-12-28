package com.github.aptemkov.cleanarchitectureexample.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.github.aptemkov.cleanarchitectureexample.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViews()

        viewModel.resultUserNameLive.observe(this) {
            binding.dataTextView.text = it
        }

        viewModel.resultStatus.observe(this) {
            Snackbar.make(binding.root, it, Snackbar.LENGTH_SHORT).show()
        }

    }

    private fun initViews() {
        binding.sendButton.setOnClickListener {
            val text = binding.dataEditText.text.toString()
            viewModel.save(text)
        }

        binding.receiveButton.setOnClickListener {
            viewModel.load()
        }
    }
}