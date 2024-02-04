package com.example.trivialapp.viewmodel

import androidx.compose.foundation.BorderStroke
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.trivialapp.model.QuestionsAndAnswers.Kahoot
import kotlin.random.Random

class MyViewModel: ViewModel() {
    var selectedDifficulty: String by mutableStateOf("Medium")
        private set

    var selectedRounds: Int by mutableIntStateOf(10)
        private set

    var selectedTime: Int by mutableIntStateOf(15)
        private set

    var darkMode: Boolean by mutableStateOf(false)
        private set

    var contadorAciertos: Int by mutableIntStateOf(0)
        private set






    var colorText = if (darkMode) {
        Color.LightGray
    } else Color.DarkGray


    var colorBorde = if (darkMode) {
        BorderStroke(2.dp, Color.LightGray)
    } else BorderStroke(2.dp, Color.DarkGray)





    fun modifyDifficulty(difficulty: String) {
        selectedDifficulty = difficulty
    }

    fun modifyRounds(rounds: Int) {
        selectedRounds = rounds
    }

    fun modifyTime(time: Int) {
        selectedTime = time
    }

    fun modifyDarkMode(dark: Boolean) {
        darkMode = dark

        colorText = if (darkMode) {
            Color.LightGray
        } else Color.DarkGray

        colorBorde = if (darkMode) {
            BorderStroke(2.dp, Color.LightGray)
        } else BorderStroke(2.dp, Color.DarkGray)
    }

    fun modifyAciertos(aciertos: Int) {
        contadorAciertos = aciertos
    }



