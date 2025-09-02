package com.example.ecommere_app.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import bottomNavItems
import com.example.ecommere_app.components.SearchField
import com.example.ecommere_app.components.mainScreen.Banner
import com.example.ecommere_app.components.mainScreen.BestSellingSection
import com.example.ecommere_app.components.mainScreen.ExclusiveOfferSection
import com.example.ecommere_app.model.ProductUI
import com.example.ecommere_app.navigation.BottomNavBar
import com.example.ecommere_app.navigation.TopAppBar
import productsDemo

@Composable
fun HomeContent(
    onSearch: (String) -> Unit,
    products: List<ProductUI>
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.height(8.dp))

        SearchField(
            onSearch = onSearch,
            placeholder = "Search Store",
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth()
        )

        Spacer(Modifier.height(8.dp))

        Banner(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        Spacer(Modifier.height(12.dp))

        ExclusiveOfferSection(products = products, onAddClick = { /* add */ })

        Spacer(Modifier.height(12.dp))

        BestSellingSection(products = products, onAddClick = { /* add */ })
    }
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun HomeContentPreview() {
    val products = productsDemo
    HomeContent(onSearch = {}, products = products)
}

