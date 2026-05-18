package com.example.shoponline.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
    onBackPress: () -> Unit,
    onCartPress: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(vertical = 16.dp)
    ) {
        Text(
            text = title,
            modifier = Modifier.align(Alignment.Center)
        )

        Row(
            modifier = Modifier
                .matchParentSize()
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            if (backArrowIcon != null) {
                IconButton(onClick = onBackPress) {
                    Icon(
                        imageVector = backArrowIcon,
                        contentDescription = "Back",
                        modifier = Modifier.size(25.dp)
                    )
                }
            } else {
                Spacer(modifier = Modifier.size(48.dp))
            }

            Spacer(modifier = Modifier.weight(1f))

            if (cartIcon != null) {
                IconButton(onClick = onCartPress) {
                    Icon(
                        imageVector = cartIcon,
                        contentDescription = "Cart",
                        modifier = Modifier.size(25.dp)
                    )
                }
            } else {
                Spacer(modifier = Modifier.size(48.dp))
            }
        }

    }
}