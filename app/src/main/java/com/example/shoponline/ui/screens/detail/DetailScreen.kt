package com.example.shoponline.ui.screens.detail

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.shoponline.R
import com.example.shoponline.repository.ProductRepository
import com.example.shoponline.ui.components.CustomTopBar
import com.example.shoponline.ui.components.ProductList
import com.example.shoponline.view_model.product.ProductViewModel


@SuppressLint("ViewModelConstructorInComposable")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavHostController) {

    Scaffold(
        topBar = {
            CustomTopBar(
                title = stringResource(R.string.home_page_name),
                cartIcon = Icons.Outlined.ShoppingCart,
                backArrowIcon = Icons.AutoMirrored.Outlined.ArrowBack,
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

            Text(text = "DETAILSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS")

        }
    }
}