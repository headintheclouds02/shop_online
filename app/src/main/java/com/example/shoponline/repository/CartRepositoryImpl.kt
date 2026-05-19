package com.example.shoponline.repository

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.qualifiers.ApplicationContext
import jakarta.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File

class CartRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val gson: Gson
) : CartRepository {

    private val fileName = "cart.json"

    override suspend fun getCartItems(): Map<Int, Int> {
        return withContext(Dispatchers.IO) {
            try {
                val file = File(context.filesDir, fileName)

                if (!file.exists()) {
                    return@withContext emptyMap()
                }

                val json = file.readText()

                if (json.isBlank()) {
                    return@withContext emptyMap()
                }

                val type = object : TypeToken<Map<Int, Int>>() {}.type

                gson.fromJson<Map<Int, Int>>(json, type) ?: emptyMap()

            } catch (e: Exception) {
                e.printStackTrace()
                emptyMap()
            }
        }
    }

    override suspend fun saveCartItems(items: Map<Int, Int>) {
        withContext(Dispatchers.IO) {
            val file = File(context.filesDir, fileName)
            val json = gson.toJson(items)
            file.writeText(json)
        }
    }

    override suspend fun clearCart() {
        withContext(Dispatchers.IO) {
            val file = File(context.filesDir, fileName)

            if (file.exists()) {
                file.delete()
            }
        }
    }
}