package com.example.shoponline.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.shoponline.R
import com.example.shoponline.ui.components.CustomTopBar
import com.example.shoponline.ui.components.ProductList
import com.example.shoponline.view_model.product.ProductViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: ProductViewModel,
    onProductClick: (Int) -> Unit
) {

    Scaffold(
        topBar = {
            CustomTopBar(
                title = stringResource(R.string.home_page_name),
                cartIcon = Icons.Outlined.ShoppingCart,
                backArrowIcon = null,
                onBackPress = {}
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            ProductList(
                viewModel = viewModel,
                onProductClick = onProductClick
            )

        }
    }
}