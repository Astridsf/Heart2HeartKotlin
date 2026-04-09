package com.example.heart2heartnavigation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.heart2heartnavigation.R

@Composable
fun HomeScreen(
    goDetails: () -> Unit,
    goMap: () -> Unit,
    goCommunity: () -> Unit,
    goProfile: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.heart2heart),
                contentDescription = "H2H logo",
                modifier = Modifier
                    .size(350.dp)
                    .offset(x = 25.dp, y = -80.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.heart),
                contentDescription = "Heart logo",
                modifier = Modifier
                    .size(200.dp)
                    .offset(x = 40.dp, y = -180.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))
            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = goDetails) {
                Text("Disconnect")
            }

            Spacer(modifier = Modifier.height(12.dp))

            Button(onClick = goProfile) {
                Text("Activate Level 1")
            }

            Spacer(modifier = Modifier.height(12.dp))

            Button(onClick = goProfile) {
                Text("Activate Level 2")
            }
        }
    }
}