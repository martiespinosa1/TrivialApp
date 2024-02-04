package com.example.trivialapp.model

class QuestionsAndAnswers {
    data class Kahoot(
        val pregunta: String,
        var respuestas: MutableList<String>,
        val tipo: String
    )
}