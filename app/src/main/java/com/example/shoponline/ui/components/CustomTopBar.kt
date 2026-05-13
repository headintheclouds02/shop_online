package com.example.shoponline.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun CustomTopBar(
    title: String,
    cartIcon: ImageVector?,
    backArrowIcon: ImageVector?,
) {
    Row {
        if (backArrowIcon != null) {
            IconButton(onClick = {}) {
                Icon( backArrowIcon, "back arrow icon")
            }
        }

        Text(text = title)

        if (cartIcon != null) {
            IconButton(onClick = {}) {
                Icon( cartIcon, "cart arrow icon")
            }
        }
    }
}