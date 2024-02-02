package com.example.trivialapp.view

import android.content.Intent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
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
        
        Share(text = "He conseguido una puntuacion de ${myViewModel.contadorAciertos} / ${myViewModel.selectedRounds} en el trivial!", myViewModel = myViewModel)

        Spacer(modifier = Modifier.padding(top = 25.dp))

        OutlinedButton(
            onClick = { navController.navigate(Routes.Menu.route) },
            modifier = Modifier.requiredWidth(250.dp),
            border = myViewModel.colorBorde
        ) {
            Icon(imageVector = Icons.Default.Menu, tint = myViewModel.colorText, contentDescription = "Menu")
            Text(text = " Return to menu", fontSize = 18.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold, color = myViewModel.colorText)
        }

    }
}


@Composable
fun Share(text: String, myViewModel: MyViewModel) {
    val context = LocalContext.current
    val sendIntent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, text)
    }
    val shareIntent = Intent.createChooser(sendIntent, "Share with...")
    OutlinedButton(
        onClick = { startActivity(context, shareIntent, null) },
        modifier = Modifier.requiredWidth(250.dp),
        border = myViewModel.colorBorde
    ) {
        Icon(imageVector = Icons.Default.Share, tint = myViewModel.colorText, contentDescription = "Share")
        Text(" Share", fontSize = 20.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold, color = myViewModel.colorText, modifier = Modifier.padding(start = 8.dp))
    }
}