package com.example.ecommere_app.model

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val route: String,
    val label: String,
    val iconRes: Int,
    val selectedIconRes: Int? = null // optional
)