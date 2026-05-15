package com.example.shoponline.model.product

import com.example.shoponline.model.category.Category

data class Product(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: Category,
    val images: List<String>
)
