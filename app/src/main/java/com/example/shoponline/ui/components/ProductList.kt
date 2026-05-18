package com.example.shoponline.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.example.shoponline.model.product.Product
import com.example.shoponline.view_model.home.HomeViewModel

@Composable
fun ProductList(products: List<Product>, navController: NavController) {


    LazyColumn() {
        items(products) { product ->
            ProductCard(product, navController)
        }
    }
}