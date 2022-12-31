package com.github.aptemkov.cleanarchitectureexample.presentation.app

import android.app.Application
import com.github.aptemkov.cleanarchitectureexample.presentation.di.AppComponent
import com.github.aptemkov.cleanarchitectureexample.presentation.di.AppModule
import com.github.aptemkov.cleanarchitectureexample.presentation.di.DaggerAppComponent

class App: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()

    }
}

