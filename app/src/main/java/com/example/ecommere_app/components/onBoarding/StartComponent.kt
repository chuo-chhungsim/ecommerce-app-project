package com.example.ecommere_app.components.onBoarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ecommere_app.R
import com.example.ecommere_app.components.PrimaryButton
import com.example.ecommere_app.utility.Screen


@Composable
fun StartScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center

    ) {
        Image(
            painter = painterResource(R.drawable.start_screen),
            contentDescription = "start screen",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .offset(y = (200).dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = "logo",
                modifier = Modifier.size(80.dp)
            )
            Spacer(Modifier.height(10.dp))
            Text(
                text = "Welcome",
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 2.sp,
                fontSize = 48.sp
            )
            Text(
                text = "to our store",
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 2.sp,
                fontSize = 48.sp
            )
            Spacer(Modifier.height(20.dp))
            Text(
                text = "Get your groceries in as fast as one hour",
                color = Color.White,
                fontWeight = FontWeight.Light,
                fontSize = 18.sp
            )
            Spacer(Modifier.height(30.dp))
            PrimaryButton(
                text = "Get Started",
                backgroundColor = R.color.btn_green,
                onClick = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.OnBoard.route) { inclusive = true }
                        launchSingleTop = true
                    }
                },
                modifier = Modifier.padding(horizontal = 24.dp)
            )
        }
    }
}