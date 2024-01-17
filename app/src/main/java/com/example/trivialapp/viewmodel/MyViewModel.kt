package com.example.trivialapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {
    var selectedDifficulty: String by mutableStateOf("Easy")
        private set

    fun modifyDifficulty(difficulty: String) {
        selectedDifficulty = difficulty
    }
}