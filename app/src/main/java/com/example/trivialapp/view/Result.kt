package com.example.trivialapp.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trivialapp.R
import com.example.trivialapp.navigation.Routes
import com.example.trivialapp.viewmodel.MyViewModel
import java.util.Random



@Composable
fun Result(navController: NavController, myViewModel: MyViewModel) {

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
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Your score: ${myViewModel.contadorAciertos} / ${myViewModel.selectedRounds}", fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold, fontSize = 24.sp, color = myViewModel.colorText,
            modifier = Modifier.padding(top = 15.dp)
        )

        Spacer(modifier = Modifier.padding(top = 80.dp))
        
        OutlinedButton(
            onClick = {  },
            modifier = Modifier.requiredWidth(220.dp),
            border = myViewModel.colorBorde
        ) {
            Text(text = "Share", fontSize = 20.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold, color = myViewModel.colorText)
        }

        Spacer(modifier = Modifier.padding(top = 25.dp))

        OutlinedButton(
            onClick = { navController.navigate(Routes.Menu.route) },
            modifier = Modifier.requiredWidth(220.dp),
            border = myViewModel.colorBorde
        ) {
            Text(text = "Return to menu", fontSize = 20.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold, color = myViewModel.colorText)
        }

    }
}
