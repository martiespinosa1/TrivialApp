package com.example.trivialapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.trivialapp.ui.theme.TrivialAppTheme
import com.example.trivialapp.navigation.Routes
import com.example.trivialapp.view.Game
import com.example.trivialapp.view.LaunchAnimation
import com.example.trivialapp.view.Menu
import com.example.trivialapp.view.Result
import com.example.trivialapp.view.Settings
import com.example.trivialapp.viewmodel.MyViewModel

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        val myViewModel by viewModels<MyViewModel>()
        super.onCreate(savedInstanceState)
        setContent {
            var windowSize = calculateWindowSizeClass(this)

            TrivialAppTheme(myViewModel) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navigationController = rememberNavController()
                    NavHost(
                        navController = navigationController,
                        startDestination = Routes.Launch.route
                    ) {
                        composable(Routes.Launch.route) { LaunchAnimation(navigationController) }
                        composable(Routes.Menu.route) { Menu(navigationController, myViewModel) }
                        composable(Routes.Game.route) { Game(navigationController, myViewModel) }
                        composable(Routes.Settings.route) { Settings(navigationController, myViewModel) }
                        composable(Routes.Result.route) { Result(navigationController, myViewModel) }
                    }
                }
            }
        }
    }
}
