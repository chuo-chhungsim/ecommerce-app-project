package com.example.ecommere_app.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.sin

@Composable
fun SearchField(
    placeholder: String,
    onSearch: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var query by remember { mutableStateOf("") }

    TextField(
        value = query,
        onValueChange = { query = it },
        placeholder = { Text(text = placeholder) },
        singleLine = true,
        leadingIcon = {
            Icon(
                Icons.Outlined.Search,
                contentDescription = null
            )
        },
        shape = RoundedCornerShape(16.dp),
        textStyle = LocalTextStyle.current.copy(fontSize = 16.sp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.LightGray,
            unfocusedContainerColor = Color.LightGray,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = Color.Black
        ),
        modifier = modifier,
    )
}

@Preview
@Composable
fun SearchFieldPreview() {
    SearchField(
        placeholder = "Search products",
        onSearch = {}
    )
}