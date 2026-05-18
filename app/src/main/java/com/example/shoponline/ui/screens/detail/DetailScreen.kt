package com.example.shoponline.ui.screens.detail

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.shoponline.R
import com.example.shoponline.ui.components.CustomTopBar
import com.example.shoponline.view_model.product.ProductViewModel


@SuppressLint("ViewModelConstructorInComposable")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class)
@Composable
fun DetailScreen(
    navController: NavHostController,
    productId: Int,
    viewModel: ProductViewModel
) {
    val selectedProduct by viewModel.selectedProduct.collectAsState()

    LaunchedEffect(productId) {
        viewModel.fetchProductById(productId)
    }

    Scaffold(
        topBar = {
            CustomTopBar(
                title = stringResource(R.string.home_page_name),
                cartIcon = Icons.Outlined.ShoppingCart,
                backArrowIcon = Icons.AutoMirrored.Outlined.ArrowBack,
                onBackPress = {
                    navController.popBackStack()
                }
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val product = selectedProduct
            GlideImage(
                model = product?.images?.firstOrNull(),
                contentDescription = stringResource(R.string.image_description),
                modifier = Modifier.size(220.dp)
            )
            Text(text = product?.title ?: "")
            Text(text = product?.description ?: "")
            Text(text = "Categoria: ${product?.category?.name}")
            Text(text = "€ ${product?.price}")

        }
    }
}