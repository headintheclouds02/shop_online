package com.example.shoponline.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.shoponline.ui.components.CustomTopBar
import com.example.shoponline.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeActivity() {

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

            Text(
                text = "Benvenuto nella Home!",
                style = MaterialTheme.typography.headlineMedium
            )

        }
    }
}