    val kahootEasy: List<Kahoot> = mutableListOf(
        Kahoot("¿Cuál es la capital de España?", mutableListOf("Madrid", "Barcelona", "Lisboa", "París"), "Geografía"),
        Kahoot("¿En qué año se firmó la Declaración de Independencia de Estados Unidos?", mutableListOf("1776", "1789", "1812", "1492"), "Historia"),
        Kahoot("¿Cuál es el elemento más abundante en la Tierra?", mutableListOf("Oxígeno", "Carbono", "Hierro", "Hidrógeno"), "Ciencia"),
        Kahoot("¿Quién escribió 'Don Quijote de la Mancha'?", mutableListOf("Miguel de Cervantes", "Gabriel García Márquez", "William Shakespeare", "Jane Austen"), "Literatura"),
        Kahoot("¿Cuántos huesos tiene el cuerpo humano adulto?", mutableListOf("206", "300", "150", "120"), "Anatomía"),
        Kahoot("¿Cuál es el océano más grande del mundo?", mutableListOf("Pacífico", "Atlántico", "Índico", "Ártico"), "Geografía"),
        Kahoot("¿Quién fue el primer presidente de Estados Unidos?", mutableListOf("George Washington", "Abraham Lincoln", "Thomas Jefferson", "John Adams"), "Historia"),
        Kahoot("¿Cuál es la fórmula química del agua?", mutableListOf("H2O", "CO2", "O2", "NaCl"), "Química"),
        Kahoot("¿Quién pintó 'La Noche Estrellada'?", mutableListOf("Vincent van Gogh", "Leonardo da Vinci", "Pablo Picasso", "Claude Monet"), "Arte"),
        Kahoot("¿En qué año comenzó la Segunda Guerra Mundial?", mutableListOf("1939", "1914", "1945", "1925"), "Historia"),
        Kahoot("¿Cuál es el río más largo del mundo?", mutableListOf("Amazonas", "Nilo", "Misisipi", "Yangtsé"), "Geografía"),
        Kahoot("¿Quién descubrió la penicilina?", mutableListOf("Alexander Fleming", "Marie Curie", "Louis Pasteur", "Albert Einstein"), "Ciencia"),
        Kahoot("¿Cuál es la capital de Japón?", mutableListOf("Tokio", "Pekín", "Seúl", "Bangkok"), "Geografía"),
        Kahoot("¿Qué gas es necesario para la fotosíntesis?", mutableListOf("Dióxido de carbono", "Oxígeno", "Nitrógeno", "Hidrógeno"), "Biología"),
        Kahoot("¿Cuántos planetas hay en nuestro sistema solar?", mutableListOf("Ocho", "Nueve", "Diez", "Doce"), "Astronomía"),
        Kahoot("¿En qué año se fundó la Organización de las Naciones Unidas (ONU)?", mutableListOf("1945", "1919", "1955", "1932"), "Historia"),
        Kahoot("¿Cuál es la moneda oficial de Australia?", mutableListOf("Dólar australiano", "Euro", "Libra esterlina", "Yen japonés"), "Economía"),
        Kahoot("¿Quién fue el primer hombre en llegar a la luna?", mutableListOf("Neil Armstrong", "Buzz Aldrin", "Yuri Gagarin", "Michael Collins"), "Historia"),
        Kahoot("¿Cuál es el desierto más grande del mundo?", mutableListOf("Sáhara", "Gobi", "Arábigo", "Karakum"), "Geografía"),
        Kahoot("¿Qué famoso científico formuló la teoría de la relatividad?", mutableListOf("Albert Einstein", "Isaac Newton", "Galileo Galilei", "Stephen Hawking"), "Ciencia"),
        Kahoot("¿Cuál es el río más largo de África?", mutableListOf("Nilo", "Amazonas", "Congo", "Misisipi"), "Geografía"),
        Kahoot("¿En qué año se proclamó la independencia de México?", mutableListOf("1821", "1810", "1835", "1848"), "Historia"),
        Kahoot("¿Cuál es la capital de Italia?", mutableListOf("Roma", "Milán", "París", "Madrid"), "Geografía"),
        Kahoot("¿Quién escribió 'Cien años de soledad'?", mutableListOf("Gabriel García Márquez", "Pablo Neruda", "Julio Cortázar", "Isabel Allende"), "Literatura"),
        Kahoot("¿Cuántos continentes hay en el mundo?", mutableListOf("Siete", "Cinco", "Seis", "Nueve"), "Geografía"),
        Kahoot("¿Cuál es el animal más grande del planeta?", mutableListOf("Ballena azul", "Elefante africano", "Jirafa", "Tiburón blanco"), "Biología"),
        Kahoot("¿En qué año se inauguró el Canal de Panamá?", mutableListOf("1914", "1900", "1925", "1935"), "Historia"),
        Kahoot("¿Cuál es el planeta más cercano al Sol?", mutableListOf("Mercurio", "Venus", "Marte", "Júpiter"), "Astronomía"),
        Kahoot("¿Quién fue el pintor del famoso cuadro 'La persistencia de la memoria'?", mutableListOf("Salvador Dalí", "Pablo Picasso", "Vincent van Gogh", "Leonardo da Vinci"), "Arte"),
        Kahoot("¿Cuál es el principal componente del aire que respiramos?", mutableListOf("Nitrógeno", "Oxígeno", "Dióxido de carbono", "Argón"), "Química"),
        Kahoot("¿Cuál es el país más grande del mundo en términos de territorio?", mutableListOf("Rusia", "Canadá", "Estados Unidos", "China"), "Geografía"),
        Kahoot("¿Quién fue el autor de 'El Principito'?", mutableListOf("Antoine de Saint-Exupéry", "J.K. Rowling", "Mark Twain", "Charles Dickens"), "Literatura"),
        Kahoot("¿En qué año se produjo la Revolución Rusa?", mutableListOf("1917", "1905", "1923", "1930"), "Historia"),
        Kahoot("¿Cuál es el océano más pequeño del mundo?", mutableListOf("Océano Ártico", "Océano Índico", "Océano Atlántico", "Océano Pacífico"), "Geografía"),
        Kahoot("¿Cuál es el componente principal de los huesos?", mutableListOf("Calcio", "Hierro", "Fósforo", "Magnesio"), "Anatomía"),
        Kahoot("¿Cuál es la capital de Canadá?", mutableListOf("Ottawa", "Toronto", "Montreal", "Vancouver"), "Geografía"),
        Kahoot("¿Quién fue el líder de la Revolución Cubana?", mutableListOf("Fidel Castro", "Che Guevara", "Camilo Cienfuegos", "Raúl Castro"), "Historia"),
        Kahoot("¿Cuál es el instrumento musical más grande de la orquesta?", mutableListOf("Contrabajo", "Tuba", "Trombón", "Corno"), "Música"),
        Kahoot("¿Cuántos colores tiene un arcoíris?", mutableListOf("Siete", "Cinco", "Nueve", "Diez"), "Ciencia"),
        Kahoot("¿En qué continente se encuentra la Gran Muralla China?", mutableListOf("Asia", "Europa", "África", "América"), "Geografía"),
        Kahoot("¿Cuál es la montaña más alta del mundo?", mutableListOf("Monte Everest", "K2", "Kangchenjunga", "Lhotse"), "Geografía"),
        Kahoot("¿Quién fue el famoso líder de los derechos civiles en Estados Unidos?", mutableListOf("Martin Luther King Jr.", "Malcolm X", "Rosa Parks", "John Lewis"), "Historia"),
        Kahoot("¿Cuál es la flor nacional de Japón?", mutableListOf("Sakura", "Rosa", "Orquídea", "Lirio"), "Botánica"),
        Kahoot("¿En qué año se celebró la primera Copa Mundial de la FIFA?", mutableListOf("1930", "1920", "1950", "1940"), "Deportes"),
        Kahoot("¿Cuál es el país más poblado del mundo?", mutableListOf("China", "India", "Estados Unidos", "Brasil"), "Demografía"),
        Kahoot("¿Quién fue el primer hombre en completar un viaje alrededor del mundo?", mutableListOf("Fernando de Magallanes", "James Cook", "Marco Polo", "Juan Sebastián Elcano"), "Historia"),
        Kahoot("¿Cuál es el componente principal del chocolate?", mutableListOf("Cacao", "Azúcar", "Leche", "Nuez"), "Culinaria"),
        Kahoot("¿En qué año se fundó la ciudad de Roma?", mutableListOf("753 a.C.", "500 a.C.", "200 a.C.", "100 d.C."), "Historia"),
        Kahoot("¿Cuál es el metal más abundante en la corteza terrestre?", mutableListOf("Aluminio", "Hierro", "Cobre", "Plomo"), "Minería"),
        Kahoot("¿Quién fue el primer presidente de México?", mutableListOf("Guadalupe Victoria", "Benito Juárez", "Miguel Hidalgo", "Porfirio Díaz"), "Historia"),
        Kahoot("¿Cuál es el lago más grande de África?", mutableListOf("Lago Victoria", "Lago Tanganica", "Lago Malawi", "Lago Turkana"), "Geografía"),
        Kahoot("¿Cuál es la moneda oficial de Brasil?", mutableListOf("Real", "Peso", "Dólar", "Euro"), "Economía"),
        Kahoot("¿Quién fue el fundador de Microsoft?", mutableListOf("Bill Gates", "Steve Jobs", "Mark Zuckerberg", "Larry Page"), "Tecnología"),
        Kahoot("¿En qué año se proclamó la independencia de Argentina?", mutableListOf("1816", "1820", "1830", "1840"), "Historia"),
        Kahoot("¿Cuál es el río más largo de Europa?", mutableListOf("Volga", "Danubio", "Rin", "Loira"), "Geografía"),
        Kahoot("¿Quién escribió 'Romeo y Julieta'?", mutableListOf("William Shakespeare", "Jane Austen", "Fiodor Dostoievski", "Gabriel García Márquez"), "Literatura"),
        Kahoot("¿Cuál es el país más pequeño del mundo?", mutableListOf("Ciudad del Vaticano", "Mónaco", "Nauru", "Tuvalu"), "Geografía"),
        Kahoot("¿En qué año se fundó la ciudad de Nueva York?", mutableListOf("1624", "1701", "1776", "1800"), "Historia"),
        Kahoot("¿Cuál es la velocidad de la luz?", mutableListOf("299,792,458 metros por segundo", "150,000,000 metros por segundo", "450,000,000 metros por segundo", "600,000,000 metros por segundo"), "Física"),
        Kahoot("¿Quién fue el primer emperador de China?", mutableListOf("Qin Shi Huang", "Han Wudi", "Kangxi", "Sun Yat-sen"), "Historia"),
        Kahoot("¿Cuál es el país más extenso de América del Sur?", mutableListOf("Brasil", "Argentina", "Colombia", "Perú"), "Geografía"),
        Kahoot("¿Cuál es el símbolo químico del oro?", mutableListOf("Au", "Ag", "Fe", "Cu"), "Química"),
        Kahoot("¿Quién fue la primera mujer en ganar un Premio Nobel?", mutableListOf("Marie Curie", "Rosa Parks", "Jane Goodall", "Malala Yousafzai"), "Historia"),
        Kahoot("¿Cuál es la cadena montañosa más larga del mundo?", mutableListOf("Cordillera de los Andes", "Himalaya", "Montañas Rocosas", "Alpes"), "Geografía"),
        Kahoot("¿Quién escribió '1984'?", mutableListOf("George Orwell", "Aldous Huxley", "Ray Bradbury", "J.K. Rowling"), "Literatura"),
        Kahoot("¿Cuál es el país con más islas en el mundo?", mutableListOf("Suecia", "Finlandia", "Indonesia", "Filipinas"), "Geografía"),
        Kahoot("¿En qué año se firmó la Declaración de Independencia de México?", mutableListOf("1821", "1810", "1835", "1848"), "Historia"),
        Kahoot("¿Cuál es el animal terrestre más grande?", mutableListOf("Elefante africano", "Rinoceronte blanco", "Hipopótamo", "Girafa"), "Biología"),
        Kahoot("¿Quién fue el primer astronauta en dar una vuelta completa a la Tierra?", mutableListOf("Yuri Gagarin", "Neil Armstrong", "Buzz Aldrin", "Alan Shepard"), "Historia"),
        Kahoot("¿Cuál es el país con más habitantes en el mundo?", mutableListOf("China", "India", "Estados Unidos", "Brasil"), "Demografía"),
        Kahoot("¿Quién fue el pintor del famoso cuadro 'Guernica'?", mutableListOf("Pablo Picasso", "Salvador Dalí", "Vincent van Gogh", "Claude Monet"), "Arte"),
        Kahoot("¿Cuál es el país más grande de América Latina?", mutableListOf("Brasil", "México", "Argentina", "Colombia"), "Geografía"),
        Kahoot("¿En qué año se fundó la ciudad de Nueva Delhi?", mutableListOf("1931", "1900", "1950", "1980"), "Historia"),
        Kahoot("¿Cuál es el animal nacional de Australia?", mutableListOf("Canguro", "Koala", "Emú", "Wombat"), "Biología"),
        Kahoot("¿Quién fue el autor de 'La Odisea'?", mutableListOf("Homero", "Sófocles", "Eurípides", "Aristóteles"), "Literatura"),
        Kahoot("¿Cuál es la capital de Canadá?", mutableListOf("Ottawa", "Toronto", "Montreal", "Vancouver"), "Geografía"),
        Kahoot("¿En qué año se celebró la Revolución Rusa?", mutableListOf("1917", "1905", "1923", "1930"), "Historia"),
        Kahoot("¿Cuál es el océano más pequeño del mundo?", mutableListOf("Océano Ártico", "Océano Índico", "Océano Atlántico", "Océano Pacífico"), "Geografía"),
        Kahoot("¿Cuál es el componente principal de los huesos?", mutableListOf("Calcio", "Hierro", "Fósforo", "Magnesio"), "Anatomía"),
        Kahoot("¿Cuál es la capital de China?", mutableListOf("Pekín", "Shanghái", "Hong Kong", "Guangzhou"), "Geografía"),
        Kahoot("¿Qué famoso científico formuló la teoría de la relatividad?", mutableListOf("Albert Einstein", "Isaac Newton", "Galileo Galilei", "Stephen Hawking"), "Ciencia"),
        Kahoot("¿Cuál es el río más largo de Europa?", mutableListOf("Volga", "Danubio", "Rin", "Loira"), "Geografía"),
        Kahoot("¿Quién fue el líder de la Revolución Cubana?", mutableListOf("Fidel Castro", "Che Guevara", "Camilo Cienfuegos", "Raúl Castro"), "Historia"),
        Kahoot("¿Cuál es el instrumento musical más grande de la orquesta?", mutableListOf("Contrabajo", "Tuba", "Trombón", "Corno"), "Música"),
        Kahoot("¿Cuántos colores tiene un arcoíris?", mutableListOf("Siete", "Cinco", "Nueve", "Diez"), "Ciencia"),
        Kahoot("¿En qué continente se encuentra la Gran Muralla China?", mutableListOf("Asia", "Europa", "África", "América"), "Geografía"),
        Kahoot("¿Cuál es el país más pequeño del mundo?", mutableListOf("Ciudad del Vaticano", "Mónaco", "Nauru", "Tuvalu"), "Geografía"),
        Kahoot("¿En qué año se fundó la ciudad de Nueva York?", mutableListOf("1624", "1701", "1776", "1800"), "Historia"),
        Kahoot("¿Cuál es la velocidad de la luz?", mutableListOf("299,792,458 metros por segundo", "150,000,000 metros por segundo", "450,000,000 metros por segundo", "600,000,000 metros por segundo"), "Física"),
        Kahoot("¿Quién fue el primer emperador de China?", mutableListOf("Qin Shi Huang", "Han Wudi", "Kangxi", "Sun Yat-sen"), "Historia"),
        Kahoot("¿Cuál es el país más extenso de América del Sur?", mutableListOf("Brasil", "Argentina", "Colombia", "Perú"), "Geografía"),
        Kahoot("¿Cuál es el símbolo químico del oro?", mutableListOf("Au", "Ag", "Fe", "Cu"), "Química"),
        Kahoot("¿Quién fue la primera mujer en ganar un Premio Nobel?", mutableListOf("Marie Curie", "Rosa Parks", "Jane Goodall", "Malala Yousafzai"), "Historia"),
        Kahoot("¿Cuál es la cadena montañosa más larga del mundo?", mutableListOf("Cordillera de los Andes", "Himalaya", "Montañas Rocosas", "Alpes"), "Geografía"),
        Kahoot("¿Quién escribió '1984'?", mutableListOf("George Orwell", "Aldous Huxley", "Ray Bradbury", "J.K. Rowling"), "Literatura"),
        Kahoot("¿Cuál es el país con más islas en el mundo?", mutableListOf("Suecia", "Finlandia", "Indonesia", "Filipinas"), "Geografía"),
        Kahoot("¿En qué año se firmó la Declaración de Independencia de México?", mutableListOf("1821", "1810", "1835", "1848"), "Historia"),
        Kahoot("¿Cuál es el animal terrestre más grande?", mutableListOf("Elefante africano", "Rinoceronte blanco", "Hipopótamo", "Girafa"), "Biología"),
        Kahoot("¿Quién fue el primer astronauta en dar una vuelta completa a la Tierra?", mutableListOf("Yuri Gagarin", "Neil Armstrong", "Buzz Aldrin", "Alan Shepard"), "Historia"),
        Kahoot("¿Cuál es el país con más habitantes en el mundo?", mutableListOf("China", "India", "Estados Unidos", "Brasil"), "Demografía"),
        Kahoot("¿Quién fue el pintor del famoso cuadro 'Guernica'?", mutableListOf("Pablo Picasso", "Salvador Dalí", "Vincent van Gogh", "Claude Monet"), "Arte")
    )


