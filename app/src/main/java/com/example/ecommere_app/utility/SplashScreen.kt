package com.example.ecommere_app.utility

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommere_app.R


@Composable
@Preview(showBackground = true)
fun TextSplash() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF25824B)),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = "App logo",
                modifier = Modifier.size(50.dp)
            )
            Text(
                text = "nectar",
                fontWeight = FontWeight.SemiBold,
                fontSize = 42.sp,
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
