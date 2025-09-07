package com.example.ecommere_app.navigation

import android.net.Uri
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
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import bottomNavItems
import categoriesDemo
import com.example.ecommere_app.screen.AccountScreen
import com.example.ecommere_app.screen.CartContentScreen
import com.example.ecommere_app.screen.CategoryItemScreen
import com.example.ecommere_app.screen.ExploreContentScreen
import com.example.ecommere_app.screen.FavouritesContentScreen
import com.example.ecommere_app.screen.HomeContent
import com.example.ecommere_app.screen.OrderAcceptedScreen
import com.example.ecommere_app.utility.Screen
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
                    navController = tabsNavController,
                    categories = categoriesDemo,
                    categoryName = "Find Products"
                )
            }
            composable(
                route = Tab.Category.route,
                arguments = listOf(navArgument("categoryName") { type = NavType.StringType })
            ) { backStackEntry ->
                val rawName = backStackEntry.arguments?.getString("categoryName")
                val categoryName = rawName?.let { Uri.decode(it) } ?: "Category"

                CategoryItemScreen(
                    categoryName = categoryName,
                    products = productsDemo,
                    onAddClick = {},
                    navController = navController,
                    onBackClick = {
                        tabsNavController.popBackStack(
                            Tab.Explore.route,
                            inclusive = false
                        )
                    }
                )
            }
            composable(Tab.Cart.route) { CartContentScreen(products = productsDemo,navController = tabsNavController) }
            composable(Tab.OrderAccepted.route) {
                OrderAcceptedScreen(
                    onTrackOrder = {  },
                    onBackToHome = { navController.navigate(Screen.Home.route) })
            }
            composable(Tab.Favourite.route) { FavouritesContentScreen(
                products = productsDemo,
                navController = tabsNavController
            ) }
            composable(Tab.Account.route) { AccountScreen(
                onOrdersClick = {  },
                onMyDetailsClick = {  },
                onDeliveryAddressClick = {  },
                onPaymentMethodsClick = {  },
                onPromoClick = {  },
                onNotificationsClick = {  },
                onHelpClick = {  },
                onAboutClick = {  },
                onLogoutClick = {  }
            ) }
        }
    }
}


@Composable
fun AccountContent() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Account", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
    }
}
