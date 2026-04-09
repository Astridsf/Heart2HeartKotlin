package com.example.heart2heartnavigation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.heart2heartnavigation.R
import com.example.heart2heartnavigation.data.ReviewItem
import com.example.heart2heartnavigation.data.UserProfil

val pink = Color(0xFFFF77B7)

@Composable
fun ButtonLayout(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth(0.6f)
            .padding(horizontal = 8.dp, vertical = 20.dp)
            .height(70.dp)
            .shadow(4.dp, RoundedCornerShape(20.dp)),
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color.Black
        )
    ) {
        Text(text = text, fontSize = 20.sp)
    }
}

@Composable
fun ProfileImage() {
    Image(
        painter = painterResource(id = R.drawable.profilbillede),
        contentDescription = null,
        modifier = Modifier
            .padding(top = 60.dp)
            .size(200.dp)
            .clip(CircleShape)
            .border(3.dp, pink, CircleShape)
    )
}


@Composable
fun ReviewCard(imageRes: Int, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = imageRes),
        contentDescription = null,
        modifier = modifier
            .size(150.dp)
            .clip(RoundedCornerShape(8.dp)), // Bløde hjørner,
        contentScale = androidx.compose.ui.layout.ContentScale.Crop
    )
}

@Composable
fun ProfileScreen(
    profile: UserProfil,
    darkMode: Boolean,
    onChangeDarkMode: () -> Unit,
    onContactClick: () -> Unit,
    onSettingClick: () -> Unit,
    reviewList: List<ReviewItem>
) {

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            ProfileImage()

            Text(
                text = profile.name,
                fontSize = 24.sp,
                color = pink,
                modifier = Modifier
                    .padding(top = 40.dp, bottom = 24.dp)
            )

            ButtonLayout(text = "Kontakter", onClick = onContactClick)
            ButtonLayout(text = "Indstillinger", onClick = onSettingClick)

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, bottom = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                // Venstre streg
                HorizontalDivider(
                    modifier = Modifier
                        .weight(2f)
                        .padding(start = 20.dp),
                    thickness = 1.dp,
                    color = pink
                )

                Text(
                    text = "Mine Reviews",
                    fontSize = 24.sp,
                    color = pink,
                    modifier = Modifier
                        .padding(22.dp)
                )

                // Højre streg
                HorizontalDivider(
                    modifier = Modifier
                        .weight(2f)
                        .padding(end = 20.dp),
                    thickness = 1.dp,
                    color = pink
                )
            }

            Button(
                onClick = { /* Gør noget */ },
                colors = ButtonDefaults.buttonColors(containerColor = pink),
                modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .padding(bottom = 40.dp)

            ) {
                Text("Opret Review", color = Color.White)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Annas vilde bytur",
                    color = pink,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                    fontSize = 18.sp
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = "Tryghedsscore",
                        color = pink,
                        fontSize = 14.sp
                    )
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = null,
                        tint = pink,
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .size(16.dp)
                    )
                    Text(
                        text = "4.3",
                        color = pink,
                        fontSize = 14.sp
                    )
                }
            }
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)

            ) {

                items(reviewList) { item ->
                    // Hvis elementet har et billede — vis billedet
                    if (item.imageRes != null) {
                        ReviewCard(imageRes = item.imageRes)

                    } else if (item.reviewText != null) {
                        Text(
                            text = item.reviewText,
                            color = pink,
                            fontSize = 14.sp,
                            modifier = Modifier
                                .size(150.dp)
                                .border(1.dp, pink, RoundedCornerShape(12.dp))
                        )
                    }
                }
            }
        }

            // Sol/måne ikon øverst til højre
            IconButton(
                onClick = { onChangeDarkMode() },
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 30.dp)
            ) {
                Icon(
                    imageVector = if (darkMode) Icons.Default.DarkMode else Icons.Default.LightMode,
                    contentDescription = "Skift tema",
                    tint = pink,
                    modifier = Modifier
                        .size(30.dp)
                )
            }
        }
    }



