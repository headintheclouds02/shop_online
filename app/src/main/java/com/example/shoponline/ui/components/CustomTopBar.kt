package com.example.shoponline.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun CustomTopBar(
    title: String,
    cartIcon: ImageVector?,
    backArrowIcon: ImageVector?,
    onBackPress: () -> Unit
) {
    Row(
        modifier = Modifier
            .statusBarsPadding()
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically

    ) {
        if (backArrowIcon != null) {
            IconButton(
                onClick = onBackPress,
            ) {
                Icon(
                    backArrowIcon, "back arrow icon",
                    modifier = Modifier.size(25.dp)
                )
            }
        } else {
            Box(Modifier.size(30.dp))
        }

        Spacer(Modifier.weight(1f))

        Text(text = title)

        Spacer(Modifier.weight(1f))

        if (cartIcon != null) {
            IconButton(onClick = {}) {
                Icon(cartIcon, "cart arrow icon", modifier = Modifier.size(25.dp))
            }
        }
    }
}