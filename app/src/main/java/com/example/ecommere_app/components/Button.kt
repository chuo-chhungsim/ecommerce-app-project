package com.example.ecommere_app.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommere_app.R


@Composable
fun PrimaryButton(
    backgroundColor: Int,
    text: String,
    onClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier,
    contentColor: Int,

    ) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clickable(enabled = onClick != null) { onClick?.invoke() }
            .clip(shape = RoundedCornerShape(10.dp))
            .background(color = colorResource(id = backgroundColor))
            .padding(vertical = 18.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = text,
            color = colorResource(id = contentColor),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp
        )
    }
}
@Composable
@Preview(showBackground = true)
fun PrimaryButtonButtonPreview() {
    PrimaryButton(
        backgroundColor = R.color.btn_green,
        text = "Start Game",
        onClick = {},
        contentColor = R.color.white,
    )
}
