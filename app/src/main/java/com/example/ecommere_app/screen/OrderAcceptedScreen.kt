package com.example.ecommere_app.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.ecommere_app.R
import com.example.ecommere_app.components.PrimaryButton
@Composable
fun OrderAcceptedScreen(
    onTrackOrder: () -> Unit,
    onBackToHome: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center), // true vertical + horizontal center
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp) // uniform spacing
        ) {
            Image(
                painter = painterResource(R.drawable.checkmarksucess),
                contentDescription = "Order Accepted",
                modifier = Modifier.size(240.dp) // slightly bigger icon
            )
            Text(
                "Your Order has been accepted",
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                "Your items have been placed and are on their way to being processed",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(32.dp))
            PrimaryButton(
                backgroundColor = R.color.btn_green,
                text = "Track Order",
                onClick = {},
                contentColor = R.color.white,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Text(
                "Back to home",
                color = Color(0xFF4CAF50),
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .clickable(onClick = onBackToHome)
                    .padding(top = 8.dp)
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun OrderAcceptedScreenPreview() {
    OrderAcceptedScreen(onTrackOrder = {}, onBackToHome = {})
}