    val kahootMedium: List<Kahoot> = mutableListOf(
        Kahoot("¿Cuál es la capital de Australia?", mutableListOf("Canberra", "Sídney", "Melbourne", "Brisbane"), "Geografía"),
        Kahoot("¿En qué año se inauguró la Torre Eiffel?", mutableListOf("1889", "1899", "1909", "1879"), "Historia"),
        Kahoot("¿Cuántos elementos químicos tiene la tabla periódica?", mutableListOf("118", "92", "109", "130"), "Química"),
        Kahoot("¿Quién escribió 'El Gran Gatsby'?", mutableListOf("F. Scott Fitzgerald", "Ernest Hemingway", "J.D. Salinger", "Harper Lee"), "Literatura"),
        Kahoot("¿En qué año se celebró la primera Copa Mundial de la FIFA?", mutableListOf("1930", "1920", "1950", "1940"), "Deportes"),
        Kahoot("¿Cuántos continentes hay en el mundo?", mutableListOf("Siete", "Cinco", "Seis", "Nueve"), "Geografía"),
        Kahoot("¿Cuál es el proceso por el cual las plantas fabrican su propio alimento?", mutableListOf("Fotosíntesis", "Respiración", "Transpiración", "Germinación"), "Biología"),
        Kahoot("¿Quién fue el primer presidente de Estados Unidos?", mutableListOf("George Washington", "Abraham Lincoln", "Thomas Jefferson", "John Adams"), "Historia"),
        Kahoot("¿Cuál es el río más largo del mundo?", mutableListOf("Amazonas", "Nilo", "Misisipi", "Yangtsé"), "Geografía"),
        Kahoot("¿En qué año se firmó la Declaración de Independencia de Estados Unidos?", mutableListOf("1776", "1789", "1812", "1492"), "Historia"),
        Kahoot("¿Cuál es la montaña más alta del mundo?", mutableListOf("Monte Everest", "K2", "Kangchenjunga", "Lhotse"), "Geografía"),
        Kahoot("¿Quién fue el famoso líder de los derechos civiles en Estados Unidos?", mutableListOf("Martin Luther King Jr.", "Malcolm X", "Rosa Parks", "John Lewis"), "Historia"),
        Kahoot("¿Cuál es la flor nacional de Japón?", mutableListOf("Sakura", "Rosa", "Orquídea", "Lirio"), "Botánica"),
        Kahoot("¿En qué año se llevó a cabo la Revolución Industrial?", mutableListOf("Siglo XVIII", "Siglo XIX", "Siglo XX", "Siglo XVII"), "Historia"),
        Kahoot("¿Cuál es el símbolo químico del oro?", mutableListOf("Au", "Ag", "Fe", "Cu"), "Química"),
        Kahoot("¿Quién fue la primera mujer en ganar un Premio Nobel?", mutableListOf("Marie Curie", "Rosa Parks", "Jane Goodall", "Malala Yousafzai"), "Historia"),
        Kahoot("¿Cuál es la cadena montañosa más larga del mundo?", mutableListOf("Cordillera de los Andes", "Himalaya", "Montañas Rocosas", "Alpes"), "Geografía"),
        Kahoot("¿Quién escribió '1984'?", mutableListOf("George Orwell", "Aldous Huxley", "Ray Bradbury", "J.K. Rowling"), "Literatura"),
        Kahoot("¿Cuál es el país con más islas en el mundo?", mutableListOf("Suecia", "Finlandia", "Indonesia", "Filipinas"), "Geografía"),
        Kahoot("¿En qué año se fundó la ciudad de Nueva York?", mutableListOf("1624", "1701", "1776", "1800"), "Historia"),
        Kahoot("¿Cuál es la moneda oficial de Brasil?", mutableListOf("Real", "Peso", "Dólar", "Euro"), "Economía"),
        Kahoot("¿Quién fue el fundador de Microsoft?", mutableListOf("Bill Gates", "Steve Jobs", "Mark Zuckerberg", "Larry Page"), "Tecnología"),
        Kahoot("¿En qué año se proclamó la independencia de Argentina?", mutableListOf("1816", "1820", "1830", "1840"), "Historia"),
        Kahoot("¿Cuál es el río más largo de Europa?", mutableListOf("Volga", "Danubio", "Rin", "Loira"), "Geografía"),
        Kahoot("¿Quién escribió 'Romeo y Julieta'?", mutableListOf("William Shakespeare", "Jane Austen", "Fiodor Dostoievski", "Gabriel García Márquez"), "Literatura"),
        Kahoot("¿Cuál es el país más pequeño del mundo?", mutableListOf("Ciudad del Vaticano", "Mónaco", "Nauru", "Tuvalu"), "Geografía"),
        Kahoot("¿En qué año se fundó la ciudad de Roma?", mutableListOf("753 a.C.", "500 a.C.", "200 a.C.", "100 d.C."), "Historia"),
        Kahoot("¿Cuál es el metal más abundante en la corteza terrestre?", mutableListOf("Aluminio", "Hierro", "Cobre", "Plomo"), "Minería"),
        Kahoot("¿Quién fue el primer presidente de México?", mutableListOf("Guadalupe Victoria", "Benito Juárez", "Miguel Hidalgo", "Porfirio Díaz"), "Historia"),
        Kahoot("¿Cuál es el lago más grande de África?", mutableListOf("Lago Victoria", "Lago Tanganica", "Lago Malawi", "Lago Turkana"), "Geografía"),
        Kahoot("¿Cuál es el instrumento musical más grande de la orquesta?", mutableListOf("Contrabajo", "Tuba", "Trombón", "Corno"), "Música"),
        Kahoot("¿Cuántos colores tiene un arcoíris?", mutableListOf("Siete", "Cinco", "Nueve", "Diez"), "Ciencia"),
        Kahoot("¿En qué continente se encuentra la Gran Muralla China?", mutableListOf("Asia", "Europa", "África", "América"), "Geografía"),
        Kahoot("¿Cuál es el país más pequeño del mundo?", mutableListOf("Ciudad del Vaticano", "Mónaco", "Nauru", "Tuvalu"), "Geografía"),
        Kahoot("¿Cuál es la velocidad de la luz?", mutableListOf("299,792,458 metros por segundo", "150,000,000 metros por segundo", "450,000,000 metros por segundo", "600,000,000 metros por segundo"), "Física"),
        Kahoot("¿Cuál es el instrumento musical más antiguo del mundo?", mutableListOf("Lira", "Flauta", "Tambor", "Arpa"), "Música"),
        Kahoot("¿En qué año se llevó a cabo la Revolución Industrial?", mutableListOf("Siglo XVIII", "Siglo XIX", "Siglo XX", "Siglo XVII"), "Historia"),
        Kahoot("¿Cuál es el metal más ligero?", mutableListOf("Aluminio", "Hierro", "Cobre", "Oro"), "Química"),
        Kahoot("¿Quién fue el primer presidente de Estados Unidos que apareció en televisión?", mutableListOf("Franklin D. Roosevelt", "John F. Kennedy", "Dwight D. Eisenhower", "Harry S. Truman"), "Historia"),
        Kahoot("¿Cuál es el océano más profundo?", mutableListOf("Océano Pacífico", "Océano Atlántico", "Océano Índico", "Océano Ártico"), "Geografía"),
        Kahoot("¿Cuál es el país más grande de América Latina?", mutableListOf("Brasil", "México", "Argentina", "Colombia"), "Geografía"),
        Kahoot("¿En qué año se fundó la ciudad de Nueva Delhi?", mutableListOf("1931", "1900", "1950", "1980"), "Historia"),
        Kahoot("¿Cuál es el animal nacional de Australia?", mutableListOf("Canguro", "Koala", "Emú", "Wombat"), "Biología"),
        Kahoot("¿Quién fue el autor de 'La Odisea'?", mutableListOf("Homero", "Sófocles", "Eurípides", "Aristóteles"), "Literatura"),
        Kahoot("¿Cuál es la capital de Canadá?", mutableListOf("Ottawa", "Toronto", "Montreal", "Vancouver"), "Geografía"),
        Kahoot("¿En qué año se celebró la Revolución Rusa?", mutableListOf("1917", "1905", "1923", "1930"), "Historia"),
        Kahoot("¿Cuál es el océano más pequeño del mundo?", mutableListOf("Océano Ártico", "Océano Índico", "Océano Atlántico", "Océano Pacífico"), "Geografía"),
        Kahoot("¿Cuál es el componente principal de los huesos?", mutableListOf("Calcio", "Hierro", "Fósforo", "Magnesio"), "Anatomía"),
        Kahoot("¿Cuál es la capital de China?", mutableListOf("Pekín", "Shanghái", "Hong Kong", "Guangzhou"), "Geografía"),
        Kahoot("¿Qué famoso científico formuló la teoría de la relatividad?", mutableListOf("Albert Einstein", "Isaac Newton", "Galileo Galilei", "Stephen Hawking"), "Ciencia"),
        Kahoot("¿Cuál es el río más largo de Europa?", mutableListOf("Volga", "Danubio", "Rin", "Loira"), "Geografía"),
        Kahoot("¿Quién fue el líder de la Revolución Cubana?", mutableListOf("Fidel Castro", "Che Guevara", "Camilo Cienfuegos", "Raúl Castro"), "Historia"),
        Kahoot("¿Cuál es el instrumento musical más grande de la orquesta?", mutableListOf("Contrabajo", "Tuba", "Trombón", "Corno"), "Música"),
        Kahoot("¿Cuántos colores tiene un arcoíris?", mutableListOf("Siete", "Cinco", "Nueve", "Diez"), "Ciencia"),
        Kahoot("¿En qué continente se encuentra la Gran Muralla China?", mutableListOf("Asia", "Europa", "África", "América"), "Geografía"),
        Kahoot("¿Cuál es el país más pequeño del mundo?", mutableListOf("Ciudad del Vaticano", "Mónaco", "Nauru", "Tuvalu"), "Geografía"),
        Kahoot("¿En qué año se fundó la ciudad de Nueva York?", mutableListOf("1624", "1701", "1776", "1800"), "Historia"),
        Kahoot("¿Cuál es la velocidad de la luz?", mutableListOf("299,792,458 m/s", "150,000,000 m/s", "450,000,000 m/s", "600,000,000 m/s"), "Física"),
        Kahoot("¿Quién fue el primer emperador de China?", mutableListOf("Qin Shi Huang", "Han Wudi", "Kangxi", "Sun Yat-sen"), "Historia"),
        Kahoot("¿Cuál es el país más extenso de América del Sur?", mutableListOf("Brasil", "Argentina", "Colombia", "Perú"), "Geografía"),
        Kahoot("¿Cuál es el símbolo químico del oro?", mutableListOf("Au", "Ag", "Fe", "Cu"), "Química"),
        Kahoot("¿Quién fue la primera mujer en ganar un Premio Nobel?", mutableListOf("Marie Curie", "Rosa Parks", "Jane Goodall", "Malala Yousafzai"), "Historia"),
        Kahoot("¿Cuál es la cadena montañosa más larga del mundo?", mutableListOf("Cordillera de los Andes", "Himalaya", "Montañas Rocosas", "Alpes"), "Geografía"),
        Kahoot("¿Quién escribió '1984'?", mutableListOf("George Orwell", "Aldous Huxley", "Ray Bradbury", "J.K. Rowling"), "Literatura"),
        Kahoot("¿Cuál es el país con más islas en el mundo?", mutableListOf("Suecia", "Finlandia", "Indonesia", "Filipinas"), "Geografía"),
        Kahoot("¿En qué año se firmó la Declaración de Independencia de México?", mutableListOf("1821", "1810", "1835", "1848"), "Historia"),
        Kahoot("¿Cuál es el río más largo de Asia?", mutableListOf("Yangtsé", "Mekong", "Ganges", "Amur"), "Geografía"),
        Kahoot("¿Quién fue el famoso líder de los derechos civiles en Estados Unidos?", mutableListOf("Martin Luther King Jr.", "Malcolm X", "Rosa Parks", "John Lewis"), "Historia"),
        Kahoot("¿Cuál es la flor nacional de Japón?", mutableListOf("Sakura", "Rosa", "Orquídea", "Lirio"), "Botánica"),
        Kahoot("¿En qué año se llevó a cabo la Revolución Industrial?", mutableListOf("Siglo XVIII", "Siglo XIX", "Siglo XX", "Siglo XVII"), "Historia"),
        Kahoot("¿Cuál es el país más poblado del mundo?", mutableListOf("China", "India", "Estados Unidos", "Brasil"), "Demografía"),
        Kahoot("¿Quién fue el autor de 'Cien años de soledad'?", mutableListOf("Gabriel García Márquez", "Mario Vargas Llosa", "Julio Cortázar", "Pablo Neruda"), "Literatura"),
        Kahoot("¿Cuál es la capital de Sudáfrica?", mutableListOf("Pretoria", "Ciudad del Cabo", "Bloemfontein", "Johannesburgo"), "Geografía"),
        Kahoot("¿En qué año se llevó a cabo la Revolución Francesa?", mutableListOf("1789", "1799", "1809", "1779"), "Historia"),
        Kahoot("¿Cuál es el río más largo de América del Norte?", mutableListOf("Mississippi", "Missouri", "Yukón", "Colorado"), "Geografía"),
        Kahoot("¿Quién fue el primer presidente de Estados Unidos que apareció en televisión?", mutableListOf("Franklin D. Roosevelt", "John F. Kennedy", "Dwight D. Eisenhower", "Harry S. Truman"), "Historia"),
        Kahoot("¿Cuál es el país más grande de África?", mutableListOf("Argelia", "República Democrática del Congo", "Sudán", "Libia"), "Geografía"),
        Kahoot("¿Quién fue el pintor del famoso cuadro 'La Noche Estrellada'?", mutableListOf("Vincent van Gogh", "Leonardo da Vinci", "Pablo Picasso", "Claude Monet"), "Arte"),
        Kahoot("¿En qué año se proclamó la independencia de Brasil?", mutableListOf("1822", "1808", "1835", "1848"), "Historia"),
        Kahoot("¿Cuál es la montaña más alta del sistema solar?", mutableListOf("Monte Olimpo", "Monte Everest", "Mauna Kea", "Kangchenjunga"), "Astronomía"),
        Kahoot("¿Cuál es el país más grande de Europa?", mutableListOf("Rusia", "Francia", "Alemania", "España"), "Geografía"),
        Kahoot("¿Quién escribió 'El Principito'?", mutableListOf("Antoine de Saint-Exupéry", "Gabriel García Márquez", "J.K. Rowling", "Jane Austen"), "Literatura"),
        Kahoot("¿Cuántos huesos tiene el cuerpo humano?", mutableListOf("206", "180", "250", "300"), "Anatomía"),
        Kahoot("¿En qué año se fundó la ONU?", mutableListOf("1945", "1950", "1930", "1960"), "Historia"),
        Kahoot("¿Cuál es el planeta más grande del sistema solar?", mutableListOf("Júpiter", "Saturno", "Marte", "Venus"), "Astronomía"),
        Kahoot("¿Cuál es la capital de Australia?", mutableListOf("Canberra", "Sídney", "Melbourne", "Brisbane"), "Geografía"),
        Kahoot("¿Quién fue el primer presidente de Estados Unidos?", mutableListOf("George Washington", "Thomas Jefferson", "John Adams", "James Madison"), "Historia"),
        Kahoot("¿Cuál es el componente principal del aire que respiramos?", mutableListOf("Nitrógeno", "Oxígeno", "Dióxido de carbono", "Argón"), "Química"),
        Kahoot("¿En qué año se fundó la Cruz Roja?", mutableListOf("1863", "1875", "1850", "1888"), "Historia"),
        Kahoot("¿Cuál es la capital de Japón?", mutableListOf("Tokio", "Osaka", "Kioto", "Sapporo"), "Geografía"),
        Kahoot("¿Cuál es el símbolo químico del hidrógeno?", mutableListOf("H", "He", "O", "N"), "Química"),
        Kahoot("¿Quién fue el primer hombre en llegar a la Luna?", mutableListOf("Neil Armstrong", "Buzz Aldrin", "Yuri Gagarin", "Alan Shepard"), "Historia"),
        Kahoot("¿Cuántos continentes hay en el mundo?", mutableListOf("7", "5", "6", "8"), "Geografía"),
        Kahoot("¿Cuál es el metal más abundante en la corteza terrestre?", mutableListOf("Aluminio", "Hierro", "Cobre", "Oro"), "Química"),
        Kahoot("¿En qué año se descubrió América?", mutableListOf("1492", "1500", "1450", "1510"), "Historia"),
        Kahoot("¿Cuál es el océano más cálido?", mutableListOf("Océano Índico", "Océano Pacífico", "Océano Atlántico", "Océano Ártico"), "Geografía"),
        Kahoot("¿Quién pintó 'La última cena'?", mutableListOf("Leonardo da Vinci", "Pablo Picasso", "Vincent van Gogh", "Claude Monet"), "Arte"),
        Kahoot("¿Cuál es la moneda oficial de Japón?", mutableListOf("Yen", "Dólar", "Euro", "Libra"), "Economía"),
        Kahoot("¿En qué año se inauguró el Canal de Panamá?", mutableListOf("1914", "1900", "1925", "1930"), "Historia"),
        Kahoot("¿Cuál es la lengua más hablada del mundo?", mutableListOf("Chino mandarín", "Español", "Inglés", "Hindi"), "Lingüística"),
        Kahoot("¿Quién fue la primera mujer en ganar un Premio Nobel de la Paz?", mutableListOf("Jane Addams", "Mother Teresa", "Rigoberta Menchú", "Malala Yousafzai"), "Historia")
    )


