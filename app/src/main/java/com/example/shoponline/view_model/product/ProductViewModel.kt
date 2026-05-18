package com.example.shoponline.view_model.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoponline.model.product.Product
import com.example.shoponline.repository.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductViewModel(
    private val repository: ProductRepository
) : ViewModel() {
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    private val _selectedProduct = MutableStateFlow<Product?>(null)
    val selectedProduct: StateFlow<Product?> = _selectedProduct

    init {
        fetchProducts()
    }

    private fun fetchProducts() {
        viewModelScope.launch {
            try {
                val response = repository.getProducts()
                _products.value = response
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun fetchProductById(productId: Int) {
        viewModelScope.launch {
            _selectedProduct.value = null

            try {
                val response = repository.getProductById(productId)
                _selectedProduct.value = response
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}