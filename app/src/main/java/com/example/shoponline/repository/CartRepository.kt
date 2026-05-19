package com.example.shoponline.repository

interface CartRepository {

    suspend fun getCartItems(): Map<Int, Int>

    suspend fun saveCartItems(items: Map<Int, Int>)

    suspend fun clearCart()
}