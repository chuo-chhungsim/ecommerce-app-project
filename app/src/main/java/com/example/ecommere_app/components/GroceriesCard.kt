package com.example.ecommere_app.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommere_app.R
import com.example.ecommere_app.model.GroceriesUI

@Composable
fun GroceriesCard(
    item: GroceriesUI,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = item.backgroundColor),
        border = BorderStroke(1.dp, Color(0xFFE6E6E6)),
        modifier = modifier
    ) {
        Row(Modifier.padding(vertical = 6.dp , horizontal = 12.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(item.imageRes),
                contentDescription = item.itemName,
                modifier = Modifier
                    .height(120.dp)
                    .fillMaxHeight(),
                contentScale = ContentScale.Fit
            )
            Text(
                text = item.itemName,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                fontSize = 24.sp,
                modifier = Modifier.padding(start = 12.dp)
            )
        }
    }
}

@Preview
@Composable
fun GroceriesCardPreview() {
    val item = GroceriesUI(
        id = "1",
        itemName = "Organic Bananas",
        backgroundColor = Color.Yellow,
        imageRes = R.drawable.pulses
    )
    GroceriesCard(item = item)
}
