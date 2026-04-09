package com.example.heart2heartnavigation.ui.components

import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em

@Composable
fun H2HButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(100.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFE91E8C)   // ← DIN FARVE
        ),
        modifier = modifier
            .requiredWidth(152.dp)
            .requiredHeight(40.dp)
    ) {
        Text(
            text = text,
            color = Color.White,                // ← HVID TEKST
            textAlign = TextAlign.Center,
            lineHeight = 1.25.em
        )
    }
}
