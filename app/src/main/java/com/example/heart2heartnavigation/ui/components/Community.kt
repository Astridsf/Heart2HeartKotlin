package com.example.heart2heartnavigation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.heart2heartnavigation.R
import com.example.heart2heartnavigation.ui.theme.Purple80

@Composable
fun Posts() {
    Column  {
        Row {
            Image(painterResource(id = R.drawable.astridsf),
                contentDescription = "astrid",
                modifier = Modifier
                    .padding(start = 10.dp)
                    .clip(CircleShape)
                    .size(
                        40.dp
                    )
                    )
            Text(
                text = "Astrid Sofie Falkenberg",
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(start = 10.dp)
            )
        }
    Image(
        painter = painterResource(id = R.drawable.minas),
        contentDescription = "Billede af Minas kaffebar",
        modifier = Modifier
            .padding(10.dp)
    )
        Text(
            text = "Tryghedsscore",
            fontSize = 20.sp,
            modifier = Modifier
                .padding(start = 10.dp)
        )
    }
}