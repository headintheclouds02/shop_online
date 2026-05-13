package com.example.shoponline.repository

import com.example.shoponline.api_service.retrofit.RetrofitInstance
import com.example.shoponline.model.product.Product

class ProductRepository {
    private val api = RetrofitInstance.api

    suspend fun getProducts(): List<Product> {
        return api.getProducts()
    }
}