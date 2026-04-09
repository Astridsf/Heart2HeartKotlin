package com.example.heart2heartnavigation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Battery6Bar
import androidx.compose.material.icons.outlined.Bluetooth
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.heart2heartnavigation.R
import com.example.heart2heartnavigation.ui.components.H2HButton
import com.example.heart2heartnavigation.ui.components.H2HDivider

@Composable
fun HomeScreen(
    darkMode: Boolean,
    goDetails: () -> Unit,
    goMap: () -> Unit,
    goCommunity: () -> Unit,
    goProfile: () -> Unit
) {
    val backgroundColor = if (darkMode) Color.Black else Color.White
    val textColor = if (darkMode) Color.White else Color.Black

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .verticalScroll(rememberScrollState())
            .padding(top = 40.dp, bottom = 20.dp), // Lidt luft i top og bund
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 1. Logo i toppen
        Image(
            painter = painterResource(id = R.drawable.heart2heart),
            contentDescription = "H2H logo",
            modifier = Modifier
                .width(280.dp)
                .padding(vertical = 20.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        // 2. Det store hjerte
        Image(
            painter = painterResource(id = R.drawable.heart),
            contentDescription = "Heart logo",
            modifier = Modifier.size(220.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 3. Status række (Bluetooth & Batteri)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            // Bluetooth del
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Outlined.Bluetooth,
                    contentDescription = "Bluetooth",
                    tint = pink,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Connected",
                    fontSize = 14.sp,
                    color = textColor.copy(alpha = 0.7f) // Lidt dæmpet tekst som på billedet
                )
            }

            // Batteri del
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Outlined.Battery6Bar,
                    contentDescription = "Battery",
                    tint = pink,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "64%",
                    fontSize = 14.sp,
                    color = textColor.copy(alpha = 0.7f)
                )
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        // 4. Disconnect knap
        H2HButton(
            text = "Disconnect",
            onClick = goDetails
        )

        Spacer(modifier = Modifier.height(40.dp))

        // 5. Skillelinje
        H2HDivider(
            modifier = Modifier.padding(horizontal = 40.dp)
        )

        Spacer(modifier = Modifier.height(40.dp))

        // 6. Level knapper
        H2HButton(
            text = "Activate Level 1",
            onClick = goProfile
        )

        Spacer(modifier = Modifier.height(20.dp))

        H2HButton(
            text = "Activate Level 2",
            onClick = goProfile
        )
    }
}