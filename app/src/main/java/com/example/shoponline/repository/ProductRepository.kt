package com.example.shoponline.repository

import com.example.shoponline.api_service.ApiService
import com.example.shoponline.model.product.Product
import jakarta.inject.Inject

class ProductRepository @Inject constructor(
    private val api: ApiService
) {

    suspend fun getProducts(): List<Product> {
        return api.getProducts()
    }
}