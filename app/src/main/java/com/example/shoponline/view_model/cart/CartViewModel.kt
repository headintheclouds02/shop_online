package com.example.shoponline.view_model.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoponline.model.product.Product
import com.example.shoponline.repository.CartRepository
import com.example.shoponline.ui.screens.cart.CartState
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class CartViewModel @Inject constructor(
    private val cartRepository: CartRepository
) : ViewModel() {

    private val _state = MutableStateFlow(CartState(isLoading = true))
    val state: StateFlow<CartState> = _state.asStateFlow()

    init {
        loadCart()
    }

    private fun loadCart() {
        viewModelScope.launch {
            _state.update { currentState ->
                currentState.copy(isLoading = true)
            }

            try {
                val savedItems = cartRepository.getCartItems()

                _state.update {
                    CartState(
                        items = savedItems,
                        isLoading = false,
                        errorMessage = null
                    )
                }
            } catch (e: Exception) {
                e.printStackTrace()

                _state.update { currentState ->
                    currentState.copy(
                        isLoading = false,
                        errorMessage = "Error while loading cart"
                    )
                }
            }
        }
    }

    fun addItem(productId: Int) {
        val currentItems = _state.value.items

        val currentQuantity = currentItems[productId] ?: 0
        val updatedQuantity = currentQuantity + 1

        val updatedItems = currentItems + (productId to updatedQuantity)

        updateCart(updatedItems)
    }

    fun removeItem(productId: Int) {
        val currentItems = _state.value.items

        val currentQuantity = currentItems[productId] ?: return

        val updatedItems =
            if (currentQuantity <= 1) {
                currentItems - productId
            } else {
                currentItems + (productId to currentQuantity - 1)
            }

        updateCart(updatedItems)
    }

    fun removeProduct(productId: Int) {
        val currentItems = _state.value.items

        val updatedItems = currentItems - productId

        updateCart(updatedItems)
    }

    fun clearCart() {
        viewModelScope.launch {
            _state.update {
                CartState()
            }

            try {
                cartRepository.clearCart()
            } catch (e: Exception) {
                _state.update { currentState ->
                    currentState.copy(
                        errorMessage = "Error while clearing the cart"
                    )
                }
            }
        }
    }

    private fun updateCart(updatedItems: Map<Int, Int>) {
        viewModelScope.launch {
            _state.update { currentState ->
                currentState.copy(
                    items = updatedItems,
                    errorMessage = null
                )
            }

            try {
                cartRepository.saveCartItems(updatedItems)
            } catch (e: Exception) {
                e.printStackTrace()

                _state.update { currentState ->
                    currentState.copy(
                        errorMessage = "Error while saving the cart"
                    )
                }
            }
        }
    }
}