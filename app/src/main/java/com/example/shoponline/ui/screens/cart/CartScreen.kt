package com.example.shoponline.ui.screens.cart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.shoponline.ui.components.CustomTopBar

@Composable
fun CartScreen(

    navController: NavHostController
) {

    Scaffold(
        topBar = {
            CustomTopBar(
                title = "Carrello",
                cartIcon = null,
                backArrowIcon = Icons.AutoMirrored.Outlined.ArrowBack,
                onBackPress = {
                    navController.navigate("home")
                },
                onCartPress = {}
            )
        },
        bottomBar = {
            BottomAppBar {}
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //LazyColumn() {
            //    items(products) { product ->
            //        CartCard(product, navController)
            //    }
            //}
        }
    }

}