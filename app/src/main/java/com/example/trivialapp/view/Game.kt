package com.example.trivialapp.view

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random


@Composable
fun Game(navController: NavController, myViewModel: MyViewModel) {
    var round by remember { mutableIntStateOf(1) }
    val totalRounds by remember { mutableIntStateOf(myViewModel.selectedRounds) }
    var aciertos by remember { mutableIntStateOf(0) }

    val preguntas: MutableList<Kahoot> = when (myViewModel.selectedDifficulty) {
        "Easy" -> myViewModel.kahootEasy.toMutableList()
        "Medium" -> myViewModel.kahootMedium.toMutableList()
        "Hard" -> myViewModel.kahootHard.toMutableList()
        else -> { myViewModel.kahootMedium.toMutableList() }
    }

    var indicesBarajados by remember { mutableStateOf(preguntas.indices.shuffled()) }
    var indiceRandom by remember { mutableIntStateOf(indicesBarajados[0]) }
    var respuestasMezcladas by remember { mutableStateOf(preguntas[indiceRandom].respuestas) }
    var respuestaCorrecta by remember { mutableStateOf(preguntas[indiceRandom].respuestas[0]) }
    var pintarBotonCorrecto by remember { mutableStateOf(false) }
    var pintarBotonIncorrecto by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    // Mezcla las respuestas
    LaunchedEffect(indiceRandom) {
        pintarBotonCorrecto = false
        pintarBotonIncorrecto = false
        respuestasMezcladas = preguntas[indiceRandom].respuestas.toMutableList()
        respuestaCorrecta = respuestasMezcladas[0]
        respuestasMezcladas.shuffle()
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
                text = preguntas[indiceRandom].pregunta,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
                modifier = Modifier.padding(top = 15.dp)
            )
        }

        var indiceRespuestas = 0

        var pad = 150
        for (i in 0 until 2) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = pad.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                pad = 25
                for (j in 0 until 2) {
                    val buttonText = respuestasMezcladas[indiceRespuestas]

                    OutlinedButton(
                        onClick = {
                            if (buttonText == respuestaCorrecta) {
                                aciertos++
                                pintarBotonCorrecto = true
                            } else {
                                pintarBotonIncorrecto = true
                                pintarBotonCorrecto = true
                            }

                            coroutineScope.launch {
                                delay(1000)

                                if (round == totalRounds) {
                                    myViewModel.modifyAciertos(aciertos)
                                    navController.navigate(Routes.Result.route)
                                } else {
                                    round++
                                    // Remover el índice usado de la lista barajada
                                    indicesBarajados = indicesBarajados.toMutableList().apply { remove(indiceRandom) }
                                    // Obtener el siguiente índice barajado
                                    indiceRandom = indicesBarajados[0]

                                    // Mezclar las respuestas después de incrementar la ronda
                                    respuestasMezcladas = preguntas[indiceRandom].respuestas.shuffled().toMutableList()
                                    respuestaCorrecta = respuestasMezcladas[0]

                                    pintarBotonCorrecto = false
                                }
                            }
                        },
                        modifier = Modifier
                            .requiredWidth(160.dp)
                            .then(Modifier.padding(10.dp)),
                        border = when {
                            buttonText == respuestaCorrecta && pintarBotonCorrecto -> BorderStroke(2.dp, Color.Green)
                            buttonText != respuestaCorrecta && pintarBotonIncorrecto -> BorderStroke(2.dp, Color.Red)
                            else -> BorderStroke(2.dp, Color.DarkGray)
                        }
                    ) {
                        Text(
                            text = respuestasMezcladas[indiceRespuestas],
                            fontSize = 20.sp,
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    indiceRespuestas++

                    Spacer(modifier = Modifier.padding(10.dp))
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

