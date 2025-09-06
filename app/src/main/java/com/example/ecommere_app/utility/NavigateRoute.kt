package com.example.ecommere_app.utility

import com.example.ecommere_app.R

sealed class Screen(val route: String) {
    data object OnBoard : Screen("onboard")
    data object Login : Screen("login")
    data object SignUp : Screen("signup")
    data object Home : Screen("home")
}

sealed class Tab(
    val route: String,
    val label: String,
    val icon: Int,
    val selectedIcon: Int? = null
) {
    data object Shop : Tab("shop", "Shop", R.drawable.outline_storefront_24)
    data object Explore : Tab("explore", "Explore", R.drawable.outline_travel_explore_24)
    object Category : Screen("category/{categoryName}") {
        fun createRoute(categoryName: String) = "category/$categoryName"
    }
    data object Cart : Tab("cart", "Cart", R.drawable.outline_shopping_cart_24)
    data object Favourite : Tab("favourite", "Favourite", R.drawable.outline_favorite_24)
    data object Account : Tab("account", "Account", R.drawable.outline_person_24)
}

val Tabs = listOf(Tab.Shop, Tab.Explore, Tab.Cart, Tab.Favourite, Tab.Account)