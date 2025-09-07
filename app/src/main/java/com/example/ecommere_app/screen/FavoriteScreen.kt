package com.example.ecommere_app.screen


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ecommere_app.R
import com.example.ecommere_app.components.ErrorModal
import com.example.ecommere_app.components.FavoriteItem
import com.example.ecommere_app.components.PrimaryButton
import com.example.ecommere_app.model.ProductUI
import com.example.ecommere_app.utility.Screen
import com.example.ecommere_app.utility.Tab

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavouritesContentScreen(
    products: List<ProductUI>, navController: NavController
) {
    var showErrorDialog by remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            "Favorite", fontSize = 24.sp, fontWeight = FontWeight.SemiBold
                        )
                    }
                })
        },
        bottomBar = {
            PrimaryButton(
                backgroundColor = R.color.btn_green,
                text = "Add All to Cart",
                onClick = { },
                contentColor = R.color.white,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 32.dp)
            )
        }) { innerPadding ->
        HorizontalDivider(
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.outlineVariant,
            modifier = Modifier.padding(innerPadding)
        )
        LazyColumn(
            contentPadding = innerPadding
        ) {
            items(products, key = { it.id }) { product ->
                FavoriteItem(
                    product = product,
                )
                HorizontalDivider(
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.outlineVariant,
                    modifier = Modifier.padding(bottom = 6.dp)
                )
            }

        }
    }
    if (showErrorDialog) {
        ErrorModal(
            onDismiss = { showErrorDialog = false },
            onTryAgain = { showErrorDialog = false },
            onBackToHome = {
                showErrorDialog = false
                navController.navigate(Tab.Shop.route)
            }
        )
    }
}

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavouritesContentScreenPreview() {
    val products = listOf(
        ProductUI(
            id = "1",
            name = "Organic Bananas",
            subTitle = "7pcs, Priceg",
            price = 4.99,
            productDetail = "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healtful and varied diet.",
            nutrition = listOf("100gr", "Vitamin C", "Potassium"),
            rating = 4.5f,
            isFavorite = true,
            imageRes = R.drawable.apple_
        ),
        ProductUI(
            id = "2",
            name = "Red Apple",
            subTitle = "1kg, Priceg",
            price = 4.99,
            productDetail = "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healtful and varied diet.",
            nutrition = listOf("100gr", "Vitamin C", "Potassium"),
            rating = 4.8f,
            isFavorite = false,
            imageRes = R.drawable.ic_fruits
        ))
    FavouritesContentScreen(products = products, navController = rememberNavController())
}