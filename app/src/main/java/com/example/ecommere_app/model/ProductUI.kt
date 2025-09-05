package com.example.ecommere_app.model

data class ProductUI(
    val id: String,
    val name: String,
    val subTitle: String,   // e.g., "7pcs, Priceg"
    val price: Double,      // e.g., "$4.99"
    val productDetail : String,
    val nutrition :  List<String>,
    val rating : Float,
    val isFavorite : Boolean?,
    val imageRes: Int
)