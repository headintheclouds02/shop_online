package com.example.shoponline.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.shoponline.R

@Composable
fun PillCounter(
    onMinusClick: () -> Unit,
    onPlusClick: () -> Unit

) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.border(
            width = 0.5.dp,
            color = Color.LightGray,
            shape = RoundedCornerShape(50)
        )
    )  {
        IconButton(onClick = onMinusClick) {
            Icon(
                painter = painterResource(R.drawable.minus),
                contentDescription = "minus",
                modifier = Modifier
                    .size(14.dp)
            )
        }
        Text(text = "Prova")
        IconButton(onClick = onPlusClick) {
            Icon(
                painter = painterResource(R.drawable.add),
                contentDescription = "plus",
                modifier = Modifier
                    .size(14.dp)
            )
        }
    }
}