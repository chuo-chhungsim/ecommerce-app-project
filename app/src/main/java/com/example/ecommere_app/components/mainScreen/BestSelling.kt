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
import com.example.ecommere_app.R
import com.example.ecommere_app.components.ProductCard
import com.example.ecommere_app.components.Title
import com.example.ecommere_app.model.ProductUI
import productsDemo


@Composable
fun BestSellingSection(
    products: List<ProductUI>,
    onAddClick: (ProductUI) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Title(
            tittle = "Best Selling",
            modifier = Modifier,
            onSeeAll = { TODO() }
        )
        Spacer(Modifier.height(12.dp))

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
                    modifier = Modifier.width(180.dp)
                )

            }
        }
    }

}

@Preview(showSystemUi = false, showBackground = true)
@Composable
fun BestSellingSectionPreview() {
    BestSellingSection(productsDemo, onAddClick = {})
}