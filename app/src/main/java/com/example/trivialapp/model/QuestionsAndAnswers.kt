package com.example.trivialapp.model

class QuestionsAndAnswers {
    data class Preguntas(
        val pregunta1: String,
        val pregunta2: String,
        val pregunta3: String,
        val pregunta4: String,
        val pregunta5: String,
        val pregunta6: String,
        val pregunta7: String,
        val pregunta8: String,
        val pregunta9: String,
        val pregunta10: String
    )

    val preguntas = Preguntas(
        pregunta1 = "¿Cuál es la capital de Francia?",
        pregunta2 = "¿Quién pintó la Mona Lisa?",
        pregunta3 = "¿Cuál es el río más largo del mundo?",
        pregunta4 = "¿Cuál es el país más poblado del mundo?",
        pregunta5 = "¿Cuál es el elemento químico más abundante en la Tierra?",
        pregunta6 = "¿Quién escribió 'Don Quijote de la Mancha'?",
        pregunta7 = "¿Cuál es el océano más grande del mundo?",
        pregunta8 = "¿Cuál es el animal terrestre más grande?",
        pregunta9 = "¿Cuál es el país más grande de América del Sur?",
        pregunta10 = "¿Cuál es el símbolo químico del oro?"
    )




}