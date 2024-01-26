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
import androidx.compose.runtime.LaunchedEffect
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
    var aciertos by remember { mutableIntStateOf(0) }

    var indiceRandom by remember { mutableIntStateOf(Random.nextInt(myViewModel.preguntas.size)) }
    var respuestasMezcladas by remember { mutableStateOf(myViewModel.preguntas[indiceRandom].respuestas) }
    var respuestaCorrecta by remember { mutableStateOf(myViewModel.preguntas[indiceRandom].respuestas[0]) }

    // Mezcla las respuestas
    LaunchedEffect(indiceRandom) {
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
                text = myViewModel.preguntas[indiceRandom].pregunta,
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
                            }

                            if (round == totalRounds) {
                                myViewModel.modifyAciertos(aciertos)
                                navController.navigate(Routes.Result.route)
                            } else {
                                myViewModel.preguntas.removeAt(indiceRandom)
                                round++
                                indiceRandom = Random.nextInt(myViewModel.preguntas.size)

                                respuestasMezcladas = myViewModel.preguntas[indiceRandom].respuestas.toMutableList()
                                respuestasMezcladas.shuffle()
                                respuestaCorrecta = myViewModel.preguntas[indiceRandom].respuestas[0]
                            }
                        },
                        modifier = Modifier
                            .requiredWidth(160.dp)
                            .then(Modifier.padding(10.dp)),
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

