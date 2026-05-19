package com.example.shoponline.ui.screens.cart

data class CartState(
    val items: Map<Int, Int> = emptyMap(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
) {
    val totalQuantity: Int
        get() = items.values.sum()

    fun quantityOf(productId: Int?): Int {
        return items[productId] ?: 0
    }

    fun isInCart(productId: Int): Boolean {
        return items.containsKey(productId)
    }
}