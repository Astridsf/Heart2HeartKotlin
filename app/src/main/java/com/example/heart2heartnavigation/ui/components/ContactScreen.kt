package com.example.heart2heartnavigation.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import com.example.heart2heartnavigation.viewmodel.NavigationViewModel
import androidx.compose.foundation.lazy.items



@Composable
fun LayoutContact(name: String, phoneNumber: String){
    Surface(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .padding(horizontal = 8.dp, vertical = 20.dp)
            .shadow(4.dp, RoundedCornerShape(15.dp))
        ,
        shape = RoundedCornerShape(15.dp),
        color = Color.White
    ){
        Column(modifier = Modifier
            .padding(16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(8.dp) //Giver luft mellem navn og nummer
            ) {
            Text(text = name, fontSize = 25.sp, color = Color.Black)
            Text(text = phoneNumber, fontSize = 23.sp, color = Color.Black)
        }
    }
}

@Composable
fun AddButton(){
    Button(onClick = {},
        modifier = Modifier
            .size(70.dp)
            .padding(top=7.dp),
        colors = ButtonDefaults.buttonColors(containerColor = pink),
        contentPadding = PaddingValues(0.dp)

        ){
        Icon(
            imageVector = Icons.Default.Add, // Det tynde plus
            contentDescription = null,
            modifier = Modifier.size(200.dp), // Her styrer du selve plussets størrelse
            tint = Color.White
        )
    }
}

@Composable
fun ContactScreen(
    viewModel: NavigationViewModel, //// Tilføjer viewModel her
    onBackClick: () -> Unit  // modtager tilbage-funktionen
) {
    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(9.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Kontakter",
                fontSize = 35.sp,
                color = pink,
                modifier = Modifier
                    .padding(top = 80.dp, bottom = 32.dp),
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                contentPadding = PaddingValues(bottom = 40.dp) // Giver luft i bunden af listen
            ) {
                items(viewModel.contactList) { contacts ->
                    LayoutContact(
                        name = contacts.name,
                        phoneNumber = contacts.phoneNumber
                    )
                }
                item {
                    AddButton()
                }
            }
        }
        IconButton(onClick = { onBackClick() },
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(top = 30.dp)) {
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







