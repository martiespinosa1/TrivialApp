package com.example.trivialapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.trivialapp.model.QuestionsAndAnswers

class MyViewModel: ViewModel() {
    var selectedDifficulty: String by mutableStateOf("Medium")
        private set

    var selectedRounds: Int by mutableIntStateOf(10)
        private set

    var selectedTime: Int by mutableIntStateOf(30)
        private set

    var colorMode: Boolean by mutableStateOf(false)
        private set




    fun modifyDifficulty(difficulty: String) {
        selectedDifficulty = difficulty
    }

    fun modifyRounds(rounds: Int) {
        selectedRounds = rounds
    }

    fun modifyTime(time: Int) {
        selectedTime = time
    }

    fun modifyColorMode(dark: Boolean) {
        colorMode = dark
    }




}