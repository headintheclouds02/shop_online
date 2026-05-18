package com.example.shoponline.view_model.cart

import androidx.lifecycle.ViewModel
import com.example.shoponline.ui.screens.cart.CartState
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
class CartViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(CartState())
    val state = _state.asStateFlow()

    fun addItem(productId: Int) {
        val currentQty = _state.value.quantities[productId] ?: 0

        _state.update {
            it.copy(
                quantities = it.quantities + (productId to currentQty + 1)
            )
        }
    }

    fun removeItem(productId: Int) {
        val currentQty = _state.value.quantities[productId] ?: 0
        val newQty = (currentQty - 1).coerceAtLeast(0)

        _state.update {
            it.copy(
                quantities =
                    if (newQty == 0)
                        it.quantities - productId
                    else
                        it.quantities + (productId to newQty)
            )
        }
    }

    fun getQuantity(productId: Int): Int {
        return _state.value.quantities[productId] ?: 0
    }
}