    val kahootHard: List<Kahoot> = mutableListOf(
        Kahoot("¿Cuál es el gas noble más pesado?", mutableListOf("Radón", "Xenón", "Kriptón", "Argón"), "Química"),
        Kahoot("¿Quién fue el primer científico en formular la teoría del Big Bang?", mutableListOf("Georges Lemaître", "Albert Einstein", "Stephen Hawking", "Edwin Hubble"), "Cosmología"),
        Kahoot("¿Cuál es el segundo libro más vendido de la historia después de la Biblia?", mutableListOf("Citas del Presidente Mao", "Don Quijote", "Harry Potter", "El Señor de los Anillos"), "Literatura"),
        Kahoot("¿Qué elemento químico tiene el número atómico 92?", mutableListOf("Uranio", "Plutonio", "Neptunio", "Torio"), "Química"),
        Kahoot("¿En qué año se firmó el Tratado de Versalles que puso fin a la Primera Guerra Mundial?", mutableListOf("1919", "1918", "1920", "1921"), "Historia"),
        Kahoot("¿Cuál es la montaña más alta fuera de Asia?", mutableListOf("Monte Aconcagua", "Monte McKinley", "Monte Vinson", "Monte Kilimanjaro"), "Geografía"),
        Kahoot("¿Cuál es el único planeta del sistema solar que rota en sentido horario?", mutableListOf("Venus", "Urano", "Júpiter", "Marte"), "Astronomía"),
        Kahoot("¿Quién escribió 'En busca del tiempo perdido'?", mutableListOf("Marcel Proust", "James Joyce", "Fyodor Dostoevsky", "Leo Tolstoy"), "Literatura"),
        Kahoot("¿Cuál es el mineral más duro en la escala de Mohs?", mutableListOf("Diamante", "Cuarzo", "Topacio", "Corindón"), "Minería"),
        Kahoot("¿En qué año se completó la construcción de la Gran Muralla China?", mutableListOf("1644", "221 a.C.", "1368", "1279"), "Historia"),
        Kahoot("¿Cuál es la partícula subatómica con carga positiva?", mutableListOf("Protón", "Neutrón", "Electrón", "Mesón"), "Física"),
        Kahoot("¿Qué ciudad fue la capital del Imperio Romano de Occidente antes de su caída?", mutableListOf("Roma", "Constantinopla", "Milán", "Cartago"), "Historia"),
        Kahoot("¿Cuál es la fórmula química del ácido sulfúrico?", mutableListOf("H2SO4", "HCl", "NaOH", "CO2"), "Química"),
        Kahoot("¿Quién fue el arquitecto principal del Renacimiento italiano?", mutableListOf("Leon Battista Alberti", "Brunelleschi", "Andrea Palladio", "Michelozzo"), "Arte"),
        Kahoot("¿Cuál es el metal más raro de la Tierra?", mutableListOf("Rodio", "Iridio", "Osmio", "Paladio"), "Química"),
        Kahoot("¿Qué enfermedad causa la falta de vitamina C?", mutableListOf("Escorbuto", "Beriberi", "Pellagra", "Raquitismo"), "Medicina"),
        Kahoot("¿Quién fue el faraón que construyó la Gran Pirámide de Giza?", mutableListOf("Keops", "Kefrén", "Micerino", "Hatshepsut"), "Historia"),
        Kahoot("¿En qué año se llevó a cabo la Revolución Rusa?", mutableListOf("1917", "1905", "1923", "1930"), "Historia"),
        Kahoot("¿Cuál es el país más pequeño de Asia por área?", mutableListOf("Maldivas", "Singapur", "Brunei", "Lebanón"), "Geografía"),
        Kahoot("¿Qué instrumento mide la intensidad de los terremotos?", mutableListOf("Sismógrafo", "Radar", "Anemómetro", "Barómetro"), "Geofísica"),
        Kahoot("¿Cuál es el río más largo de África?", mutableListOf("Nilo", "Congo", "Níger", "Zambeze"), "Geografía"),
        Kahoot("¿Quién descubrió la penicilina?", mutableListOf("Alexander Fleming", "Louis Pasteur", "Joseph Lister", "Robert Koch"), "Medicina"),
        Kahoot("¿Cuál es el océano más profundo del mundo?", mutableListOf("Océano Pacífico", "Océano Atlántico", "Océano Índico", "Océano Ártico"), "Geografía"),
        Kahoot("¿En qué año se fundó la ciudad de Bagdad?", mutableListOf("762", "810", "836", "889"), "Historia"),
        Kahoot("¿Cuál es el componente principal de la atmósfera de Marte?", mutableListOf("Dióxido de carbono", "Nitrógeno", "Oxígeno", "Metano"), "Astronomía"),
        Kahoot("¿Quién fue el primer emperador de China?", mutableListOf("Qin Shi Huang", "Han Wudi", "Kangxi", "Sun Yat-sen"), "Historia"),
        Kahoot("¿En qué año se firmó la Declaración de Independencia de México?", mutableListOf("1821", "1810", "1835", "1848"), "Historia"),
        Kahoot("¿Cuál es el animal más veloz en tierra?", mutableListOf("Guepardo", "León", "Leopardo", "Lobo"), "Biología"),
        Kahoot("¿Qué isla es conocida como 'La Isla de la Estatua'?", mutableListOf("Isla de Pascua", "Isla de Man", "Isla de Wight", "Isla de Skye"), "Geografía"),
        Kahoot("¿Quién escribió 'El Otoño del Patriarca'?", mutableListOf("Gabriel García Márquez", "Julio Cortázar", "Isabel Allende", "Mario Vargas Llosa"), "Literatura"),
        Kahoot("¿Cuál es el metal más caro del mundo?", mutableListOf("Rodio", "Oro", "Platino", "Paladio"), "Química"),
        Kahoot("¿En qué año se fundó la Royal Society en Inglaterra?", mutableListOf("1660", "1701", "1753", "1804"), "Historia"),
        Kahoot("¿Cuál es la especie de tiburón más grande?", mutableListOf("Tiburón ballena", "Gran tiburón blanco", "Tiburón martillo", "Tiburón tigre"), "Biología"),
        Kahoot("¿Quién fue el primer presidente de la República Popular China?", mutableListOf("Mao Zedong", "Chiang Kai-shek", "Sun Yat-sen", "Deng Xiaoping"), "Historia"),
        Kahoot("¿Cuál es el río más largo de América del Sur?", mutableListOf("Amazonas", "Orinoco", "Paraná", "Magdalena"), "Geografía"),
        Kahoot("¿En qué año se inauguró el Canal de Suez?", mutableListOf("1869", "1850", "1885", "1901"), "Historia"),
        Kahoot("¿Cuál es el símbolo químico del platino?", mutableListOf("Pt", "Au", "Ag", "Pd"), "Química"),
        Kahoot("¿Cuál es el metal más abundante en la corteza terrestre?", mutableListOf("Aluminio", "Hierro", "Cobre", "Oro"), "Química"),
        Kahoot("¿En qué año se estableció el Imperio Mongol?", mutableListOf("1206", "1258", "1300", "1356"), "Historia"),
        Kahoot("¿Cuál es el hueso más largo del cuerpo humano?", mutableListOf("Fémur", "Húmero", "Tibia", "Radio"), "Anatomía"),
        Kahoot("¿Quién fue el primer hombre en recibir un trasplante de corazón?", mutableListOf("Louis Washkansky", "Christiaan Barnard", "Adrian Kantrowitz", "Norman Shumway"), "Medicina"),
        Kahoot("¿Cuál es la órbita más alejada de Plutón en su periodo orbital?", mutableListOf("Neptuno", "Eris", "Haumea", "Makemake"), "Astronomía"),
        Kahoot("¿En qué año se descubrió el bosón de Higgs?", mutableListOf("2012", "2008", "2010", "2015"), "Física"),
        Kahoot("¿Quién fue el primer presidente de Sudáfrica elegido democráticamente?", mutableListOf("Nelson Mandela", "F.W. de Klerk", "Thabo Mbeki", "Cyril Ramaphosa"), "Historia"),
        Kahoot("¿Cuál es la molécula responsable del efecto invernadero en la Tierra?", mutableListOf("Dióxido de carbono", "Metano", "Óxidos de nitrógeno", "Vapor de agua"), "Ecología"),
        Kahoot("¿Quién fue el primer emperador romano?", mutableListOf("César Augusto", "Julio César", "Calígula", "Nerón"), "Historia"),
        Kahoot("¿Cuál es la especie de serpiente más venenosa?", mutableListOf("Taipán del interior", "Cobra real", "Mamba negra", "Víbora de Russell"), "Biología"),
        Kahoot("¿En qué año se fundó la ciudad de Roma?", mutableListOf("753 a.C.", "800 a.C.", "700 a.C.", "600 a.C."), "Historia"),
        Kahoot("¿Cuál es el compuesto químico responsable del mal olor de los pies?", mutableListOf("Isovalerato de isobutilo", "Ácido isovalérico", "Trimetilamina", "Ácido butírico"), "Química"),
        Kahoot("¿Quién fue el último faraón de Egipto?", mutableListOf("Cleopatra VII", "Ptolomeo XV", "Nectanebo II", "Akenatón"), "Historia"),
        Kahoot("¿Cuál es el país más poblado del mundo?", mutableListOf("China", "India", "Estados Unidos", "Indonesia"), "Demografía"),
        Kahoot("¿En qué año se fundó la Organización de las Naciones Unidas (ONU)?", mutableListOf("1945", "1950", "1930", "1960"), "Historia"),
        Kahoot("¿Cuál es el único planeta que rota en sentido antihorario en nuestro sistema solar?", mutableListOf("Venus", "Urano", "Júpiter", "Marte"), "Astronomía"),
        Kahoot("¿Quién fue el primer explorador en circunnavegar la Tierra?", mutableListOf("Fernando de Magallanes", "Juan Sebastián Elcano", "Christopher Columbus", "James Cook"), "Historia"),
        Kahoot("¿Cuál es la longitud del ecuador terrestre en kilómetros?", mutableListOf("40,075 km", "35,000 km", "45,000 km", "50,000 km"), "Geografía"),
        Kahoot("¿Quién fue el autor de 'El Príncipe'?", mutableListOf("Maquiavelo", "Tomás de Aquino", "John Locke", "Montesquieu"), "Filosofía"),
        Kahoot("¿Cuál es el átomo más abundante en el universo?", mutableListOf("Hidrógeno", "Helio", "Oxígeno", "Carbono"), "Astronomía"),
        Kahoot("¿En qué año se promulgó la Declaración de Derechos de Estados Unidos?", mutableListOf("1791", "1776", "1789", "1803"), "Historia"),
        Kahoot("¿Cuál es el componente principal del sistema de escritura cuneiforme?", mutableListOf("Cálamo", "Arcilla", "Papiro", "Bambú"), "Historia Antigua"),
        Kahoot("¿Quién fue el primer filósofo griego conocido como 'el padre de la filosofía'?", mutableListOf("Tales de Mileto", "Sócrates", "Platón", "Aristóteles"), "Filosofía"),
        Kahoot("¿Cuál es la fórmula química del agua oxigenada?", mutableListOf("H2O2", "H2O", "HO", "H3O+"), "Química"),
        Kahoot("¿Quién fue el autor de 'La Guerra y la Paz'?", mutableListOf("León Tolstói", "Fiodor Dostoievski", "Antón Chéjov", "Iván Turguénev"), "Literatura"),
        Kahoot("¿Cuál es el monte más alto de África?", mutableListOf("Monte Kilimanjaro", "Monte Kenia", "Monte Elbrús", "Monte Ruapehu"), "Geografía"),
        Kahoot("¿En qué año se firmó el Tratado de Tordesillas?", mutableListOf("1494", "1500", "1521", "1556"), "Historia"),
        Kahoot("¿Cuál es el componente principal del aceite de oliva?", mutableListOf("Ácido oleico", "Ácido linoleico", "Ácido palmítico", "Ácido esteárico"), "Química"),
        Kahoot("¿Quién fue el autor de 'La Odisea'?", mutableListOf("Homero", "Sófocles", "Eurípides", "Esquilo"), "Literatura"),
        Kahoot("¿Cuál es el animal más grande del mundo?", mutableListOf("Ballena azul", "Elefante africano", "Tiburón ballena", "Orca"), "Biología"),
        Kahoot("¿En qué año se estableció el Imperio Romano?", mutableListOf("27 a.C.", "100 a.C.", "150 d.C.", "200 d.C."), "Historia"),
        Kahoot("¿Cuál es el río más largo de Europa?", mutableListOf("Volga", "Danubio", "Támesis", "Sena"), "Geografía"),
        Kahoot("¿Quién fue el primer presidente de Estados Unidos?", mutableListOf("George Washington", "John Adams", "Thomas Jefferson", "James Madison"), "Historia"),
        Kahoot("¿Cuál es el país más pequeño del mundo por superficie terrestre?", mutableListOf("Ciudad del Vaticano", "Mónaco", "Nauru", "Tuvalu"), "Geografía"),
        Kahoot("¿En qué año se proclamó la independencia de Brasil?", mutableListOf("1822", "1808", "1835", "1850"), "Historia"),
        Kahoot("¿Cuál es el gas más abundante en la atmósfera terrestre?", mutableListOf("Nitrógeno", "Oxígeno", "Argón", "Dióxido de carbono"), "Química"),
        Kahoot("¿Quién fue el primer ser humano en viajar al espacio dos veces?", mutableListOf("Gherman Titov", "Yuri Gagarin", "John Glenn", "Valentina Tereshkova"), "Astronáutica"),
        Kahoot("¿Cuál es el país más extenso del mundo?", mutableListOf("Rusia", "Canadá", "Estados Unidos", "China"), "Geografía"),
        Kahoot("¿En qué año se llevó a cabo la Revolución Francesa?", mutableListOf("1789", "1776", "1804", "1815"), "Historia"),
        Kahoot("¿Cuál es el hueso más pequeño del cuerpo humano?", mutableListOf("Estribo", "Martillo", "Yunque", "Coclea"), "Anatomía"),
        Kahoot("¿Quién fue el último emperador de México antes de su independencia?", mutableListOf("Agustín de Iturbide", "Fernando Maximiliano", "Benito Juárez", "Emperatriz Carlota"), "Historia"),
        Kahoot("¿Cuál es el compuesto químico del gas natural?", mutableListOf("Metano", "Etano", "Propano", "Butano"), "Química"),
        Kahoot("¿En qué año se fundó la Liga de las Naciones?", mutableListOf("1920", "1919", "1930", "1945"), "Historia"),
        Kahoot("¿Cuál es el desierto más grande del mundo?", mutableListOf("Antártida", "Sáhara", "Arábigo", "Gobi"), "Geografía"),
        Kahoot("¿Quién fue el último faraón de Egipto?", mutableListOf("Cleopatra VII", "Nectanebo II", "Ptolomeo XV", "Akenatón"), "Historia"),
        Kahoot("¿Cuál es la especie de árbol más alta del mundo?", mutableListOf("Secuoya gigante", "Eucalipto", "Pino de Bristlecone", "Caoba"), "Botánica"),
        Kahoot("¿En qué año se fundó la UNESCO?", mutableListOf("1945", "1950", "1965", "1972"), "Historia"),
        Kahoot("¿Cuál es el animal más antiguo del planeta Tierra?", mutableListOf("Sifonóforo", "Tortuga", "Cangrejo herradura", "Tiburón"), "Biología"),
        Kahoot("¿Quién fue el primer hombre en realizar un viaje a la luna?", mutableListOf("Neil Armstrong", "Buzz Aldrin", "Yuri Gagarin", "Michael Collins"), "Astronáutica"),
        Kahoot("¿Cuál es la especie de mono más grande?", mutableListOf("Mandril", "Gorila", "Orangután", "Chimpancé"), "Biología"),
        Kahoot("¿En qué año se llevó a cabo la Guerra de Vietnam?", mutableListOf("1955-1975", "1961-1973", "1945-1954", "1979-1989"), "Historia"),
        Kahoot("¿Cuál es el segundo planeta más cercano al Sol?", mutableListOf("Venus", "Mercurio", "Marte", "Júpiter"), "Astronomía"),
        Kahoot("¿Quién fue el primer presidente de la República de China?", mutableListOf("Sun Yat-sen", "Chiang Kai-shek", "Mao Zedong", "Deng Xiaoping"), "Historia"),
        Kahoot("¿Cuál es el metal más denso?", mutableListOf("Osmio", "Platino", "Iridio", "Paladio"), "Química"),
        Kahoot("¿En qué año se llevó a cabo la Revolución Industrial en Inglaterra?", mutableListOf("1760", "1800", "1835", "1850"), "Historia"),
        Kahoot("¿Cuál es el animal más resistente del planeta?", mutableListOf("Tardígrado", "Cucaracha", "Elefante", "Tortuga"), "Biología"),
        Kahoot("¿Quién fue el fundador del Imperio Mongol?", mutableListOf("Genghis Khan", "Kublai Khan", "Ögedei Khan", "Jochi"), "Historia"),
        Kahoot("¿Cuál es el océano más grande del mundo?", mutableListOf("Océano Pacífico", "Océano Atlántico", "Océano Índico", "Océano Ártico"), "Geografía"),
        Kahoot("¿En qué año se inauguró el Canal de Panamá?", mutableListOf("1914", "1900", "1925", "1932"), "Historia"),
        Kahoot("¿Cuál es el gas más presente en la atmósfera de Marte?", mutableListOf("Dióxido de carbono", "Nitrógeno", "Oxígeno", "Metano"), "Astronomía"),
        Kahoot("¿Quién fue el autor de 'Crimen y castigo'?", mutableListOf("Fiodor Dostoievski", "León Tolstói", "Gabriel García Márquez", "Hermann Hesse"), "Literatura"),
        Kahoot("¿Cuál es el país más pequeño de América Latina por área?", mutableListOf("El Salvador", "Belice", "Costa Rica", "Panamá"), "Geografía"),
        Kahoot("¿En qué año se fundó la República Popular China?", mutableListOf("1949", "1911", "1927", "1955"), "Historia"),
        Kahoot("¿Quién fue el autor de 'La Odisea'?", mutableListOf("Homero", "Sófocles", "Eurípides", "Esquilo"), "Literatura")
    )


}