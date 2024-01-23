package com.example.trivialapp.model

class QuestionsAndAnswers {
    data class Kahoot(
        val pregunta: String,
        val respuestas: MutableList<String>
    )

    var preguntasUsadas = mutableListOf<Int>()
}