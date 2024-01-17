package com.example.trivialapp

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.vector.VectorProperty
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import java.util.Random



@Composable
fun Game(navController: NavController) {
    var round by remember { mutableIntStateOf(1) }
    var totalRounds by remember { mutableIntStateOf(10) }

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
                text = "Question here",
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp,
                modifier = Modifier.padding(top = 15.dp)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 80.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            OutlinedButton(
                onClick = { navController.navigate(Routes.Menu.route) },
                modifier = Modifier.requiredWidth(150.dp),
            ) {
                Text(text = "Answer 1", fontSize = 20.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.padding(10.dp))
            OutlinedButton(
                onClick = { navController.navigate(Routes.Menu.route) },
                modifier = Modifier.requiredWidth(150.dp),
            ) {
                Text(text = "Answer 2", fontSize = 20.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold)
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
                Text(text = "Answer 3", fontSize = 20.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold)
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

