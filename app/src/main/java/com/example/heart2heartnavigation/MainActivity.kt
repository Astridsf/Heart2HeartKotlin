package com.example.heart2heartnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.heart2heartnavigation.ui.components.BottomNavBar
import com.example.heart2heartnavigation.ui.components.ContactScreen
import com.example.heart2heartnavigation.ui.components.Header
import com.example.heart2heartnavigation.ui.components.HomeScreen
import com.example.heart2heartnavigation.ui.components.Posts
import com.example.heart2heartnavigation.ui.components.ProfileScreen
import com.example.heart2heartnavigation.ui.components.SettingScreen
import com.example.heart2heartnavigation.ui.theme.Heart2HeartNavigationTheme
import com.example.heart2heartnavigation.viewmodel.NavigationViewModel

//MainActivity sørger for at forbinde ViewModel med resten af appen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // 1. Vi opretter viewmodel-objektet
            val navigationViewModel = viewModel<NavigationViewModel>()
            val navController = rememberNavController()
            var currentScreen by remember { mutableStateOf("home-screen") }

            Heart2HeartNavigationTheme(darkTheme = navigationViewModel.darkMode) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(if (navigationViewModel.darkMode) Color.Black else Color.White)

                ) {

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
                            HomeScreen(
                                goDetails = {
                                    navigationViewModel.changeScreen("details-screen")
                                    navController.navigate("details-screen") {
                                        launchSingleTop = true
                                    }
                                },
                                goMap = {
                                    navigationViewModel.changeScreen("screen-2")
                                    navController.navigate("screen-2") {
                                        launchSingleTop = true
                                    }
                                },
                                goCommunity = {
                                    navigationViewModel.changeScreen("screen-3")
                                    navController.navigate("screen-3") {
                                        launchSingleTop = true
                                    }
                                },
                                goProfile = {
                                    navigationViewModel.changeScreen("screen-4")
                                    navController.navigate("screen-4") {
                                        launchSingleTop = true
                                    }
                                }
                            )
                        }
                        composable("screen-3") {
                            Column(modifier = Modifier.fillMaxSize()) {
                                Posts(viewModel = navigationViewModel)
                            }
                        }
                        composable("screen-4") {
                            ProfileScreen(
                                profile = navigationViewModel.profil,
                                darkMode = navigationViewModel.darkMode,
                                onChangeDarkMode = { navigationViewModel.changeDarkMode() },
                                // Når man trykker Kontakter, navigerer vi til "kontakter-screen"
                                onContactClick = { navController.navigate("kontakter-screen") },
                                onSettingClick = { navController.navigate("Setting-screen") },
                                reviewList = navigationViewModel.reviewList

                            )
                        }
                        composable("kontakter-screen") {
                            ContactScreen(
                                viewModel = navigationViewModel,
                                onBackClick = { navController.popBackStack() }
                            )
                        }
                        composable("Setting-screen") {
                            SettingScreen(
                                viewModel = navigationViewModel,
                                onBackClick = { navController.popBackStack() }
                            )
                        }

                    }

                    // 3. Menuen kaldes
                    BottomNavBar(
                        // Vi læser skærmen direkte fra navVM (vores ViewModel)
                        current = navigationViewModel.currentScreen,
                        onTabClick = { valgteRute ->
                            // RETTELSE: Vi kalder changeScreen (ikke currentScreen)
                            navigationViewModel.changeScreen(valgteRute)

                            navController.navigate(valgteRute) {
                                launchSingleTop = true
                            }
                        }
                    )
                }
            }
        }
    }
}

