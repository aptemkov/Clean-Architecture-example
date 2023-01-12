package com.github.aptemkov.cleanarchitectureexample.presentation

interface MainEvent

class SaveEvent(val text: String): MainEvent

class LoadEvent : MainEvent