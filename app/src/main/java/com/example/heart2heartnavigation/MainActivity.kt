package com.example.heart2heartnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width

import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Map
import androidx.compose.material.icons.outlined.Public
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.text.style.TextAlign

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {




            val navController = rememberNavController()
            var currentScreen by remember { mutableStateOf("home-screen") }

            Column(modifier = Modifier.fillMaxSize()){
                Text(
                    text = "Heart2Heart",
                    fontSize = 45.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 60.dp)
                )

                NavHost(
                    navController = navController,
                    startDestination = "home-screen",
                    Modifier.weight(1f)
                ){
                    composable("home-screen") {
                        HomeScreen(
                            "benjamin",
                            currentScreen = currentScreen,
                            onScreen1ButtonClick = {
                                //currentScreen = "home-screen"
                                navController.navigate("home-screen")//{launchSingleTop = true}

                            },
                            onScreen2ButtonClick = {
                                //currentScreen = "2"
                                navController.navigate("screen-2")

                            },
                            onScreen3ButtonClick = {
                                currentScreen = "3"
                                navController.navigate("screen-3")

                            },
                            onScreen4ButtonClick = {
                                currentScreen = "4"
                                navController.navigate("screen-4")

                            }
                        )
                    }
                    composable("screen-2") {
                        Screen2(
                            "screen 2",
                            currentScreen = currentScreen,
                            onScreen1ButtonClick = {
                                currentScreen = "home-screen"
                                navController.navigate("home-screen") {launchSingleTop = true}

                            },
                            onScreen2ButtonClick = {
                                currentScreen = "2"
                                navController.navigate("screen-2") {launchSingleTop = true}

                            },
                            onScreen3ButtonClick = {
                                currentScreen = "3"
                                navController.navigate("screen-3")

                            },
                            onScreen4ButtonClick = {
                                currentScreen = "4"
                                navController.navigate("screen-4")

                            }
                        )
                    }
                    composable("screen-3") {
                        Screen3(
                            "benjamin",
                            currentScreen = currentScreen,
                            onScreen1ButtonClick = {
                                currentScreen = "home-screen"
                                navController.navigate("home-screen") {launchSingleTop = true}

                            },
                            onScreen2ButtonClick = {
                                currentScreen = "2"
                                navController.navigate("screen-2")

                            },
                            onScreen3ButtonClick = {
                                currentScreen = "3"
                                navController.navigate("screen-3") {launchSingleTop = true}

                            },
                            onScreen4ButtonClick = {
                                currentScreen = "4"
                                navController.navigate("screen-4")

                            }
                        )
                    }
                    composable("screen-4") {
                        Screen4(
                            "benjamin",
                            currentScreen = currentScreen,
                            onScreen1ButtonClick = {
                                currentScreen = "home-screen"
                                navController.navigate("home-screen") {launchSingleTop = true}

                            },
                            onScreen2ButtonClick = {
                                currentScreen = "2"
                                navController.navigate("screen-2")

                            },
                            onScreen3ButtonClick = {
                                currentScreen = "3"
                                navController.navigate("screen-3")

                            },
                            onScreen4ButtonClick = {
                                currentScreen = "4"
                                navController.navigate("screen-4") {launchSingleTop = true}

                            }
                        )
                    }

                }


            }


        }
    }
}



