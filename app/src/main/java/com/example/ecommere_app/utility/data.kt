import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.Color
import com.example.ecommere_app.R
import com.example.ecommere_app.model.BottomNavItem
import com.example.ecommere_app.model.CategoryUI
import com.example.ecommere_app.model.GroceriesUI
import com.example.ecommere_app.model.ProductUI

val productsDemo = listOf(
    ProductUI(
        id = "1",
        name = "Fresh Apples",
        subTitle = "1kg, Price",
        price = 3.99,
        productDetail = "Apples are nutritious and a good source of fiber and vitamin C. They may help with weight management and heart health.",
        rating = 4.5f,
        nutrition = listOf("100 kcal", "Sugar Free", "Low Fat"),
        isFavorite = true,
        imageRes = R.drawable.apple_ // replace with your actual drawable
    ),
    ProductUI(
        id = "2",
        name = "Bananas",
        subTitle = "7pcs, Price",
        price = 2.49,
        productDetail = "Bananas are rich in potassium and great for quick energy. A perfect snack for kids and athletes.",
        rating = 4.7f,
        nutrition = listOf("100 kcal", "Sugar Free", "Low Fat"),
        isFavorite = false,
        imageRes = R.drawable.apple_ // replace with your actual drawable
    ),
    ProductUI(
        id = "3",
        name = "Carrots",
        subTitle = "500g, Price",
        price = 1.99,
        productDetail = "Carrots are crunchy and packed with beta-carotene, fiber, vitamin K1, and antioxidants.",
        rating = 4.3f,
        nutrition = listOf("100 kcal", "Sugar Free", "Low Fat"),
        isFavorite = true,
        imageRes = R.drawable.apple_ // replace with your actual drawable
    )
)

val groceriesDemo = listOf(
    GroceriesUI(
        id = "1",
        itemName = "Rice",
        backgroundColor = Color(0xFFE0F7FA), // light teal
        imageRes = R.drawable.rice   // replace with your drawable
    ),
    GroceriesUI(
        id = "2",
        itemName = "pulses",
        backgroundColor = Color(0xFFFFF3E0), // light orange
        imageRes = R.drawable.pulses       // replace with your drawable
    )
)

val categoriesDemo = listOf(
    CategoryUI(
        id = "1",
        name = "Fresh Fruits & Vegetable",
        imageRes = R.drawable.ic_fruits, // replace with your drawable
        backgroundColor = Color(0xFFDFF6DD) // light green
    ),
    CategoryUI(
        id = "2",
        name = "Cooking Oil & Ghee",
        imageRes = R.drawable.ic_oil, // replace with your drawable
        backgroundColor = Color(0xFFFFF2CC) // light yellow
    ),
    CategoryUI(
        id = "3",
        name = "Meat & Fish",
        imageRes = R.drawable.ic_meat, // replace with your drawable
        backgroundColor = Color(0xFFFFE0E0) // light red/pink
    ),
    CategoryUI(
        id = "4",
        name = "Bakery & Snacks",
        imageRes = R.drawable.ic_bakery, // replace with your drawable
        backgroundColor = Color(0xFFF1E0FF) // light purple
    ),
    CategoryUI(
        id = "5",
        name = "Dairy & Eggs",
        imageRes = R.drawable.ic_dairy, // replace with your drawable
        backgroundColor = Color(0xFFFFF9DB) // light cream
    ),
    CategoryUI(
        id = "6",
        name = "Beverages",
        imageRes = R.drawable.ic_beverages, // replace with your drawable
        backgroundColor = Color(0xFFE0F4FF) // light blue
    )
)

val bottomNavItems = listOf(
    BottomNavItem("shop", "Shop", R.drawable.outline_storefront_24),
    BottomNavItem("explore", "Explore", R.drawable.outline_travel_explore_24),
    BottomNavItem("cart", "Cart", R.drawable.outline_shopping_cart_24),
    BottomNavItem("favourite", "Favourite", R.drawable.outline_favorite_24),
    BottomNavItem("account","Account", R.drawable.outline_person_24)
)