package com.example.ecommere_app.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ecommere_app.R
import com.example.ecommere_app.model.ProductUI

@Composable
fun ProductCard(
    product: ProductUI,
    onAddClick: (ProductUI) -> Unit,
    modifier: Modifier = Modifier,
    navController: NavController
) {

    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(1.dp, Color(0xFFE6E6E6)),
        modifier = modifier.clickable { navController.navigate("productDetail/${product.id}") }
    ) {
        Column(Modifier.padding(12.dp), horizontalAlignment = Alignment.Start) {
            Image(
                painter = painterResource(product.imageRes),
                contentDescription = product.name,
                modifier = Modifier
                    .height(120.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Fit
            )
            Spacer(Modifier.height(16.dp))
            Text(
                product.name,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                color = Color.Black
            )
            Text(product.subTitle, color = Color.Gray, fontSize = 12.sp)
            Spacer(Modifier.height(12.dp))
            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    product.price.toString(),
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp
                )
                Spacer(Modifier.weight(1f))
                Box(
                    Modifier
                        .size(36.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(0xFF53B175))
                        .clickable { onAddClick(product) },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add",
                        tint = Color.White
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = false, showBackground = true)
@Composable
fun ProductCardPreview() {
    val product = ProductUI(
        id = "1",
        name = "Organic Bananas",
        subTitle = "7pcs, Price",
        price = 4.99,
        rating = 4.5f,
        productDetail = "hi",
        nutrition = listOf("100 kcal", "Sugar Free", "Low Fat"),
        isFavorite = true,
        imageRes = R.drawable.apple_
    )
    val navController = rememberNavController()
    ProductCard(product = product, onAddClick = {}, navController = navController)
}