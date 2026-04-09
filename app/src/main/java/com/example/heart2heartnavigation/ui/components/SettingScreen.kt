package com.example.heart2heartnavigation.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.heart2heartnavigation.viewmodel.NavigationViewModel

@Composable
fun LayoutSetting(text: String){
    Surface(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .padding(horizontal = 8.dp, vertical = 20.dp)
            .shadow(4.dp, RoundedCornerShape(15.dp)),
        shape = RoundedCornerShape(15.dp),
        color = Color.White
    ){
        Column(modifier = Modifier
            .padding(16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(8.dp) //Giver luft mellem navn og nummer
        ) {
            Text(text = text, fontSize = 25.sp, color = Color.Black)
        }
    }
}

@Composable
fun SettingScreen(
    viewModel: NavigationViewModel,
    onBackClick: () -> Unit
) {
    Box(modifier = Modifier.fillMaxWidth()) {

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Indstilinger",
                fontSize = 35.sp,
                color = pink,
                modifier = Modifier
                    .padding(top = 80.dp, bottom = 32.dp),
            )

            viewModel.settingList.forEach { settings ->
                LayoutSetting(
                    text = settings.text
                )
            }
        }
        IconButton(
            onClick = { onBackClick() },
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(top = 30.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Gå tilbage",
                tint = pink,
                modifier = Modifier
                    .size(36.dp)
            )
        }
    }
}








