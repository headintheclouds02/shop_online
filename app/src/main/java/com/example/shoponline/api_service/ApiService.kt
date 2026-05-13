package com.example.shoponline.api_service

import com.example.shoponline.model.product.Product
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getProducts(): List<Product>
}