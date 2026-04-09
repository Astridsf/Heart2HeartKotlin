package com.example.heart2heartnavigation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.heart2heartnavigation.R
import com.example.heart2heartnavigation.data.Contacts
import com.example.heart2heartnavigation.data.PostData
import com.example.heart2heartnavigation.data.Settings
import com.example.heart2heartnavigation.data.userProfil
import com.example.heart2heartnavigation.data.annaReviewList



class NavigationViewModel: ViewModel() {
    // Vi husker, hvilken skærm vi er på. Vi starter på "home-screen"
    //vi bruger vi by mutableStateOf = betyder: "Hold øje med denne variabel, og opdater skærmen, hvis den ændrer sig."

    // Husker hvilken skærm vi er på
    var currentScreen by mutableStateOf("home-screen")
        private set

    // Husker brugerens profildata
    var profil by mutableStateOf(userProfil)
        private set

    var darkMode by mutableStateOf(false)
        private set

    val contactList = listOf(
        Contacts("Mor", "+45 12 34 56 78"),
        Contacts("Søster Selma", "+45 87 65 43 21"),
        Contacts("Lise", "+45 00 11 22 33"),
        Contacts("Frida", "+45 00 11 22 33")
    )

    val settingList = listOf(
        Settings("Skift profilbillede"),
        Settings("Skift Adgangskode")
    )

    val reviewList = annaReviewList

    // En simpel funktion til at skifte skærmen
    fun changeScreen(newScreen: String) {
        currentScreen = newScreen
    }

    fun changeDarkMode() {
        darkMode = !darkMode
    }

    //community opslagsliste
    val postList = listOf(
        PostData(
            userName = "Astrid Sofie Falkenberg",
            profilePictureRes = R.drawable.astridsf,
            location = "Nørrebro",
            postImageRes = R.drawable.minas,
            safetyScore = "4,7",
            description = "Det var en af de aftener, hvor København føltes som en varm, indbydende omfavnelse. Vi mødtes ved Minas Kaffebar, hvor duften af friskmalet kaffe og nybagte kanelsnegle straks satte stemningen. Vi snuppede et hjørnebord ved vinduet, hvor vi kunne se Nørrebrogades liv udfolde sig – cykler, der susede forbi, studerende med bøger under armen, og de evige diskussioner om, hvor man skulle tage hen efter kaffen."
        ),
        PostData(
            userName = "Frederikke",
            profilePictureRes = R.drawable.heart,
            location = "indsæt noget",
            postImageRes = R.drawable.vega,
            safetyScore = "4,9",
            description = "Another description..."
        ),
        PostData(
            userName = "Frederikke",
            profilePictureRes = R.drawable.heart,
            location = "indsæt noget",
            postImageRes = R.drawable.vega,
            safetyScore = "4,9",
            description = "Another description..."
        ),
        PostData(
            userName = "Frederikke",
            profilePictureRes = R.drawable.heart,
            location = "indsæt noget",
            postImageRes = R.drawable.vega,
            safetyScore = "4,9",
            description = "Another description..."
        ),
        PostData(
            userName = "Frederikke",
            profilePictureRes = R.drawable.heart,
            location = "indsæt noget",
            postImageRes = R.drawable.vega,
            safetyScore = "4,9",
            description = "Another description..."
        )
    )

}


