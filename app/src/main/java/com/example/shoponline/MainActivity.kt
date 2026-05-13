package com.example.shoponline

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.shoponline.ui.screens.home.HomeActivity
import com.example.shoponline.ui.theme.ShopOnlineTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShopOnlineTheme {
                HomeActivity()
            }
        }
    }
}