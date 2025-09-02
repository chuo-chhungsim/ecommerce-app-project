package com.example.ecommere_app.components.mainScreen

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.ecommere_app.R

@Composable
fun Banner(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.banner),
        contentDescription = null,
        modifier = modifier
    )
}