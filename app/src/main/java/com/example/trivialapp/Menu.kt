package com.example.trivialapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import com.example.trivialapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Menu(navController: NavController) {
    val colorGrisOscuro = Color(.15f, .15f, .15f) // Gris oscuro
    val colorGrisClaro = Color(.85f, .85f, .85f) // Gris claro

    var expanded by remember { mutableStateOf(false) }
    val difficulty = listOf("FÁCIL", "NORMAL", "DIFÍCIL")
    var selectedDifficulty by remember { mutableStateOf(difficulty[1]) }

    var showDialog by remember { mutableStateOf(false) }

    Image(
        painter = painterResource(id = R.drawable.fondo),
        contentDescription = "fondo",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 50.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.trivial_logo),
                contentDescription = "logo",
                modifier = Modifier
                    .requiredSize(200.dp)
                    .clip(shape = RoundedCornerShape(35.dp))
            )
        }

        val buttonColor = ButtonDefaults.buttonColors(
            containerColor = Color(.15f, 0.15f, 0.15f).copy(alpha = 0.8f), // Gris oscuro
            //contentColor = MaterialTheme.colorScheme.surface
            contentColor = Color(.85f, 0.85f, 0.85f) // Gris claro
        )

    }
}
