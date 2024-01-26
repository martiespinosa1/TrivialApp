package com.example.trivialapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.trivialapp.model.QuestionsAndAnswers
import kotlin.random.Random

class MyViewModel: ViewModel() {
    var selectedDifficulty: String by mutableStateOf("Medium")
        private set

    var selectedRounds: Int by mutableIntStateOf(10)
        private set

    var selectedTime: Int by mutableIntStateOf(30)
        private set

    var colorMode: Boolean by mutableStateOf(false)
        private set

    var contadorAciertos: Int by mutableIntStateOf(0)
        private set


    val kahootEasy : MutableList<QuestionsAndAnswers.Kahoot> = mutableListOf(
        QuestionsAndAnswers.Kahoot("¿Cuál es la capital de Francia?", mutableListOf("París", "Madrid", "Berlín", "Londres")),
        QuestionsAndAnswers.Kahoot("¿Cuántos días tiene una semana?", mutableListOf("7", "5", "10", "12")),
        QuestionsAndAnswers.Kahoot("¿Quién escribió Romeo y Julieta?", mutableListOf("William Shakespeare", "Jane Austen", "Charles Dickens", "F. Scott Fitzgerald")),
        QuestionsAndAnswers.Kahoot("¿Cuál es el planeta más grande del sistema solar?", mutableListOf("Júpiter", "Marte", "Venus", "Saturno")),
        QuestionsAndAnswers.Kahoot("¿Cuál es el río más largo del mundo?", mutableListOf("Amazonas", "Nilo", "Misisipi", "Yangtsé")),
        QuestionsAndAnswers.Kahoot("¿En qué año comenzó la Segunda Guerra Mundial?", mutableListOf("1939", "1945", "1914", "1929")),
        QuestionsAndAnswers.Kahoot("¿Cuál es el animal terrestre más grande?", mutableListOf("Elefante africano", "Jirafa", "Hipopótamo", "Oso polar")),
        QuestionsAndAnswers.Kahoot("¿Quién pintó La Última Cena?",mutableListOf("Leonardo da Vinci", "Vincent van Gogh", "Pablo Picasso", "Claude Monet")),
        QuestionsAndAnswers.Kahoot("¿En qué año se fundó Google?", mutableListOf("1998", "2000", "1995", "2005")),
        QuestionsAndAnswers.Kahoot("¿Cuántos continentes hay en el mundo?", mutableListOf("7", "5", "6", "4")),
        QuestionsAndAnswers.Kahoot("¿Cuál es la montaña más alta del mundo?", mutableListOf("Monte Everest", "K2", "Monte McKinley", "Monte Kilimanjaro")),
        QuestionsAndAnswers.Kahoot("¿Qué metal es conocido como el oro rojo?", mutableListOf("Cobre", "Oro", "Plata", "Aluminio")),
        QuestionsAndAnswers.Kahoot("¿En qué país se encuentra la Gran Muralla China?", mutableListOf("China", "Japón", "Corea del Sur", "India")),
        QuestionsAndAnswers.Kahoot("¿Cuál es el instrumento musical más antiguo?", mutableListOf("Flauta", "Piano", "Violín", "Trompeta")),
        QuestionsAndAnswers.Kahoot("¿Cuántos colores tiene el arcoíris?", mutableListOf("7", "5", "6", "9"))
    )

    val kahootMedium : MutableList<QuestionsAndAnswers.Kahoot> = mutableListOf(
        QuestionsAndAnswers.Kahoot("¿Cuál es el metal más abundante en la corteza terrestre?", mutableListOf("Aluminio", "Hierro", "Cobre", "Oro")),
        QuestionsAndAnswers.Kahoot("¿En qué año se proclamó la Declaración de los Derechos Humanos?", mutableListOf("1948", "1955", "1939", "1962")),
        QuestionsAndAnswers.Kahoot("¿Cuál es la capital de Australia?", mutableListOf("Camberra", "Sídney", "Melbourne", "Brisbane")),
        QuestionsAndAnswers.Kahoot("¿Quién fue el primer presidente de Estados Unidos?", mutableListOf("George Washington", "Thomas Jefferson", "John Adams", "Abraham Lincoln")),
        QuestionsAndAnswers.Kahoot("¿Qué gas compone la mayor parte de la atmósfera terrestre?", mutableListOf("Nitrógeno", "Oxígeno", "Dióxido de carbono", "Argón")),
        QuestionsAndAnswers.Kahoot("¿En qué año se celebró la Revolución Rusa?", mutableListOf("1917", "1925", "1905", "1933")),
        QuestionsAndAnswers.Kahoot("¿Cuál es el río más largo de América del Norte?", mutableListOf("Mississippi", "Missouri", "Yukón", "Colorado")),
        QuestionsAndAnswers.Kahoot("¿Qué científico formuló la teoría de la relatividad?", mutableListOf("Albert Einstein", "Isaac Newton", "Galileo Galilei", "Stephen Hawking")),
        QuestionsAndAnswers.Kahoot("¿Cuándo ocurrió la caída del Muro de Berlín?", mutableListOf("1989", "1991", "1985", "1995")),
        QuestionsAndAnswers.Kahoot("¿Cuál es el océano más grande del mundo?", mutableListOf("Océano Pacífico", "Océano Atlántico", "Océano Índico", "Océano Antártico")),
        QuestionsAndAnswers.Kahoot("¿Quién escribió el libro 'Cien años de soledad'?", mutableListOf("Gabriel García Márquez", "Julio Cortázar", "Mario Vargas Llosa", "Isabel Allende")),
        QuestionsAndAnswers.Kahoot("¿Cuántos huesos tiene el cuerpo humano adulto?", mutableListOf("206", "195", "220", "180")),
        QuestionsAndAnswers.Kahoot("¿En qué continente se encuentra la Antártida?", mutableListOf("Antártida", "África", "América", "Asia")),
        QuestionsAndAnswers.Kahoot("¿Quién fue el primer ser humano en el espacio?", mutableListOf("Yuri Gagarin", "Neil Armstrong", "Buzz Aldrin", "Valentina Tereshkova")),
        QuestionsAndAnswers.Kahoot("¿Cuál es el segundo idioma más hablado del mundo?", mutableListOf("Español", "Inglés", "Mandarín", "Hindi"))
    )

