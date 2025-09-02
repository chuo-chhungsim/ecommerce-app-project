import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import com.example.ecommere_app.R
import com.example.ecommere_app.model.BottomNavItem
import com.example.ecommere_app.model.ProductUI

val productsDemo = listOf(
    ProductUI(
        id = "1",
        name = "Organic Bananas",
        subTitle = "7pcs, Priceg",
        price = "$4.99",
        imageRes = R.drawable.apple_
    ),
    ProductUI(
        id = "2",
        name = "Red Apple",
        subTitle = "1kg, Priceg",
        price = "$4.99",
        imageRes = R.drawable.apple_
    ),
    ProductUI(
        id = "3",
        name = "Strawberries",
        subTitle = "1kg, Priceg",
        price = "$5.99",
        imageRes = R.drawable.apple_
    ),
    ProductUI(
        id = "4",
        name = "Grapes",
        subTitle = "1kg, Priceg",
        price = "$6.99",
        imageRes = R.drawable.apple_
    )
)
val bottomNavItems = listOf(
    BottomNavItem("shop", "Shop", R.drawable.outline_storefront_24),
    BottomNavItem("explore", "Explore", R.drawable.outline_travel_explore_24),
    BottomNavItem("cart", "Cart", R.drawable.outline_shopping_cart_24),
    BottomNavItem("favourite", "Favourite", R.drawable.outline_favorite_24),
    BottomNavItem("account","Account", R.drawable.outline_person_24)
)