package com.example.ecommere_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ecommere_app.components.onBoarding.LoginScreen
import com.example.ecommere_app.components.onBoarding.SignUpScreen
import com.example.ecommere_app.components.onBoarding.StartScreen
import com.example.ecommere_app.navigation.MainScreen
import com.example.ecommere_app.ui.theme.EcommereappTheme
import com.example.ecommere_app.screen.TextSplash
import com.example.ecommere_app.utility.Screen
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EcommereappTheme {
                var showSplash by remember { mutableStateOf(true) }
                LaunchedEffect(Unit) { delay(1000); showSplash = false }
                if (showSplash) {
                    TextSplash()
                } else {
                    AppNavHost()
                }
            }
        }
    }
}
@Composable
fun AppNavHost() {
    val appNav = rememberNavController()
    NavHost(
        navController = appNav,
        startDestination = Screen.OnBoard.route
    ) {
        composable(Screen.OnBoard.route) { StartScreen(appNav) }
        composable(Screen.Login.route)   { LoginScreen(appNav) }
        composable(Screen.SignUp.route)  { SignUpScreen(appNav) }
        composable(Screen.Home.route)    { MainScreen(navController = appNav) } // ✅ only outer nav passed
    }
}