    val kahootHard : MutableList<QuestionsAndAnswers.Kahoot> = mutableListOf(
        QuestionsAndAnswers.Kahoot("¿Quién formuló la teoría de la relatividad general?", mutableListOf("Albert Einstein", "Stephen Hawking", "Niels Bohr", "Max Planck")),
        QuestionsAndAnswers.Kahoot("¿Cuál es el elemento químico con el número atómico 79?", mutableListOf("Oro", "Plata", "Cobre", "Hierro")),
        QuestionsAndAnswers.Kahoot("¿En qué año se fundó la Unión Europea?", mutableListOf("1957", "1945", "1965", "1980")),
        QuestionsAndAnswers.Kahoot("¿Cuál es la novela más larga jamás escrita?", mutableListOf("La Montaña Mágica", "En busca del tiempo perdido", "Ulises", "Los hermanos Karamázov")),
        QuestionsAndAnswers.Kahoot("¿Qué filósofo es conocido por su teoría del superhombre?", mutableListOf("Friedrich Nietzsche", "Immanuel Kant", "Jean-Jacques Rousseau", "John Locke")),
        QuestionsAndAnswers.Kahoot("¿Cuántos premios Nobel ganó Marie Curie?", mutableListOf("Dos", "Uno", "Cinco", "Ninguno")),
        QuestionsAndAnswers.Kahoot("¿Cuál es el fenómeno físico detrás de la aurora boreal?", mutableListOf("Interacción de partículas solares con la atmósfera", "Reflejo de la luz solar en la atmósfera", "Efecto Doppler de la luz", "Influencia de la luna en las mareas")),
        QuestionsAndAnswers.Kahoot("¿Cuál es la obra más famosa de Anton Chejov?", mutableListOf("La gaviota", "Tío Vania", "Tres hermanas", "El jardín de los cerezos")),
        QuestionsAndAnswers.Kahoot("¿En qué año se descubrió la estructura del ADN?", mutableListOf("1953", "1960", "1945", "1972")),
        QuestionsAndAnswers.Kahoot("¿Qué matemático propuso el teorema de incompletitud?", mutableListOf("Kurt Gödel", "Alan Turing", "David Hilbert", "Georg Cantor")),
        QuestionsAndAnswers.Kahoot("¿Quién desarrolló la teoría de los juegos?", mutableListOf("John von Neumann", "John Nash", "Leonhard Euler", "Blaise Pascal")),
        QuestionsAndAnswers.Kahoot("¿Cuántos satélites naturales tiene el planeta Marte?", mutableListOf("Dos", "Fobos y Deimos", "Cinco", "Ninguno")),
        QuestionsAndAnswers.Kahoot("¿Quién escribió 'Ensayo sobre la desigualdad de las razas humanas'?", mutableListOf("Arthur de Gobineau", "Charles Darwin", "Immanuel Kant", "Voltaire")),
        QuestionsAndAnswers.Kahoot("¿Cuál es la obra más conocida de Ludwig van Beethoven?", mutableListOf("Sinfonía n.º 9 en re menor, op. 125", "Sonata para piano n.º 14 en do sostenido menor 'Claro de luna'", "Concierto para piano n.º 5 en mi bemol mayor 'Emperador'", "Sinfonía n.º 5 en do menor, op. 67")),
        QuestionsAndAnswers.Kahoot("¿Quién desarrolló la teoría de la relatividad especial?", mutableListOf("Albert Einstein", "Niels Bohr", "Max Planck", "Werner Heisenberg"))
    )




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

    fun modifyAciertos(aciertos: Int) {
        contadorAciertos = aciertos
    }



}