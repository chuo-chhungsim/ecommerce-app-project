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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommere_app.R
import com.example.ecommere_app.model.ProductUI

@Composable
fun CartItem(
    product: ProductUI,
    onIncrease: () -> Unit,
    onDecrease: () -> Unit,
    onRemove: () -> Unit
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
                IconButton(onClick = onRemove) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Remove"
                    )
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                var qty by rememberSaveable { mutableIntStateOf(1) }
                val total = product.price * qty
                IconButton(onClick = { if (qty > 1) qty-- }) {
                    Icon(
                        painter = painterResource(R.drawable.minus_24),
                        contentDescription = "-",
                        tint = Color.Black
                    )
                }
                Box(
                    modifier = Modifier
                        .border(
                            1.dp,
                            Color.Gray.copy(alpha = 0.7f),
                            RoundedCornerShape(12.dp)
                        ) // Border around the Box
                ) {
                    Text(
                        text = qty.toString(),
                        fontSize = 18.sp,
                        modifier = Modifier.padding(
                            vertical = 6.dp,
                            horizontal = 12.dp
                        ) // Internal padding for the text
                    )
                }
                IconButton(onClick = { qty++ }) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add",
                        tint = colorResource(R.color.btn_green)
                    )
                }
                Text(
                    text = String.format("$%.2f", total),
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
fun CartItemPreview() {
    val product = ProductUI(
        id = "1",
        name = "Sample Product",
        subTitle = "Sample Subtitle",
        price = 9.99,
        productDetail = "This is a sample product description.",
        nutrition = listOf("Nutrient 1", "Nutrient 2"),
        rating = 4.5f,
        isFavorite = false,
        imageRes = R.drawable.ic_launcher_background // Replace with a valid drawable resource
    )
    CartItem(product = product, onIncrease = {}, onDecrease = {}, onRemove = {})
}
