package com.example.ecommere_app.components.mainScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ecommere_app.components.GroceriesCard
import com.example.ecommere_app.components.ProductCard
import com.example.ecommere_app.components.Title
import com.example.ecommere_app.model.GroceriesUI
import com.example.ecommere_app.model.ProductUI
import groceriesDemo
import productsDemo


@Composable
fun GroceriesSection(
    category: List<GroceriesUI>,
    products: List<ProductUI>,
    onAddClick: (ProductUI) -> Unit,
    navController: NavController
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Title(
            title = "Groceries",
            onSeeAll = { TODO() },
            modifier = Modifier
        )
        Spacer(Modifier.height(12.dp))
        val categoriesState = rememberLazyListState()
        LazyRow(
            state = categoriesState,
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(category, key = { it.id }) { item ->
                GroceriesCard(
                    item = item,
                    modifier = Modifier.width(280.dp)
                )
            }
        }
        Spacer(Modifier.height(16.dp))

        val listState = rememberLazyListState()

        LazyRow(
            state = listState,
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(products, key = { it.id }) { product ->
                ProductCard(
                    product = product,
                    onAddClick = { onAddClick(product) },
                    modifier = Modifier.width(180.dp),
                    navController = navController
                )
            }
        }
    }
}

@Preview(showSystemUi = false, showBackground = true)
@Composable
fun GroceriesSectionPreview() {
    val navController = rememberNavController()
    GroceriesSection(category = groceriesDemo,productsDemo, onAddClick = {},navController = navController)
}
