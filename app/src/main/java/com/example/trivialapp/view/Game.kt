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


@Composable
fun Game(navController: NavController, myViewModel: MyViewModel) {
    var round by remember { mutableIntStateOf(1) }
    var totalRounds by remember { mutableIntStateOf(myViewModel.selectedRounds) }

    val preguntasEasy = arrayOf(
        QuestionsAndAnswers.Kahoot(
            pregunta = "¿Cuál es el color primario?",
            respuesta1 = "Rojo",
            respuesta2 = "Verde",
            respuesta3 = "Azul"
        ),
        QuestionsAndAnswers.Kahoot(
            pregunta = "¿Cuál es el animal más grande del mundo?",
            respuesta1 = "Elefante",
            respuesta2 = "Ballena Azul",
            respuesta3 = "Jirafa"
        ),
        QuestionsAndAnswers.Kahoot(
            pregunta = "¿Cuál es el continente más poblado?",
            respuesta1 = "Asia",
            respuesta2 = "África",
            respuesta3 = "Europa"
        ),
        QuestionsAndAnswers.Kahoot(
            pregunta = "¿Cuál es el planeta más cercano al Sol?",
            respuesta1 = "Venus",
            respuesta2 = "Mercurio",
            respuesta3 = "Marte"
        ),
        QuestionsAndAnswers.Kahoot(
            pregunta = "¿Cuál es el océano más grande?",
            respuesta1 = "Atlántico",
            respuesta2 = "Pacífico",
            respuesta3 = "Índico"
        ),
        QuestionsAndAnswers.Kahoot(
            pregunta = "¿Cuál es el país más grande del mundo?",
            respuesta1 = "Rusia",
            respuesta2 = "China",
            respuesta3 = "Estados Unidos"
        ),
        QuestionsAndAnswers.Kahoot(
            pregunta = "¿Cuál es el instrumento musical más antiguo?",
            respuesta1 = "Flauta",
            respuesta2 = "Piano",
            respuesta3 = "Violín"
        ),
        QuestionsAndAnswers.Kahoot(
            pregunta = "¿Cuál es el idioma más hablado del mundo?",
            respuesta1 = "Inglés",
            respuesta2 = "Español",
            respuesta3 = "Mandarín"
        ),
        QuestionsAndAnswers.Kahoot(
            pregunta = "¿Cuál es el deporte más popular del mundo?",
            respuesta1 = "Fútbol",
            respuesta2 = "Baloncesto",
            respuesta3 = "Tenis"
        ),
        QuestionsAndAnswers.Kahoot(
            pregunta = "¿Cuál es el país con forma de bota?",
            respuesta1 = "Italia",
            respuesta2 = "España",
            respuesta3 = "México"
        ),
        QuestionsAndAnswers.Kahoot(
            pregunta = "¿Cuál es el río más largo del mundo?",
            respuesta1 = "Nilo",
            respuesta2 = "Amazonas",
            respuesta3 = "Mississippi"
        ),
        QuestionsAndAnswers.Kahoot(
            pregunta = "¿Cuál es el animal nacional de Australia?",
            respuesta1 = "Canguro",
            respuesta2 = "Koala",
            respuesta3 = "Emú"
        ),
        QuestionsAndAnswers.Kahoot(
            pregunta = "¿Cuál es el símbolo químico del oro?",
            respuesta1 = "Ag",
            respuesta2 = "Au",
            respuesta3 = "Fe"
        ),
        QuestionsAndAnswers.Kahoot(
            pregunta = "¿Cuál es el país conocido como la cuna de la civilización?",
            respuesta1 = "Egipto",
            respuesta2 = "Grecia",
            respuesta3 = "Irak"
        ),
        QuestionsAndAnswers.Kahoot(
            pregunta = "¿Cuál es el número de lados de un triángulo?",
            respuesta1 = "3",
            respuesta2 = "4",
            respuesta3 = "5"
        )
    )



    val preguntasMedium = arrayOf(
        QuestionsAndAnswers.Kahoot(
            pregunta = "¿Cuál es la capital de Australia?",
            respuesta1 = "Sídney",
            respuesta2 = "Melbourne",
            respuesta3 = "Canberra"
        ),
        QuestionsAndAnswers.Kahoot(
            pregunta = "¿Quién escribió la novela 'Cien años de soledad'?",
            respuesta1 = "Gabriel García Márquez",
            respuesta2 = "Mario Vargas Llosa",
            respuesta3 = "Jorge Luis Borges"
        ),
        QuestionsAndAnswers.Kahoot(
            pregunta = "¿Cuál es el río más largo de África?",
            respuesta1 = "Nilo",
            respuesta2 = "Congo",
            respuesta3 = "Zambeze"
        ),
        QuestionsAndAnswers.Kahoot(
            pregunta = "¿Cuál es el elemento químico más abundante en la Tierra?",
            respuesta1 = "Oxígeno",
            respuesta2 = "Carbono",
            respuesta3 = "Hierro"
        ),
        QuestionsAndAnswers.Kahoot(
            pregunta = "¿Cuál es el país más poblado del mundo?",
            respuesta1 = "China",
            respuesta2 = "India",
            respuesta3 = "Estados Unidos"
        ),
        QuestionsAndAnswers.Kahoot(
            pregunta = "¿Cuál es el autor de la obra 'Don Quijote de la Mancha'?",
            respuesta1 = "Miguel de Cervantes",
            respuesta2 = "Federico García Lorca",
            respuesta3 = "Pablo Neruda"
        ),
        QuestionsAndAnswers.Kahoot(
            pregunta = "¿Cuál es el océano más grande del mundo?",
            respuesta1 = "Pacífico",
            respuesta2 = "Atlántico",
            respuesta3 = "Índico"
        ),
        QuestionsAndAnswers.Kahoot(
            pregunta = "¿Cuál es el monte más alto del mundo?",
            respuesta1 = "Monte Everest",
            respuesta2 = "Monte Kilimanjaro",
            respuesta3 = "Monte Aconcagua"
        ),
        QuestionsAndAnswers.Kahoot(
            pregunta = "¿Cuál es el símbolo químico del oro?",
            respuesta1 = "Au",
            respuesta2 = "Ag",
            respuesta3 = "Fe"
        ),
        QuestionsAndAnswers.Kahoot(
            pregunta = "¿Cuál es el país conocido como 'la tierra del sol naciente'?",
            respuesta1 = "Japón",
            respuesta2 = "China",
            respuesta3 = "Corea del Sur"
        ),
        QuestionsAndAnswers.Kahoot(
            pregunta = "¿Cuál es el autor de la obra 'Romeo y Julieta'?",
            respuesta1 = "William Shakespeare",
            respuesta2 = "Friedrich Nietzsche",
            respuesta3 = "Charles Dickens"
        ),
        QuestionsAndAnswers.Kahoot(
            pregunta = "¿Cuál es el río más largo de Europa?",
            respuesta1 = "Volga",
            respuesta2 = "Danubio",
            respuesta3 = "Rin"
        ),
        QuestionsAndAnswers.Kahoot(
            pregunta = "¿Cuál es el país conocido como 'la tierra de los faraones'?",
            respuesta1 = "Egipto",
            respuesta2 = "Grecia",
            respuesta3 = "Italia"
        ),
        QuestionsAndAnswers.Kahoot(
            pregunta = "¿Cuál es el autor de la obra '1984'?",
            respuesta1 = "George Orwell",
            respuesta2 = "Aldous Huxley",
            respuesta3 = "Ray Bradbury"
        ),
        QuestionsAndAnswers.Kahoot(
            pregunta = "¿Cuál es el continente más grande del mundo?",
            respuesta1 = "Asia",
            respuesta2 = "África",
            respuesta3 = "América"
        )
    )



    val preguntasHard = arrayOf(
        QuestionsAndAnswers.Kahoot(
            pregunta = "¿Cuál es el país más extenso del mundo?",
            respuesta1 = "Rusia",
            respuesta2 = "Canadá",
            respuesta3 = "China"
        ),
        QuestionsAndAnswers.Kahoot(
            pregunta = "¿Quién pintó el cuadro 'La noche estrellada'?",
            respuesta1 = "Vincent van Gogh",
            respuesta2 = "Pablo Picasso",
            respuesta3 = "Leonardo da Vinci"
        ),
        QuestionsAndAnswers.Kahoot(
            pregunta = "¿Cuál es el libro más vendido de la historia?",
            respuesta1 = "La Biblia",
            respuesta2 = "Don Quijote de la Mancha",
            respuesta3 = "El Principito"
        ),
        QuestionsAndAnswers.Kahoot(
            pregunta = "¿Cuál es el país con más premios Nobel?",
            respuesta1 = "Estados Unidos",
            respuesta2 = "Reino Unido",
            respuesta3 = "Alemania"
        ),
        QuestionsAndAnswers.Kahoot(
            pregunta = "¿Cuál es el monumento más visitado del mundo?",
            respuesta1 = "La Gran Muralla China",
            respuesta2 = "La Torre Eiffel",
            respuesta3 = "El Coliseo Romano"
        ),
        QuestionsAndAnswers.Kahoot(
            pregunta = "¿Cuál es el compositor de la Sinfonía No. 9 'Coral'?",
            respuesta1 = "Ludwig van Beethoven",
            respuesta2 = "Wolfgang Amadeus Mozart",
            respuesta3 = "Johann Sebastian Bach"
        ),
        QuestionsAndAnswers.Kahoot(
            pregunta = "¿Cuál es el país con más islas en el mundo?",
            respuesta1 = "Suecia",
            respuesta2 = "Filipinas",
            respuesta3 = "Indonesia"
        ),
        QuestionsAndAnswers.Kahoot(
            pregunta = "¿Cuál es el autor de la obra 'Guerra y Paz'?",
            respuesta1 = "León Tolstói",
            respuesta2 = "Fyodor Dostoyevsky",
            respuesta3 = "Anton Chekhov"
        ),
        QuestionsAndAnswers.Kahoot(
            pregunta = "¿Cuál es el animal más rápido del mundo?",
            respuesta1 = "Guepardo",
            respuesta2 = "Leopardo",
            respuesta3 = "León"
        ),
        QuestionsAndAnswers.Kahoot(
            pregunta = "¿Cuál es el pintor del cuadro 'La última cena'?",
            respuesta1 = "Leonardo da Vinci",
            respuesta2 = "Pablo Picasso",
            respuesta3 = "Vincent van Gogh"
        )
    )

    val preguntas = when (myViewModel.selectedDifficulty) {
        "Easy" -> preguntasEasy
        "Medium" -> preguntasMedium
        "Hard" -> preguntasHard
        else -> { preguntasMedium }
    }

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

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 100.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = preguntas[round - 1].pregunta,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp,
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
                onClick = { navController.navigate(Routes.Menu.route) },
                modifier = Modifier.requiredWidth(150.dp),
            ) {
                Text(text = preguntas[round - 1].respuesta1, fontSize = 20.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.padding(10.dp))
            OutlinedButton(
                onClick = { navController.navigate(Routes.Menu.route) },
                modifier = Modifier.requiredWidth(150.dp),
            ) {
                Text(text = preguntas[round - 1].respuesta2, fontSize = 20.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold)
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
                onClick = { navController.navigate(Routes.Menu.route) },
                modifier = Modifier.requiredWidth(150.dp),
            ) {
                Text(text = preguntas[round - 1].respuesta3, fontSize = 20.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.padding(10.dp))
            OutlinedButton(
                onClick = { navController.navigate(Routes.Menu.route) },
                modifier = Modifier.requiredWidth(150.dp),
            ) {
                Text(text = "Answer 4", fontSize = 20.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold)
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