@Composable
fun HomeScreen(
    name: String,
    currentScreen: String,
    onScreen2ButtonClick: () -> Unit,
    onScreen3ButtonClick: () -> Unit,
    onScreen4ButtonClick: () -> Unit,
    onScreen1ButtonClick: () -> Unit
) {
    Column (modifier = Modifier
        .fillMaxSize())
    {
        Column(modifier = Modifier
            .weight(1f)){
        Text(
            text = "Screen 1",
            fontSize = 32.sp
        )
        Text(
            text = "Hello $name!"
        )

        }
        Row (modifier = Modifier
            .padding(bottom = 16.dp)
            .background(Color.Red)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom)

        {

                val pink = Color(0xFFE91E8C)
                val grey = Color(0xFF9E9E9E)

                IconButton(onClick = onScreen1ButtonClick) {
                    Icon(
                        imageVector = Icons.Outlined.Favorite,
                        contentDescription = "Home",
                        tint = if (currentScreen == "home-screen") pink else grey,
                        modifier = Modifier.size(24.dp)
                    )
                }

                IconButton(onClick = onScreen2ButtonClick) {
                    Icon(
                        imageVector = Icons.Outlined.Map,
                        contentDescription = "Map",
                        tint = if (currentScreen == "2") pink else grey,
                        modifier = Modifier.size(24.dp)
                    )
                }

                IconButton(onClick = onScreen3ButtonClick) {
                    Icon(
                        imageVector = Icons.Outlined.Public,
                        contentDescription = "Community",
                        tint = if (currentScreen == "3") pink else grey,
                        modifier = Modifier.size(24.dp)
                    )
                }

                IconButton(onClick = onScreen4ButtonClick) {
                    Icon(
                        imageVector = Icons.Outlined.Person,
                        contentDescription = "Profil",
                        tint = if (currentScreen == "4") pink else grey,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }


@Composable
fun Screen2( name: String,
             currentScreen: String,
             onScreen2ButtonClick: () -> Unit,
             onScreen3ButtonClick: () -> Unit,
             onScreen4ButtonClick: () -> Unit,
             onScreen1ButtonClick: () -> Unit
) {
    Column (modifier = Modifier
        .fillMaxSize())
    {
        Column(modifier = Modifier
            .weight(1f)){
            Text(
                text = "Screen 2",
                fontSize = 32.sp
            )
            Text(
                text = "Hello $name!"
            )
        }
        Row (modifier = Modifier
            .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom)
        {

            val pink = Color(0xFFE91E8C)
            val grey = Color(0xFF9E9E9E)

            IconButton(onClick = onScreen1ButtonClick) {
                Icon(
                    imageVector = Icons.Outlined.Favorite,
                    contentDescription = "Home",
                    tint = if (currentScreen == "home-screen") pink else grey,
                    modifier = Modifier.size(24.dp)
                )
            }

            IconButton(onClick = onScreen2ButtonClick) {
                Icon(
                    imageVector = Icons.Outlined.Map,
                    contentDescription = "Map",
                    tint = if (currentScreen == "2") pink else grey,
                    modifier = Modifier.size(24.dp)
                )
            }

            IconButton(onClick = onScreen3ButtonClick) {
                Icon(
                    imageVector = Icons.Outlined.Public,
                    contentDescription = "Community",
                    tint = if (currentScreen == "3") pink else grey,
                    modifier = Modifier.size(24.dp)
                )
            }

            IconButton(onClick = onScreen4ButtonClick) {
                Icon(
                    imageVector = Icons.Outlined.Person,
                    contentDescription = "Profil",
                    tint = if (currentScreen == "4") pink else grey,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}


@Composable
fun Screen3( name: String,
             currentScreen: String,
             onScreen2ButtonClick: () -> Unit,
             onScreen3ButtonClick: () -> Unit,
             onScreen4ButtonClick: () -> Unit,
             onScreen1ButtonClick: () -> Unit
) {
    Column (modifier = Modifier
        .fillMaxSize())
    {
        Column(modifier = Modifier
            .weight(1f)){
            Text(
                text = "Screen 3",
                fontSize = 32.sp
            )
            Text(
                text = "Hello $name!"
            )
        }
        Row (modifier = Modifier
            .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom)
        {

            val pink = Color(0xFFE91E8C)
            val grey = Color(0xFF9E9E9E)

            IconButton(onClick = onScreen1ButtonClick) {
                Icon(
                    imageVector = Icons.Outlined.Favorite,
                    contentDescription = "Home",
                    tint = if (currentScreen == "home-screen") pink else grey,
                    modifier = Modifier.size(24.dp)
                )
            }

            IconButton(onClick = onScreen2ButtonClick) {
                Icon(
                    imageVector = Icons.Outlined.Map,
                    contentDescription = "Map",
                    tint = if (currentScreen == "2") pink else grey,
                    modifier = Modifier.size(24.dp)
                )
            }

            IconButton(onClick = onScreen3ButtonClick) {
                Icon(
                    imageVector = Icons.Outlined.Public,
                    contentDescription = "Community",
                    tint = if (currentScreen == "3") pink else grey,
                    modifier = Modifier.size(24.dp)
                )
            }

            IconButton(onClick = onScreen4ButtonClick) {
                Icon(
                    imageVector = Icons.Outlined.Person,
                    contentDescription = "Profil",
                    tint = if (currentScreen == "4") pink else grey,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}


@Composable
fun Screen4( name: String,
             currentScreen: String,
             onScreen2ButtonClick: () -> Unit,
             onScreen3ButtonClick: () -> Unit,
             onScreen4ButtonClick: () -> Unit,
             onScreen1ButtonClick: () -> Unit
) {
    Column (modifier = Modifier
        .fillMaxSize())
    {
        Column(modifier = Modifier
            .weight(1f)){
            Text(
                text = "Screen 4",
                fontSize = 32.sp
            )
            Text(
                text = "Hello $name!"
            )
        }
        Row (modifier = Modifier
            .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom)
        {
            val pink = Color(0xFFE91E8C)
            val grey = Color(0xFF9E9E9E)

            IconButton(onClick = onScreen1ButtonClick) {
                Icon(
                    imageVector = Icons.Outlined.Favorite,
                    contentDescription = "Home",
                    tint = if (currentScreen == "home-screen") pink else grey,
                    modifier = Modifier.size(24.dp)
                )
            }

            IconButton(onClick = onScreen2ButtonClick) {
                Icon(
                    imageVector = Icons.Outlined.Map,
                    contentDescription = "Map",
                    tint = if (currentScreen == "2") pink else grey,
                    modifier = Modifier.size(24.dp)
                )
            }

            IconButton(onClick = onScreen3ButtonClick) {
                Icon(
                    imageVector = Icons.Outlined.Public,
                    contentDescription = "Community",
                    tint = if (currentScreen == "3") pink else grey,
                    modifier = Modifier.size(24.dp)
                )
            }

            IconButton(onClick = onScreen4ButtonClick) {
                Icon(
                    imageVector = Icons.Outlined.Person,
                    contentDescription = "Profil",
                    tint = if (currentScreen == "4") pink else grey,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}