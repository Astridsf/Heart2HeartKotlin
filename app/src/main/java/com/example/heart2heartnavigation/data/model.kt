package com.example.heart2heartnavigation.data

import com.example.heart2heartnavigation.R

//her gemmmer vi de faste informationer

//profilside
data class UserProfil(
    val name: String = "Anna Solbjerg Jensen"
)

//kontaktside
val userProfil = UserProfil()

data class Contacts(
    val name: String,
    val phoneNumber: String
)

//profilside i bunden
data class ReviewItem(
    val imageRes: Int? = null, // Kan være null hvis det kun er tekst
    val reviewText: String? = null // Kan være null hvis det kun er et billede
)

//ViewModel må ikke kende til R.drawable direkte, derfor har jeg smidt det ind i model.kt
val annaReviewList = listOf(
    ReviewItem(imageRes = R.drawable.barforsjov1),
    ReviewItem(imageRes = R.drawable.barforsjov2),
    ReviewItem(reviewText = "“Jeg havde en skøn aften på Bar Sjov med veninderne, bare tag til stand-up”")
)

//indstillinger
data class Settings(
    val text: String
)