package com.example.heart2heartnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.heart2heartnavigation.data.User
import com.example.heart2heartnavigation.ui.components.ProfileScreen
import com.example.heart2heartnavigation.ui.theme.components.BottomNavBar
import com.example.heart2heartnavigation.viewmodel.NavigationViewModel

//MainActivity sørger for at forbinde ViewModel med resten af appen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // 1. Vi opretter viewmodel-objektet
            val navVM = viewModel<NavigationViewModel>()
            val navController = rememberNavController()
            var currentScreen by remember { mutableStateOf("home-screen") }
            val userData = User()

            Column(modifier = Modifier.fillMaxSize()) {
                Text(
                    text = "Heart2Heart",
                    fontSize = 45.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 60.dp)
                )

                /*Når du trykker på tilbage-knappen, går den igennem hvert stykke papir ét ad gangen.
                Så du skulle trykke tilbage mange gange for at komme ud af appen.
                launchSingleTop forhindrer kun dubletter hvis den skærm allerede ligger øverst.
                */

                // 2. Herinde skifter vi mellem de 4 skærme
                NavHost(
                    navController = navController,
                    startDestination = "home-screen",
                    modifier = Modifier.weight(1f) // Dette gør at NavHost fylder pladsen ud
                ) {
                    composable("home-screen") {
                        Text(
                            "Velkommen, ${userData.name}!",
                            fontSize = 24.sp
                        )
                    }
                    composable("Community") {
                        Text("Community her", fontSize = 24.sp) }
                    composable("Profile") {
                        ProfileScreen() }
                }

                // 3. Menuen kaldes
                BottomNavBar(
                    // Vi læser skærmen direkte fra navVM (vores ViewModel)
                    current = navVM.currentScreen,
                    onTabClick = { valgteRute ->
                        // RETTELSE: Vi kalder changeScreen (ikke currentScreen)
                        navVM.changeScreen(valgteRute)

                        navController.navigate(valgteRute) {
                            launchSingleTop = true
                        }
                    }
                )
            }
        }
    }
}

