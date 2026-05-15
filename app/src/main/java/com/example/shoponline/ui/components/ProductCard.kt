package com.example.shoponline.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.shoponline.R
import com.example.shoponline.model.product.Product

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ProductCard(
    product: Product,
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp)
    ) {
        Row() {
            GlideImage(
                model = product.images[0],
                contentDescription = stringResource(R.string.image_description),
                modifier = Modifier.size(80.dp)
            )

            Spacer(Modifier.padding(horizontal = 8.dp))

            Box(modifier = Modifier.width(200.dp)) {
                Column() {
                    Text(text = product.category.name)
                    Text(text = product.title, maxLines = 1, overflow = TextOverflow.Ellipsis)
                    Text(text = "€ ${product.price}")
                }
            }

            IconButton(onClick = { navController.navigate("detail") }, modifier = Modifier.size(40.dp).) {
                Icon(
                    painter = painterResource(R.drawable.chevron),
                    contentDescription = "forward arrow"
                )
            }
        }
    }
}