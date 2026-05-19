package com.example.shoponline.ui.screens.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.shoponline.R
import com.example.shoponline.model.CartItem
import com.example.shoponline.ui.components.CartCard
import com.example.shoponline.ui.components.CustomTopBar
import com.example.shoponline.view_model.cart.CartViewModel
import com.example.shoponline.view_model.home.HomeViewModel

@Composable
fun CartScreen(
    navController: NavHostController,
    cartViewModel: CartViewModel = hiltViewModel(),
    homeViewModel: HomeViewModel = hiltViewModel(),
) {

    val allProducts by homeViewModel.products.collectAsState()
    val cartState by cartViewModel.state.collectAsState()

    val cartItems = allProducts.mapNotNull { product ->

        val quantity = cartState.items[product.id]

        if (quantity != null) {
            CartItem(product, quantity)
        } else {
            null
        }
    }

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
            BottomAppBar {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(

                        modifier = Modifier
                            .fillMaxWidth(),
                        onClick = {
                            cartViewModel.clearCart()
                        }) {

                        Text(text = "Clear cart")
                        Icon(
                            painterResource(R.drawable.cart),
                            contentDescription = "Cart icon",
                        )

                    }
                }
            }
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn {
                items(cartItems) { item ->
                    CartCard(
                        product = item.product,
                        quantity = item.quantity,
                        navController = navController,
                        onBinClick = { cartViewModel.removeProduct(item.product.id) },
                        onMinusClick = { cartViewModel.removeItem(item.product.id)},
                        onPlusClick = {cartViewModel.addItem(item.product.id)}
                    )
                }
            }
        }
    }

}