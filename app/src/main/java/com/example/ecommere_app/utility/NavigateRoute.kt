package com.example.ecommere_app.utility

sealed class Screen(val route: String) {
    data object OnBoard : Screen("onboard")
    data object Login   : Screen("login")
    data object SignUp  : Screen("signup")
}