package com.example.ecommere_app.model

data class ProductUI(
    val id: String,
    val name: String,
    val subTitle: String,   // e.g., "7pcs, Priceg"
    val price: String,      // e.g., "$4.99"
    val imageRes: Int
)