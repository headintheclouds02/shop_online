package com.example.shoponline.model

import com.example.shoponline.model.product.Product

data class CartItem(
    val product: Product,
    val quantity: Int
)