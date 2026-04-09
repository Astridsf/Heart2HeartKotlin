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
                    .width(291.dp)
                    .height(74.dp)
                    .padding(bottom = 33.dp)
                    .offset(y = (-30).dp)



            )
            Spacer(modifier = Modifier.height(1.dp))

            Image(
                painter = painterResource(id = R.drawable.heart),
                contentDescription = "Heart logo",
                modifier = Modifier
                    .size(206.dp)
                    .width(206.dp)
                    .height(206.dp)
                    .offset(y = (-150).dp)


            )
            Spacer(modifier = Modifier

                .offset(y = (-20).dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Bluetooth,
                        contentDescription = "Bluetooth",
                        tint = pink,
                        modifier = Modifier.size(22.dp)
                            .offset(y = (-140).dp)

                    )

                    Text(

                        text = "Connected",
                        fontSize = 14.sp,
                        modifier = Modifier
                            .offset(y = (-140).dp)
                    )

                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(0.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Battery6Bar,
                        contentDescription = "Battery",
                        tint = pink,
                        modifier = Modifier.size(22.dp)
                            .offset(y = (-140).dp)
                    )

                    Text(
                        text = "64%",
                        fontSize = 14.sp,
                        modifier = Modifier
                            .offset(y = (-140).dp)
                    )
                }
            }

            H2HButton(
                text = "Disconnect",
                onClick = goDetails,
                modifier = Modifier.padding(bottom = 57.dp)
            )

            H2HDivider(
                modifier = Modifier.padding(bottom = 53.dp, start = 35.dp, end = 35.dp)
            )

            H2HButton(
                text = "Activate Level 1",
                onClick = goProfile
            )
            Spacer(modifier = Modifier.height(12.dp))

            H2HButton(
                text = "Activate Level 2",
                onClick = goProfile
            )
        }
    }
}