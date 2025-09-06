package com.example.ecommere_app.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ecommere_app.components.CategoryCard
import com.example.ecommere_app.components.SearchField
import com.example.ecommere_app.model.CategoryUI
import com.example.ecommere_app.utility.Tab

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExploreContentScreen(
    onSearch : (String) -> Unit,
    navController: NavController,
    categoryName: String?,
    categories: List<CategoryUI>
) {
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
                            categoryName ?: "Category",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        SearchField(
            onSearch = onSearch,
            placeholder = "Search Store",
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth()
        )

        Spacer(Modifier.height(8.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.padding(innerPadding)
        ) {
            items(categories, key = { it.id }) { category ->
                CategoryCard(
                    category = category,
                    onClick = {
                        navController.navigate(Tab.Category.createRoute(category.name))
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun ExploreContentScreenPreview() {
    val navController = rememberNavController()
    val categories = listOf(
        CategoryUI(
            id = "1",
            name = "Electronics",
            imageRes = android.R.drawable.ic_menu_camera,
            backgroundColor = androidx.compose.ui.graphics.Color.Red
        ),
        CategoryUI(
            id = "2",
            name = "Clothing",
            imageRes = android.R.drawable.ic_menu_gallery,
            backgroundColor = androidx.compose.ui.graphics.Color.Blue
        ),
        CategoryUI(
            id = "3",
            name = "Books",
            imageRes = android.R.drawable.ic_menu_agenda,
            backgroundColor = androidx.compose.ui.graphics.Color.Green
        )
    )
    ExploreContentScreen(onSearch = {},navController = navController, categoryName = "All Categories", categories = categories)
}