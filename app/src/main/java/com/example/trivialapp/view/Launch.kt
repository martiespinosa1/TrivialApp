package com.example.trivialapp.view

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trivialapp.R
import kotlinx.coroutines.delay
import com.example.trivialapp.navigation.Routes
import com.example.trivialapp.viewmodel.MyViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Launch(alphaAnim: Float) {
    Image(
        painter = painterResource(id = R.drawable.light),
        contentDescription = "fondo",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )

    Column(modifier = Modifier.requiredSize(150.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.trivial_logo),
            contentDescription = "logo",
            alpha = alphaAnim,
            modifier = Modifier
                .clip(shape = RoundedCornerShape(25.dp))
        )
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 100.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        val colorGrisClaro = Color(.75f, 0.75f, 0.75f) // Gris claro
        Text(
            text = "Trivial App",
            fontSize = 33.sp,
            fontFamily = FontFamily.Monospace,
            color = Color.DarkGray,
            modifier = Modifier.padding(top = 150.dp).alpha(alphaAnim)
        )
    }
}

@Composable
fun LaunchAnimation(navController: NavController) {
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 3000), label = ""
    )
    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(2000)
        navController.popBackStack()
        navController.navigate(Routes.Menu.route)
    }
    Launch(alphaAnim.value)
}