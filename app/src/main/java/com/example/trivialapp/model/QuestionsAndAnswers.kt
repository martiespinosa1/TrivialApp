package com.example.trivialapp.model

class QuestionsAndAnswers {
    data class Kahoot(
        val pregunta: String,
        val respuestas: List<String>
    )
}