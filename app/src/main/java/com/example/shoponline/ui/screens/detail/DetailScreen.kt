package com.example.shoponline.ui.screens.detail

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.shoponline.R
import com.example.shoponline.ui.components.CustomTopBar
import com.example.shoponline.view_model.cart.CartViewModel
import com.example.shoponline.view_model.detail.DetailViewModel


@OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class)
@Composable
fun DetailScreen(
    viewModel: DetailViewModel = hiltViewModel(),
    cartViewModel: CartViewModel = hiltViewModel(),
    navController: NavHostController
) {

    val product by viewModel.product.collectAsState()
    val state by cartViewModel.state.collectAsState()

    val quantity = state.quantities[product?.id ?: 0] ?: 0

    Scaffold(
        topBar = {
            CustomTopBar(
                title = "Dettaglio Prodotto",
                cartIcon = null,
                backArrowIcon = Icons.AutoMirrored.Outlined.ArrowBack,
                onBackPress = {
                    navController.navigate("home")
                },
            )
        },
        bottomBar = {
            BottomAppBar {
                if (quantity == 0) {
                    Row(
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Button(

                            modifier = Modifier
                                .fillMaxWidth(),
                            onClick = {
                                cartViewModel.addItem(product?.id ?: 0)
                            }) {

                            Text(text = "Add to cart")
                            Icon(
                                painterResource(R.drawable.cart),
                                contentDescription = "Cart icon",
                            )

                        }
                    }
                } else {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .clip(RoundedCornerShape(32.dp))
                            .background(colorResource(R.color.light_blue))
                            .fillMaxWidth()

                    ) {
                        IconButton(onClick = {
                            cartViewModel.removeItem(product?.id ?: 0)
                        }) {
                            Icon(
                                painterResource(R.drawable.minus),
                                contentDescription = "Minus",
                            )
                        }

                        Text(
                            text = quantity.toString(),
                            fontSize = 24.sp
                            )

                        IconButton(onClick = {
                            cartViewModel.addItem(product?.id ?: 0)
                        }) {
                            Icon(
                                painterResource(R.drawable.add),
                                contentDescription = "Add",
                            )
                        }

                    }
                }
            }
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
            GlideImage(
                model = product?.images[0],
                contentDescription = stringResource(R.string.image_description),
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                        .clip(RoundedCornerShape(24.dp))
            )
            Text(text = product?.title ?: "")
            Text(text = "€${product?.price.toString()}")
            Text(text = product?.description ?: "")
        }
    }
}