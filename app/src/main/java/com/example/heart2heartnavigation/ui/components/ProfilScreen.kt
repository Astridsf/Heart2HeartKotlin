package com.example.heart2heartnavigation.ui.components

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.example.heart2heartnavigation.data.Profile
import com.example.heart2heartnavigation.data.User

val profileData = Profile()
@Composable
fun ProfileScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Velkommen ${profileData.name}!"
        )
    }
}