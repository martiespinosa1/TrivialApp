package com.example.trivialapp.view

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trivialapp.R
import com.example.trivialapp.model.QuestionsAndAnswers
import com.example.trivialapp.navigation.Routes
import com.example.trivialapp.viewmodel.MyViewModel
import com.example.trivialapp.model.QuestionsAndAnswers.Kahoot
import kotlin.random.Random


@Composable
fun Game(navController: NavController, myViewModel: MyViewModel) {
    var round by remember { mutableIntStateOf(1) }
    var totalRounds by remember { mutableIntStateOf(myViewModel.selectedRounds) }
    var contadorAciertos by remember { mutableIntStateOf(0) }

    val kahootEasy : List<QuestionsAndAnswers.Kahoot> = mutableListOf(
        Kahoot("¿Cuál es la capital de Francia?", mutableListOf("París", "Madrid", "Berlín", "Londres")),
        Kahoot("¿Cuántos días tiene una semana?", mutableListOf("7", "5", "10", "12")),
        Kahoot("¿Quién escribió Romeo y Julieta?", mutableListOf("William Shakespeare", "Jane Austen", "Charles Dickens", "F. Scott Fitzgerald")),
        Kahoot("¿Cuál es el planeta más grande del sistema solar?", mutableListOf("Júpiter", "Marte", "Venus", "Saturno")),
        Kahoot("¿Cuál es el río más largo del mundo?", mutableListOf("Amazonas", "Nilo", "Misisipi", "Yangtsé")),
        Kahoot("¿En qué año comenzó la Segunda Guerra Mundial?", mutableListOf("1939", "1945", "1914", "1929")),
        Kahoot("¿Cuál es el animal terrestre más grande?", mutableListOf("Elefante africano", "Jirafa", "Hipopótamo", "Oso polar")),
        Kahoot("¿Quién pintó La Última Cena?", mutableListOf("Leonardo da Vinci", "Vincent van Gogh", "Pablo Picasso", "Claude Monet")),
        Kahoot("¿En qué año se fundó Google?", mutableListOf("1998", "2000", "1995", "2005")),
        Kahoot("¿Cuántos continentes hay en el mundo?", mutableListOf("7", "5", "6", "4")),
        Kahoot("¿Cuál es la montaña más alta del mundo?", mutableListOf("Monte Everest", "K2", "Monte McKinley", "Monte Kilimanjaro")),
        Kahoot("¿Qué metal es conocido como el oro rojo?", mutableListOf("Cobre", "Oro", "Plata", "Aluminio")),
        Kahoot("¿En qué país se encuentra la Gran Muralla China?", mutableListOf("China", "Japón", "Corea del Sur", "India")),
        Kahoot("¿Cuál es el instrumento musical más antiguo?", mutableListOf("Flauta", "Piano", "Violín", "Trompeta")),
        Kahoot("¿Cuántos colores tiene el arcoíris?", mutableListOf("7", "5", "6", "9"))
    )

    val kahootMedium = mutableListOf(
        Kahoot("¿Cuál es el metal más abundante en la corteza terrestre?", mutableListOf("Aluminio", "Hierro", "Cobre", "Oro")),
        Kahoot("¿En qué año se proclamó la Declaración de los Derechos Humanos?", mutableListOf("1948", "1955", "1939", "1962")),
        Kahoot("¿Cuál es la capital de Australia?", mutableListOf("Camberra", "Sídney", "Melbourne", "Brisbane")),
        Kahoot("¿Quién fue el primer presidente de Estados Unidos?", mutableListOf("George Washington", "Thomas Jefferson", "John Adams", "Abraham Lincoln")),
        Kahoot("¿Qué gas compone la mayor parte de la atmósfera terrestre?", mutableListOf("Nitrógeno", "Oxígeno", "Dióxido de carbono", "Argón")),
        Kahoot("¿En qué año se celebró la Revolución Rusa?", mutableListOf("1917", "1925", "1905", "1933")),
        Kahoot("¿Cuál es el río más largo de América del Norte?", mutableListOf("Mississippi", "Missouri", "Yukón", "Colorado")),
        Kahoot("¿Qué científico formuló la teoría de la relatividad?", mutableListOf("Albert Einstein", "Isaac Newton", "Galileo Galilei", "Stephen Hawking")),
        Kahoot("¿Cuándo ocurrió la caída del Muro de Berlín?", mutableListOf("1989", "1991", "1985", "1995")),
        Kahoot("¿Cuál es el océano más grande del mundo?", mutableListOf("Océano Pacífico", "Océano Atlántico", "Océano Índico", "Océano Antártico")),
        Kahoot("¿Quién escribió el libro 'Cien años de soledad'?", mutableListOf("Gabriel García Márquez", "Julio Cortázar", "Mario Vargas Llosa", "Isabel Allende")),
        Kahoot("¿Cuántos huesos tiene el cuerpo humano adulto?", mutableListOf("206", "195", "220", "180")),
        Kahoot("¿En qué continente se encuentra la Antártida?", mutableListOf("Antártida", "África", "América", "Asia")),
        Kahoot("¿Quién fue el primer ser humano en el espacio?", mutableListOf("Yuri Gagarin", "Neil Armstrong", "Buzz Aldrin", "Valentina Tereshkova")),
        Kahoot("¿Cuál es el segundo idioma más hablado del mundo?", mutableListOf("Español", "Inglés", "Mandarín", "Hindi"))
    )

    val kahootHard = listOf(
        Kahoot("¿Quién formuló la teoría de la relatividad general?", mutableListOf("Albert Einstein", "Stephen Hawking", "Niels Bohr", "Max Planck")),
        Kahoot("¿Cuál es el elemento químico con el número atómico 79?", mutableListOf("Oro", "Plata", "Cobre", "Hierro")),
        Kahoot("¿En qué año se fundó la Unión Europea?", mutableListOf("1957", "1945", "1965", "1980")),
        Kahoot("¿Cuál es la novela más larga jamás escrita?", mutableListOf("La Montaña Mágica", "En busca del tiempo perdido", "Ulises", "Los hermanos Karamázov")),
        Kahoot("¿Qué filósofo es conocido por su teoría del superhombre?", mutableListOf("Friedrich Nietzsche", "Immanuel Kant", "Jean-Jacques Rousseau", "John Locke")),
        Kahoot("¿Cuántos premios Nobel ganó Marie Curie?", mutableListOf("Dos", "Uno", "Cinco", "Ninguno")),
        Kahoot("¿Cuál es el fenómeno físico detrás de la aurora boreal?", mutableListOf("Interacción de partículas solares con la atmósfera", "Reflejo de la luz solar en la atmósfera", "Efecto Doppler de la luz", "Influencia de la luna en las mareas")),
        Kahoot("¿Cuál es la obra más famosa de Anton Chejov?", mutableListOf("La gaviota", "Tío Vania", "Tres hermanas", "El jardín de los cerezos")),
        Kahoot("¿En qué año se descubrió la estructura del ADN?", mutableListOf("1953", "1960", "1945", "1972")),
        Kahoot("¿Qué matemático propuso el teorema de incompletitud?", mutableListOf("Kurt Gödel", "Alan Turing", "David Hilbert", "Georg Cantor")),
        Kahoot("¿Quién desarrolló la teoría de los juegos?", mutableListOf("John von Neumann", "John Nash", "Leonhard Euler", "Blaise Pascal")),
        Kahoot("¿Cuántos satélites naturales tiene el planeta Marte?", mutableListOf("Dos", "Fobos y Deimos", "Cinco", "Ninguno")),
        Kahoot("¿Quién escribió 'Ensayo sobre la desigualdad de las razas humanas'?", mutableListOf("Arthur de Gobineau", "Charles Darwin", "Immanuel Kant", "Voltaire")),
        Kahoot("¿Cuál es la obra más conocida de Ludwig van Beethoven?", mutableListOf("Sinfonía n.º 9 en re menor, op. 125", "Sonata para piano n.º 14 en do sostenido menor 'Claro de luna'", "Concierto para piano n.º 5 en mi bemol mayor 'Emperador'", "Sinfonía n.º 5 en do menor, op. 67")),
        Kahoot("¿Quién desarrolló la teoría de la relatividad especial?", mutableListOf("Albert Einstein", "Niels Bohr", "Max Planck", "Werner Heisenberg"))
    )

    var listaPreguntas = when (myViewModel.selectedDifficulty) {
        "Easy" -> kahootEasy.toMutableList()
        "Medium" -> kahootMedium.toMutableList()
        "Hard" -> kahootHard.toMutableList()
        else -> { kahootMedium.toMutableList() }
    }

    var preguntas by remember { mutableStateOf(listaPreguntas) }
    var hasta4 by remember { mutableIntStateOf(4) }

    Image(
        painter = painterResource(id = R.drawable.fondo),
        contentDescription = "fondo",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Round $round/$totalRounds", fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier.padding(top = 15.dp)
        )

        var indiceRandom by remember { mutableIntStateOf(Random.nextInt(preguntas.size)) }
        var indiceRandomResuestaCorrecta by remember { mutableIntStateOf(Random.nextInt(4)) }
        var indiceRandomResuesta by remember { mutableIntStateOf(Random.nextInt(hasta4)) }



        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 100.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = preguntas[indiceRandom].pregunta,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
                modifier = Modifier.padding(top = 15.dp)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 200.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            OutlinedButton(
                onClick = {
                    if (round == totalRounds) navController.navigate(Routes.Result.route)
                    else {
                        preguntas.removeAt(indiceRandom)
                        round++
                        indiceRandom = Random.nextInt(preguntas.size)
                        indiceRandomResuestaCorrecta = Random.nextInt(4)
                    }
                },
                modifier = Modifier.requiredWidth(150.dp),
            ) {
                if (indiceRandomResuestaCorrecta == 0) {
                    Text(text = preguntas[indiceRandom].respuestas[0], fontSize = 20.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold, color = Color.Green)
                    //preguntas[indiceRandom].respuestas.removeAt(0)
                    //hasta4--
                }
                else {
                    Text(text = preguntas[indiceRandom].respuestas[indiceRandomResuesta], fontSize = 20.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold)
                //    preguntas[indiceRandom].respuestas.removeAt(indiceRandomResuesta)
                //    hasta4--
                }
            }
            Spacer(modifier = Modifier.padding(10.dp))
            OutlinedButton(
                onClick = {
                    if (round == totalRounds) navController.navigate(Routes.Result.route)
                    else {
                        preguntas.removeAt(indiceRandom)
                        round++
                        indiceRandom = Random.nextInt(preguntas.size)
                        indiceRandomResuestaCorrecta = Random.nextInt(4)
                    }
                },
                modifier = Modifier.requiredWidth(150.dp),
            ) {
                if (indiceRandomResuestaCorrecta == 1) {
                    Text(text = preguntas[indiceRandom].respuestas[0], fontSize = 20.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold, color = Color.Green)
                    //preguntas[indiceRandom].respuestas.removeAt(1)
                    //hasta4--
                }
                else {
                    Text(text = preguntas[indiceRandom].respuestas[indiceRandomResuesta], fontSize = 20.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold)
                //    preguntas[indiceRandom].respuestas.removeAt(indiceRandomResuesta)
                //    hasta4--
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            OutlinedButton(
                onClick = {
                    if (round == totalRounds) navController.navigate(Routes.Result.route)
                    else {
                        preguntas.removeAt(indiceRandom)
                        round++
                        indiceRandom = Random.nextInt(preguntas.size)
                        indiceRandomResuestaCorrecta = Random.nextInt(4)
                    }
                },
                modifier = Modifier.requiredWidth(150.dp),
            ) {
                if (indiceRandomResuestaCorrecta == 2) {
                    Text(text = preguntas[indiceRandom].respuestas[0], fontSize = 20.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold, color = Color.Green)
                    //preguntas[indiceRandom].respuestas.removeAt(2)
                    // hasta4--
                }
                else {
                    Text(text = preguntas[indiceRandom].respuestas[indiceRandomResuesta], fontSize = 20.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold)
                //  preguntas[indiceRandom].respuestas.removeAt(indiceRandomResuesta)
                //  hasta4--
                }
            }
            Spacer(modifier = Modifier.padding(10.dp))
            OutlinedButton(
                onClick = {
                    if (round == totalRounds) navController.navigate(Routes.Result.route)
                    else {
                        preguntas.removeAt(indiceRandom)
                        round++
                        indiceRandom = Random.nextInt(preguntas.size)
                        indiceRandomResuestaCorrecta = Random.nextInt(4)
                    }
                },
                modifier = Modifier.requiredWidth(150.dp),
            ) {
                if (indiceRandomResuestaCorrecta == 3) {
                    Text(text = preguntas[indiceRandom].respuestas[0], fontSize = 20.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold, color = Color.Green)
                    //preguntas[indiceRandom].respuestas.removeAt(3)
                    //hasta4--
                }
                else {
                    Text(text = preguntas[indiceRandom].respuestas[indiceRandomResuesta], fontSize = 20.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold)
                //preguntas[indiceRandom].respuestas.removeAt(indiceRandomResuesta)
                // hasta4--
                }
            }
        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 100.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            TimeBar(30, 15)
        }



    }
}


@Composable
fun TimeBar(totalDuration: Int, currentProgress: Int) {
    val reversedProgress = totalDuration - currentProgress // Invierte el progreso actual

    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
    ) {
        // Dibuja la barra de fondo
        drawLine(
            color = Color.LightGray,
            start = Offset(0f, size.height / 2),
            end = Offset(size.width, size.height / 2),
            strokeWidth = 30f
        )

        // Dibuja la barra de progreso invertida
        drawLine(
            color = Color.Blue,
            start = Offset(size.width * (reversedProgress.toFloat() / totalDuration), size.height / 2),
            end = Offset(size.width, size.height / 2),
            strokeWidth = 30f
        )
    }
}

