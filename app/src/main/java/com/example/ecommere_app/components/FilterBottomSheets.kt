package com.example.ecommere_app.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommere_app.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterBottomSheet(
    onDismiss: () -> Unit,
    onApply: (selectedCategories: List<String>, selectedBrands: List<String>) -> Unit
) {
    val categories = listOf("Egg", "Noddle & Pasta", "Chips","Fast Food")
    val brands = listOf("Individual Collection", "Cocoa", "Ifad","Kaizie Farmas")

    val selectedCategories = remember { mutableStateListOf<String>() }
    val selectedBrands = remember { mutableStateListOf<String>() }

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = rememberModalBottomSheetState()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            // 🔹 Categories Section
            Text("Categories", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            categories.forEach { category ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Checkbox(
                        checked = category in selectedCategories,
                        onCheckedChange = { isChecked ->
                            if (isChecked) selectedCategories.add(category)
                            else selectedCategories.remove(category)
                        },
                        colors = CheckboxDefaults.colors(
                            checkedColor = colorResource(id = R.color.btn_green),   // when checked
                            uncheckedColor = Color.Gray,                           // when unchecked
                            checkmarkColor = Color.White                           // tick mark color
                        )
                    )
                    Text(category)
                }
            }

            // 🔹 Brands Section
            Text("Brands", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            brands.forEach { brand ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Checkbox(
                        checked = brand in selectedBrands,
                        onCheckedChange = { isChecked ->
                            if (isChecked) selectedBrands.add(brand)
                            else selectedBrands.remove(brand)
                        },
                        colors = CheckboxDefaults.colors(
                            checkedColor = colorResource(id = R.color.btn_green),   // when checked
                            uncheckedColor = Color.Gray,                           // when unchecked
                            checkmarkColor = Color.White                           // tick mark color
                        )
                    )
                    Text(brand)
                }
            }

            Spacer(Modifier.height(16.dp))

            // 🔹 Apply Button
            PrimaryButton(
                text = "Apply Filter",
                onClick = {
                    onApply(selectedCategories, selectedBrands)
                    onDismiss()
                },
                backgroundColor = R.color.btn_green,
                contentColor = R.color.white,
            )
        }
    }
}
