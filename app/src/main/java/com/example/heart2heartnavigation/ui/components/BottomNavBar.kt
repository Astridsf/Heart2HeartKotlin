package com.example.heart2heartnavigation.ui.theme.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Map
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Public
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

//her lægger vi navigation-menuen

@Composable
fun BottomNavBar(current: String, onTabClick: (String) -> Unit) {
    val pink = Color(0xFFE91E8C)
    val grey = Color(0xFF9E9E9E)

    Row(
        modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        // 1. HOME (Hjerte)
        IconButton(onClick = { onTabClick("home-screen") }) {
            Icon(
                imageVector = Icons.Outlined.Favorite,
                contentDescription = "Home",
                tint = if (current == "home-screen") pink else grey,
                modifier = Modifier.size(36.dp)
            )
        }

        // 3. COMMUNITY (Globus)
        IconButton(onClick = { onTabClick("screen-3") }) {
            Icon(
                imageVector = Icons.Outlined.Public,
                contentDescription = "Community",
                tint = if (current == "screen-3") pink else grey,
                modifier = Modifier.size(36.dp)
            )
        }

        // 4. PROFILE (Person)
        IconButton(onClick = { onTabClick("screen-4") }) {
            Icon(
                imageVector = Icons.Outlined.Person,
                contentDescription = "Profile",
                tint = if (current == "screen-4") pink else grey,
                modifier = Modifier.size(36.dp)
            )
        }
    }
}


