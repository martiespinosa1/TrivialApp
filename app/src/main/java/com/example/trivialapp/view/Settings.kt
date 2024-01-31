package com.example.trivialapp.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
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


@Composable
fun Settings(navController: NavController, myViewModel: MyViewModel) {
    var expanded by remember { mutableStateOf(false) }
    val difficulty = listOf("Easy", "Medium", "Hard")

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

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Difficulty: ", fontSize = 14.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold, color = myViewModel.colorText)

            Box(modifier = Modifier.clickable { expanded = true }) {
                Text(text = myViewModel.selectedDifficulty, fontSize = 16.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold, color = myViewModel.colorText)


                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier
                        .padding(8.dp)
                ) {
                    difficulty.forEach {
                        DropdownMenuItem(text = { Text(text = it, fontSize = 16.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold) },
                            onClick = {
                                expanded = false
                                myViewModel.modifyDifficulty(it)
                            })
                    }
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Rounds: ", fontSize = 16.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold, color = myViewModel.colorText)

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    RadioButton(
                        selected = myViewModel.selectedRounds == 5,
                        onClick = { myViewModel.modifyRounds(5) }
                    )
                    Text(
                        text = "5 ",
                        fontSize = 16.sp,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold,
                        color = myViewModel.colorText
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    RadioButton(
                        selected = myViewModel.selectedRounds == 10,
                        onClick = { myViewModel.modifyRounds(10) }
                    )
                    Text(
                        text = "10",
                        fontSize = 16.sp,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold,
                        color = myViewModel.colorText
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    RadioButton(
                        selected = myViewModel.selectedRounds == 15,
                        onClick = { myViewModel.modifyRounds(15) }
                    )
                    Text(
                        text = "15",
                        fontSize = 16.sp,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold,
                        color = myViewModel.colorText
                    )
                }
            }
        }


        Row(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(top = 30.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Time per round: ", fontSize = 16.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold, color = myViewModel.colorText)

            Slider(
                value = myViewModel.selectedTime.toFloat(),
                onValueChange = { myViewModel.modifyTime(it.toInt()) },
                valueRange = 5f..30f,
                steps = 4,
                modifier = Modifier.fillMaxWidth()
            )
        }
        Text(text = "                ${myViewModel.selectedTime} seconds", fontSize = 16.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold, color = myViewModel.colorText)


        Row(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(top = 30.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Dark mode ", fontSize = 16.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold, color = myViewModel.colorText)

            Switch(
                checked = myViewModel.darkMode,
                onCheckedChange = { myViewModel.modifyDarkMode(it) },
                colors = SwitchDefaults.colors(
                    uncheckedThumbColor = Color.DarkGray,
                    checkedThumbColor = Color.DarkGray
                )
            )

        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 60.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            OutlinedButton(
                onClick = { navController.navigate(Routes.Menu.route) },
                modifier = Modifier.requiredWidth(220.dp),
                border = myViewModel.colorBorde
            ) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                Text(text = "Return to menu", fontSize = 20.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold, color = myViewModel.colorText)
            }
        }

    }
}
