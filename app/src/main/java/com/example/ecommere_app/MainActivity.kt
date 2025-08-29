package com.example.ecommere_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.ecommere_app.ui.theme.EcommereappTheme
import com.example.ecommere_app.ui.theme.Outfit
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApp()
        }
    }
}
@Composable
fun MyApp(){
    EcommereappTheme {
        var showSplash by remember { mutableStateOf(true) }
        LaunchedEffect(Unit) { delay(1000); showSplash = false }
        if (showSplash) {
            TextSplash()
        } else {
            MainScreen()
        }
    }
}

@Composable
fun TextSplash() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF25824B)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            buildAnnotatedString {
                withStyle(SpanStyle(color = Color.White)) {
                    append("GO")
                }
                withStyle(SpanStyle(color = Color.Green)) {
                    append("GREEN")
                }
            },
            fontSize = 55.sp,
            fontWeight = FontWeight.Medium,
            letterSpacing = 1.sp,
            fontFamily = Outfit
        )
    }
}

@Composable
fun MainScreen() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Hello my love", fontSize = 30.sp, style = MaterialTheme.typography.bodyLarge)
    }
}