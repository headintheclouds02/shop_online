package com.example.shoponline.view_model.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoponline.model.product.Product
import com.example.shoponline.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: ProductRepository
) : ViewModel() {

    val productId =
        savedStateHandle.get<String>("productId")?.toIntOrNull()

    private val _product =
        MutableStateFlow<Product?>(null)

    val product: StateFlow<Product?> = _product

    init {

        if (productId != null) {

            loadProduct(productId)
        }
    }

    private fun loadProduct(productId: Int) {

        viewModelScope.launch {

            try {

                val products = repository.getProducts()

                _product.value =
                    products.find { it.id == productId }

            } catch (e: Exception) {

                e.printStackTrace()
            }
        }
    }
}