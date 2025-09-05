package com.example.ecommere_app.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommere_app.R

@Composable
fun Title(
    title: String,
    onSeeAll: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = title,
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = modifier
        )
        Text(
            text = "See all",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = colorResource(R.color.btn_green),
            modifier = Modifier.clickable { onSeeAll() }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TittlePreview() {
    Title(title = "Sample Title", onSeeAll = {})

}
