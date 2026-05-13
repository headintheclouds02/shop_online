package com.example.shoponline.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.shoponline.R
import com.example.shoponline.model.product.Product

@Composable
fun ProductCard(
    //modifier: Modifier,
    product: Product,
    navController: NavController
) {
    Box {
        Row() {
            /*AsyncImage(
                model = product.images[0],
                contentDescription = "api call product image"
            )*/

            Column() {
                Text(text = product.category.name)
                Text(text = product.title)
                Text(text = "€${product.price}")
            }

            IconButton(onClick = { navController.navigate("detail") }) {
                Icon(
                    painter = painterResource(R.drawable.chevron),
                    contentDescription = "forward arrow"
                )
            }
        }
    }
}