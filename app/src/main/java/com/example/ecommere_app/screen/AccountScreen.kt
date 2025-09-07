package com.example.ecommere_app.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.outlined.CardGiftcard
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material.icons.outlined.Help
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Payment
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommere_app.R
import com.example.ecommere_app.components.PrimaryButton

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AccountScreen(
    onOrdersClick: () -> Unit,
    onMyDetailsClick: () -> Unit,
    onDeliveryAddressClick: () -> Unit,
    onPaymentMethodsClick: () -> Unit,
    onPromoClick: () -> Unit,
    onNotificationsClick: () -> Unit,
    onHelpClick: () -> Unit,
    onAboutClick: () -> Unit,
    onLogoutClick: () -> Unit
) {
    Scaffold(
        bottomBar = {
            PrimaryButton(
                backgroundColor = R.color.lignt_gray,
                text = "Logout",
                onClick = onLogoutClick,
                contentColor = R.color.btn_green,
                modifier = Modifier.padding(vertical = 4.dp, horizontal = 12.dp)
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding()
                .background(Color.White)
        ) {
            // ---- Profile Header ----
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.avatar),
                    contentDescription = "Profile",
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text("Chuo Chhungsim", fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
                    Text("chhungsim.chuo@gmail.com", color = Color.Gray, fontSize = 14.sp)
                }
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit",
                    tint = Color(0xFF4CAF50)
                )
            }

            HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)

            // ---- Menu List ----
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
            ) {
                item {
                    MenuItem(
                        icon = Icons.Outlined.ShoppingCart,
                        title = "Orders",
                        onClick = onOrdersClick
                    )
                }
                item {
                    MenuItem(
                        icon = Icons.Outlined.CreditCard,
                        title = "My Details",
                        onClick = onMyDetailsClick
                    )
                }
                item {
                    MenuItem(
                        icon = Icons.Outlined.LocationOn,
                        title = "Delivery Address",
                        onClick = onDeliveryAddressClick
                    )
                }
                item {
                    MenuItem(
                        icon = Icons.Outlined.Payment,
                        title = "Payment Methods",
                        onClick = onPaymentMethodsClick
                    )
                }
                item {
                    MenuItem(
                        icon = Icons.Outlined.CardGiftcard,
                        title = "Promo Code",
                        onClick = onPromoClick
                    )
                }
                item {
                    MenuItem(
                        icon = Icons.Outlined.Notifications,
                        title = "Notifications",
                        onClick = onNotificationsClick
                    )
                }
                item {
                    MenuItem(
                        icon = Icons.Outlined.Help,
                        title = "Help",
                        onClick = onHelpClick
                    )
                }
                item {
                    MenuItem(
                        icon = Icons.Outlined.Info,
                        title = "About",
                        onClick = onAboutClick
                    )
                }
            }

        }
    }
}

@Composable
fun MenuItem(icon: ImageVector, title: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 16.dp, horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(icon, contentDescription = title, tint = Color.Black)
        Spacer(modifier = Modifier.width(16.dp))
        Text(title, fontSize = 16.sp, color = Color.Black)
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = "Go",
            tint = Color.Gray
        )
    }
    HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)
}

@Preview
@Composable
fun AccountScreenPreview() {
    AccountScreen(
        onOrdersClick = {},
        onMyDetailsClick = {},
        onDeliveryAddressClick = {},
        onPaymentMethodsClick = {},
        onPromoClick = {},
        onNotificationsClick = {},
        onHelpClick = {},
        onAboutClick = {},
        onLogoutClick = {}
    )
}



