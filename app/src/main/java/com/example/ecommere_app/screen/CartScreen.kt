package com.example.ecommere_app.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.material3.rememberModalBottomSheetState
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
import com.example.ecommere_app.components.CartItem
import com.example.ecommere_app.R
import com.example.ecommere_app.components.CheckoutBottomSheet
import com.example.ecommere_app.components.PrimaryButton
import com.example.ecommere_app.model.ProductUI
import com.example.ecommere_app.utility.Screen
import com.example.ecommere_app.utility.Tab
import productsDemo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartContentScreen(
    products: List<ProductUI>,
    navController: NavController
) {
    var showCheckoutSheet by remember { mutableStateOf(false) }
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        "My Cart", fontSize = 24.sp, fontWeight = FontWeight.SemiBold
                    )
                }
            })
    }, bottomBar = {
        PrimaryButton(
            backgroundColor = R.color.btn_green,
            text = "Go to Checkout",
            onClick = { showCheckoutSheet = true },
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
                CartItem(
                    product = product,
                    onIncrease = { /* Handle increase */ },
                    onDecrease = { /* Handle decrease */ },
                    onRemove = { /* Handle remove */ })
                HorizontalDivider(
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.outlineVariant,
                    modifier = Modifier.padding(bottom = 6.dp)
                )
            }

        }
    }
    if (showCheckoutSheet) {
        CheckoutBottomSheet(
            onDismiss = { showCheckoutSheet = false },
            onPlaceOrder = {
                showCheckoutSheet = false
                navController.navigate(Tab.OrderAccepted.route)
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun CartContentScreenPreview() {
    val navController = rememberNavController()
    CartContentScreen(products = productsDemo, navController = navController )
}