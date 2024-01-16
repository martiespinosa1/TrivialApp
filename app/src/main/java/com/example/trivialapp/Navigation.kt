package com.example.trivialapp

sealed class Routes(val route: String) {
    object Launch:Routes("Launch")
    object Menu:Routes("Menu")
    object Game:Routes("Game")
    object Settings:Routes("Settings")
    object Result:Routes("Result")

}
