package com.example.ecommere_app.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.ecommere_app.R
import com.example.ecommere_app.model.ProductUI

@Composable
fun FavoriteItem(
    product: ProductUI,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = product.imageRes),
            contentDescription = product.name,
            modifier = Modifier.size(86.dp)
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = product.name,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = product.subTitle,
                        color = Color.Gray.copy(0.9f),
                        style = MaterialTheme.typography.bodySmall
                    )
                }
                Text(
                    text = String.format("$%.2f", product.price),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier
                        .weight(1f) // Pushes Text to the right
                        .wrapContentWidth(Alignment.End) // Aligns text content to the end
                )
            }
        }
    }

}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun FavoriteItemPreview() {
    val product = ProductUI(
        id = "1",
        name = "Organic Bananas",
        subTitle = "7pcs, Priceg",
        price = 4.99,
        productDetail = "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healthful and varied diet.",
        nutrition = listOf("100gr", "35gr", "2.5gr", "80gr"),
        rating = 4.5f,
        isFavorite = true,
        imageRes = R.drawable.apple_
    )
    FavoriteItem(product = product)
}