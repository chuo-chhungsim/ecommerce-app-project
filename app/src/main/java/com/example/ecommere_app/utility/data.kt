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
        productDetail = "Crisp and sweet apples, full of fiber and Vitamin C. Perfect for snacking or juicing.",
        rating = 4.5f,
        nutrition = listOf("100 kcal", "High Fiber", "Vitamin C"),
        isFavorite = true,
        imageRes = R.drawable.apple_
    ),
    ProductUI(
        id = "2",
        name = "Chicken Drumsticks",
        subTitle = "7pcs, Price",
        price = 6.49,
        productDetail = "Tender chicken drumsticks, rich in protein and perfect for grilling or frying.",
        rating = 4.7f,
        nutrition = listOf("250 kcal", "High Protein", "Low Fat"),
        isFavorite = false,
        imageRes = R.drawable.chicken
    ),
    ProductUI(
        id = "3",
        name = "Beef Bone",
        subTitle = "500g, Price",
        price = 4.99,
        productDetail = "Premium beef bones ideal for broths and stews. Rich in collagen and flavor.",
        rating = 4.3f,
        nutrition = listOf("200 kcal", "Iron Rich", "Collagen"),
        isFavorite = true,
        imageRes = R.drawable.beffbone
    ),
    ProductUI(
        id = "4",
        name = "Red Chili",
        subTitle = "500g, Price",
        price = 2.49,
        productDetail = "Fresh and spicy red chilies to add heat and flavor to your cooking.",
        rating = 4.2f,
        nutrition = listOf("40 kcal", "Vitamin A", "Vitamin C"),
        isFavorite = false,
        imageRes = R.drawable.red_chile
    ),
    ProductUI(
        id = "5",
        name = "Diet Coca-Cola",
        subTitle = "500ml, Price",
        price = 1.49,
        productDetail = "The refreshing taste of Coca-Cola, without the sugar. Great for any occasion.",
        rating = 4.6f,
        nutrition = listOf("0 kcal", "Sugar Free", "Low Sodium"),
        isFavorite = true,
        imageRes = R.drawable.cocacola
    ),
    ProductUI(
        id = "6",
        name = "Sprite Can",
        subTitle = "330ml, Price",
        price = 1.29,
        productDetail = "Crisp lemon-lime flavored soda that refreshes instantly.",
        rating = 4.4f,
        nutrition = listOf("120 kcal", "Refreshing", "Carbonated"),
        isFavorite = false,
        imageRes = R.drawable.sprite
    ),
    ProductUI(
        id = "7",
        name = "Apple Juice",
        subTitle = "1L, Price",
        price = 2.99,
        productDetail = "100% natural apple juice with no added sugar. Great source of Vitamin C.",
        rating = 4.5f,
        nutrition = listOf("95 kcal", "Vitamin C", "Sugar Free"),
        isFavorite = true,
        imageRes = R.drawable.apple_juice
    ),
    ProductUI(
        id = "8",
        name = "Pepsi",
        subTitle = "500ml, Price",
        price = 1.49,
        productDetail = "Classic Pepsi cola with a bold and refreshing taste.",
        rating = 4.5f,
        nutrition = listOf("150 kcal", "Sugary Drink", "Caffeine"),
        isFavorite = false,
        imageRes = R.drawable.pepsi
    ),
    ProductUI(
        id = "9",
        name = "Egg Chicken Red",
        subTitle = "12pcs, Price",
        price = 3.49,
        productDetail = "Farm-fresh red chicken eggs, high in protein and nutrients.",
        rating = 4.6f,
        nutrition = listOf("80 kcal", "High Protein", "Vitamin B12"),
        isFavorite = true,
        imageRes = R.drawable.egg_chicken_red
    ),
    ProductUI(
        id = "10",
        name = "Egg White",
        subTitle = "6pcs, Price",
        price = 2.99,
        productDetail = "Low-fat egg whites, ideal for healthy diets and bodybuilding meals.",
        rating = 4.7f,
        nutrition = listOf("50 kcal", "High Protein", "Low Fat"),
        isFavorite = false,
        imageRes = R.drawable.white_egg
    ),
    ProductUI(
        id = "11",
        name = "Egg Pasta",
        subTitle = "500g, Price",
        price = 2.29,
        productDetail = "Authentic egg pasta made from premium flour and eggs. Cooks in minutes.",
        rating = 4.4f,
        nutrition = listOf("200 kcal", "Carbohydrates", "Protein"),
        isFavorite = true,
        imageRes = R.drawable.egg_pasta
    ),
    ProductUI(
        id = "12",
        name = "Egg Noodles",
        subTitle = "500g, Price",
        price = 2.59,
        productDetail = "Soft and tasty egg noodles, perfect for soups, stir-fries, and Asian dishes.",
        rating = 4.5f,
        nutrition = listOf("220 kcal", "Carbohydrates", "Protein"),
        isFavorite = false,
        imageRes = R.drawable.egg_noddle
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