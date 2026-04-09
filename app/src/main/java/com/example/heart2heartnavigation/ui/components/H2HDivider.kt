package com.example.heart2heartnavigation.ui.components

import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun H2HDivider(modifier: Modifier = Modifier) {
    Divider(
        modifier = modifier.requiredWidth(343.dp),
        color = Color(0xFF7E7E7E)
    )
}