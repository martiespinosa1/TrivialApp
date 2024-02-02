package com.example.trivialapp.view

import android.content.res.Configuration
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
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


@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
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
    var buttonsEnabled by remember { mutableStateOf(true) }
    var timeLeft by rememberSaveable { mutableDoubleStateOf(myViewModel.selectedTime.toDouble()) }
    var isTimeRunning by remember { mutableStateOf(true) }
    var landscapeMode by remember { mutableStateOf(false) }

    val coroutineScope = rememberCoroutineScope()

    // Mezcla las respuestas
    LaunchedEffect(indiceRandom) {
        buttonsEnabled = true
        pintarBotonCorrecto = false
        respuestasMezcladas = preguntas[indiceRandom].respuestas.toMutableList()
        respuestaCorrecta = respuestasMezcladas[0]
        respuestasMezcladas.shuffle()
    }







    val configuration = LocalConfiguration.current
    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            landscapeMode = false
        }
        else -> {
            landscapeMode = false
        }
    }



    if (landscapeMode) { // MODO LANDSCAPE
        if (myViewModel.darkMode) {
            Image(
                painter = painterResource(id = R.drawable.krad),
                contentDescription = "fondo oscuro",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        } else {
            Image(
                painter = painterResource(id = R.drawable.thgil),
                contentDescription = "fondo claro",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

    } else { // MODO PORTRAIT

        if (myViewModel.darkMode) {
            Image(
                painter = painterResource(id = R.drawable.dark),
                contentDescription = "fondo oscuro",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        } else {
            Image(
                painter = painterResource(id = R.drawable.light),
                contentDescription = "fondo claro",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(25.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "round $round/$totalRounds",
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier.padding(top = 15.dp),
                color = myViewModel.colorText
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
                    color = myViewModel.colorText,
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

                        var pintarBotonIncorrecto by remember { mutableStateOf(false) }

                        OutlinedButton(
                            onClick = {
                                isTimeRunning = false
                                buttonsEnabled = false

                                if (buttonText == respuestaCorrecta) {
                                    aciertos++
                                    pintarBotonCorrecto = true
                                } else {
                                    pintarBotonIncorrecto = true
                                    pintarBotonCorrecto = true
                                }

                                coroutineScope.launch {
                                    delay(1000)
                                    pintarBotonIncorrecto = false
                                    timeLeft = myViewModel.selectedTime.toDouble()
                                    isTimeRunning = true

                                    if (round == totalRounds) {
                                        myViewModel.modifyAciertos(aciertos)
                                        navController.navigate(Routes.Result.route)
                                    } else {
                                        round++
                                        // Remover el índice usado de la lista barajada
                                        indicesBarajados = indicesBarajados.toMutableList()
                                            .apply { remove(indiceRandom) }
                                        // Obtener el siguiente índice barajado
                                        indiceRandom = indicesBarajados[0]

                                        // Mezclar las respuestas después de incrementar la ronda
                                        respuestasMezcladas =
                                            preguntas[indiceRandom].respuestas.shuffled()
                                                .toMutableList()
                                        respuestaCorrecta = respuestasMezcladas[0]

                                        pintarBotonCorrecto = false
                                    }
                                }
                            },
                            modifier = Modifier
                                .requiredWidth(160.dp)
                                .then(Modifier.padding(10.dp)),
                            border = when {
                                buttonText == respuestaCorrecta && pintarBotonCorrecto -> BorderStroke(
                                    2.dp,
                                    Color(0xFF55FF55)
                                )

                                buttonText != respuestaCorrecta && pintarBotonIncorrecto -> BorderStroke(
                                    2.dp,
                                    Color(0xFFFF5555)
                                )

                                else -> myViewModel.colorBorde
                            },
                            enabled = buttonsEnabled
                        ) {
                            Text(
                                text = respuestasMezcladas[indiceRespuestas],
                                fontSize = calculateFontSize(respuestasMezcladas[indiceRespuestas]),
                                fontFamily = FontFamily.Monospace,
                                fontWeight = FontWeight.Bold,
                                color = myViewModel.colorText
                            )
                        }

                        indiceRespuestas++
                    }
                }
            }


            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                LaunchedEffect(timeLeft) {
                    while (timeLeft > 0 && isTimeRunning) {
                        delay(10L)
                        timeLeft -= 0.01
                    }
                }

                if (timeLeft <= 0.0) {
                    round++

                    // Remover el índice usado de la lista barajada
                    indicesBarajados =
                        indicesBarajados.toMutableList().apply { remove(indiceRandom) }
                    // Obtener el siguiente índice barajado
                    indiceRandom = indicesBarajados[0]

                    // Mezclar las respuestas después de incrementar la ronda
                    respuestasMezcladas =
                        preguntas[indiceRandom].respuestas.shuffled().toMutableList()
                    respuestaCorrecta = respuestasMezcladas[0]

                    pintarBotonCorrecto = false

                    timeLeft = myViewModel.selectedTime.toDouble()
                }

                Column(
                    Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = if (timeLeft < 1.0) {
                            String.format("Time left: %.1f", timeLeft)
                        } else {
                            "Time left: ${timeLeft.toInt()}"
                        }, fontFamily = FontFamily.Monospace, color = myViewModel.colorText
                    )
                    LinearProgressIndicator(
                        progress = timeLeft.toFloat() / myViewModel.selectedTime.toFloat(),
                        color = Color(0xFF55FF55),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(8.dp)
                            .clip(RoundedCornerShape(4.dp))
                    )
                }
            }

        }



    }
}





private fun calculateFontSize(text: String): TextUnit {
    val maxLength = 10 // Define the maximum length for which the default font size will be used
    val defaultFontSize = 18.sp // Define the default font size

    return if (text.length > maxLength) {
        val scaleFactor = maxLength.toFloat() / text.length.toFloat()
        (defaultFontSize * scaleFactor)
    } else {
        defaultFontSize
    }
}

