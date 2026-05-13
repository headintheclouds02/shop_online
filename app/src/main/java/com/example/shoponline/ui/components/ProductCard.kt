package com.example.shoponline.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil3.compose.AsyncImage

@Composable
fun ProductCard(
    modifier: Modifier,
    imageUrl: String,
    category: String,
    productName: String,
    price: Double
) {
    Box {
        Row() {
            AsyncImage(
                model = imageUrl,
                contentDescription = "api call product image"
            )

            Column() {
                Text(text = category)
                Text(text = productName)
                Text(text = "€$price")
            }
        }
    }

}