package com.github.aptemkov.cleanarchitectureexample.presentation.di

import com.github.aptemkov.cleanarchitectureexample.presentation.presentation.MainActivity
import dagger.Component

@Component(modules = [AppModule::class, DomainModule::class, DataModule::class])

interface AppComponent {
    fun inject(mainActivity: MainActivity)
}