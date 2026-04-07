package com.example.heart2heartnavigation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class NavigationViewModel: ViewModel(){
    // Vi husker, hvilken skærm vi er på. Vi starter på "home-screen"
    //vi bruger vi by mutableStateOf = betyder: "Hold øje med denne variabel, og opdater skærmen, hvis den ændrer sig."
    var currentScreen by mutableStateOf("home-screen")

    // En simpel funktion til at skifte skærmen
    fun changeScreen(newScreen: String) {
        currentScreen = newScreen
    }
    }

