package com.example.ecommere_app.screen

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.StarHalf
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.IosShare
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommere_app.R
import com.example.ecommere_app.components.PrimaryButton
import productsDemo

@Composable
fun ProductDetailScreen(
    productId: String?,
    onBackClick: () -> Unit
) {
    val product = productsDemo.find { it.id == productId }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        if (productId == null) {
            Spacer(Modifier.height(30.dp))
            IconButton(
                onClick = {
                    onBackClick() // Trigger back navigation
                    // Optional: Add logging for debugging
                    println("Back button clicked for productId: $productId")
                }
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.Black
                )
            }
            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Default.IosShare,
                    contentDescription = "share",
                    tint = Color.Black
                )
            }
            Text("Invalid product ID", fontSize = 20.sp, color = Color.Red)
        } else {
            product?.let {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(bottomEnd = 16.dp, bottomStart = 16.dp))
                ) {
                    Image(
                        painter = painterResource(it.imageRes),
                        contentDescription = it.name,
                        modifier = Modifier
                            .height(350.dp)
                            .background(color = colorResource(R.color.btn_green).copy(0.15f))
                            .fillMaxWidth(),
                        contentScale = ContentScale.Fit,
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth().align(Alignment.TopCenter)
                    ) {
                        IconButton(
                            onClick = {
                                onBackClick() // Trigger back navigation
                                // Optional: Add logging for debugging
                                println("Back button clicked for productId: $productId")
                            },
                            modifier = Modifier.padding(top = 30.dp)
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back",
                                tint = Color.Black
                            )
                        }
                        IconButton(
                            onClick = {},
                            modifier = Modifier.padding(top = 30.dp)

                        ) {
                            Icon(
                                imageVector = Icons.Default.IosShare,
                                contentDescription = "share",
                                tint = Color.Black
                            )
                        }
                    }
                }
                Spacer(Modifier.height(16.dp))
                Column(modifier = Modifier.padding(horizontal = 12.dp)) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = it.name,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF2E2E2E)
                        )
                        Spacer(Modifier.weight(1f))

                        var isFavorite by remember { mutableStateOf(it.isFavorite ?: false) }

                        IconButton(onClick = { isFavorite = !isFavorite }) {
                            Icon(
                                imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                                contentDescription = if (isFavorite) "Unfavorite" else "Favorite",
                                tint = if (isFavorite) Color.Red else Color.Gray,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                    Spacer(Modifier.height(6.dp))
                    Text(text = it.subTitle, fontSize = 12.sp, color = Color.Gray)
                    Spacer(Modifier.height(6.dp))

                    var qty by rememberSaveable { mutableIntStateOf(1) }
                    val total = it.price * qty

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        IconButton(onClick = { if (qty > 1) qty-- }) {
                            Icon(
                                painter = painterResource(R.drawable.minus_24),
                                contentDescription = "-",
                                tint = Color.Black
                            )
                        }
                        Box(
                            modifier = Modifier
                                .border(
                                    1.dp,
                                    Color.Gray.copy(alpha = 0.7f),
                                    RoundedCornerShape(12.dp)
                                ) // Border around the Box
                        ) {
                            Text(
                                text = qty.toString(),
                                fontSize = 18.sp,
                                modifier = Modifier.padding(
                                    vertical = 6.dp,
                                    horizontal = 12.dp
                                ) // Internal padding for the text
                            )
                        }
                        IconButton(onClick = { qty++ }) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "Add",
                                tint = colorResource(R.color.btn_green)
                            )
                        }
                        Text(
                            text = String.format("$%.2f", total),
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            modifier = Modifier
                                .weight(1f) // Pushes Text to the right
                                .wrapContentWidth(Alignment.End) // Aligns text content to the end
                        )
                    }
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = MaterialTheme.colorScheme.outlineVariant,
                        modifier = Modifier.padding(vertical = 16.dp)
                    )
                    var expanded by remember { mutableStateOf(false) }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Product Detail", fontWeight = FontWeight.Bold)
                        Icon(
                            painter = if (expanded) painterResource(R.drawable.baseline_expand_more_24)
                            else painterResource(R.drawable.outline_expand_less_24),
                            contentDescription = null,
                            tint = Color.Black,
                            modifier = Modifier.clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null,
                                onClick = { expanded = !expanded })
                        )
                    }
                    Column(
                        modifier = Modifier
                            .animateContentSize() // smooth expand/collapse
                    ) {
                        Text(
                            text = it.productDetail,
                            maxLines = if (expanded) Int.MAX_VALUE else 2,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = if (expanded) "Read less" else "Read more",
                            color = colorResource(R.color.btn_green),
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(top = 4.dp)
                                .align(Alignment.End)
                                .clickable { expanded = !expanded }
                        )
                    }
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = MaterialTheme.colorScheme.outlineVariant,
                        modifier = Modifier.padding(vertical = 16.dp)
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Nutrition", fontWeight = FontWeight.Bold)
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            product.nutrition.forEach { items ->
                                Box(
                                    modifier = Modifier
                                        .background(
                                            color = Color.Gray.copy(alpha = 0.5f),
                                            shape = RoundedCornerShape(8.dp)
                                        )
                                ) {
                                    Text(
                                        text = items,
                                        fontSize = 8.sp,
                                        modifier = Modifier
                                            .padding(
                                                vertical = 2.dp,
                                                horizontal = 6.dp
                                            )
                                    )
                                }
                            }
                        }
                    }
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = MaterialTheme.colorScheme.outlineVariant,
                        modifier = Modifier.padding(vertical = 16.dp)
                    )
                    val rating = it.rating // already Float

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Reviews", fontWeight = FontWeight.Bold)
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            repeat(5) { index ->
                                val starIcon = when {
                                    rating >= index + 1 -> Icons.Filled.Star
                                    rating > index -> Icons.AutoMirrored.Filled.StarHalf // use vector, not drawable
                                    else -> Icons.Outlined.Star
                                }
                                Icon(
                                    imageVector = starIcon,
                                    contentDescription = null,
                                    tint = Color(0xFFFFC107),
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                            Spacer(Modifier.width(4.dp))
                            Text(
                                text = String.format("%.1f", rating), // format float to 1 decimal
                                fontSize = 12.sp
                            )
                        }
                    }
                    Spacer(Modifier.height(16.dp))
                    PrimaryButton(
                        backgroundColor = R.color.btn_green,
                        text = "Add to Basket",
                        onClick = {},
                        contentColor = R.color.white,
                    )
                }
            } ?: Text("Product not found", fontSize = 20.sp, color = Color.Red)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, device = "spec:width=411dp,height=891dp")
@Composable
fun ProductDetailScreenPreview() {
    ProductDetailScreen(productId = productsDemo.firstOrNull()?.id, onBackClick = {})
}


