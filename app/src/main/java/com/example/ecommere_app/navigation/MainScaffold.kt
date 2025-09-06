package com.example.ecommere_app.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import bottomNavItems
import categoriesDemo
import com.example.ecommere_app.screen.ExploreContentScreen
import com.example.ecommere_app.screen.HomeContent
import com.example.ecommere_app.utility.Tab
import groceriesDemo
import productsDemo

@Composable
fun MainScreen(
    navController: NavHostController,              // outer nav (for auth → main)re
    tabsNavController: NavHostController = rememberNavController() // inner nav for tabs
) {
    val currentBackStack by tabsNavController.currentBackStackEntryAsState()
    val currentRoute = currentBackStack?.destination?.route
    Scaffold(
        topBar = {
            when (currentRoute) {
                Tab.Shop.route -> TopAppBar()
            }
        },
        bottomBar = { BottomNavBar(tabsNavController, bottomNavItems) }
    ) { innerPadding ->
        NavHost(
            navController = tabsNavController,
            startDestination = Tab.Shop.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Tab.Shop.route) {
                HomeContent(
                    onSearch = { /* handle */ },
                    products = productsDemo, groceries = groceriesDemo,
                    navController = navController
                )
            }
            composable(Tab.Explore.route) {
                ExploreContentScreen(
                    onSearch = {},
                    navController = navController,
                    categories = categoriesDemo,
                    categoryName = "Find Products"
                )
            }
            composable(Tab.Cart.route) { CartContent() }
            composable(Tab.Favourite.route) { FavouriteContent() }
            composable(Tab.Account.route) { AccountContent() }
        }
    }
}


@Composable
fun CartContent() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Cart", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
    }
}
@Composable
fun FavouriteContent() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Favourite", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
fun AccountContent() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Account", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
    }
}
