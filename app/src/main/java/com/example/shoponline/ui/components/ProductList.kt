package com.example.shoponline.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.shoponline.view_model.product.ProductViewModel

@Composable
fun ProductList(viewModel: ProductViewModel) {
    val products by viewModel.products.collectAsState()

    LazyColumn() {
        items(products) { product ->
            ProductCard(product)

        }

    }
}