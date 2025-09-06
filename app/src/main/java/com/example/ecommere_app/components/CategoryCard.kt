package com.example.ecommere_app.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ecommere_app.R
import com.example.ecommere_app.model.CategoryUI

@Composable
fun CategoryCard(category: CategoryUI, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(containerColor = category.backgroundColor)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize().padding(12.dp)
        ) {
            Image(
                painter = painterResource(category.imageRes),
                contentDescription = category.name,
                modifier = Modifier.size(64.dp)
            )
            Spacer(Modifier.height(8.dp))
            Text(category.name, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
        }
    }
}

@Preview
@Composable
fun CategoryCardPreview() {
    val category = CategoryUI(
        id = "1",
        name = "Electronics",
        imageRes = R.drawable.rice, // Replace with a valid drawable resource
        backgroundColor = androidx.compose.ui.graphics.Color.LightGray
    )
    CategoryCard(category = category, onClick = {})
}
