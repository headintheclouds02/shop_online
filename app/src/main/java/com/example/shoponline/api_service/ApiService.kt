package com.example.shoponline.api_service

import com.example.shoponline.model.product.Product
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("products")
    suspend fun getProducts(): List<Product>

    @GET("products/{id}")
    suspend fun getProductById(
        @Path("id") productId: Int
    ): Product
}