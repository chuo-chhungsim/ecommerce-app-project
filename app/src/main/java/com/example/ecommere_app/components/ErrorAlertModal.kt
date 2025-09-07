package com.example.ecommere_app.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.example.ecommere_app.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ErrorModal(
    onDismiss: () -> Unit,
    onTryAgain: () -> Unit,
    onBackToHome: () -> Unit
) {
    BasicAlertDialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(), content = {
            Column(
                modifier = Modifier
                    .background(Color.White, shape = RoundedCornerShape(16.dp)) // white card bg
                    .padding(24.dp) // padding inside dialog
                    .widthIn(min = 280.dp, max = 340.dp), // dialog size
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    IconButton(onClick = onDismiss) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
                    }
                }
                Image(
                    painter = painterResource(id = R.drawable.errror_img),
                    contentDescription = "Error Illustration",
                    modifier = Modifier.size(150.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    "Something went terribly wrong.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(32.dp))
                PrimaryButton(
                    backgroundColor = R.color.btn_green,
                    text = "Try again",
                    onClick = onTryAgain,
                    contentColor = R.color.white
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    "Back to home",
                    color = Color(0xFF4CAF50),
                    modifier = Modifier.clickable(onClick = onBackToHome)
                )
            }
        })
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview()
@Composable
fun ErrorModalPreview() {
    ErrorModal(
        onDismiss = {},
        onTryAgain = {},
        onBackToHome = {}
    )
}