package com.example.heart2heartnavigation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.heart2heartnavigation.R
import com.example.heart2heartnavigation.data.PostData
import com.example.heart2heartnavigation.ui.theme.Purple80
import com.google.accompanist.pager.rememberPagerState
@Composable
fun Header(
    button1Text: String = "Button 1",
    button2Text: String = "Button 2",
    button3Text: String = "Button 3",
    onButton1Click: () -> Unit = {},
    onButton2Click: () -> Unit = {},
    onButton3Click: () -> Unit = {},
    modifier: Modifier = Modifier
) { Column() {
    Image(
        painter = painterResource(id = R.drawable.heart2heart),
        contentDescription = "H2H logo",
        modifier = Modifier
            .wrapContentSize(Alignment.Center)
    )

    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
            .padding(10.dp)
    ) {

        Button(
            onClick = onButton1Click,
            modifier = Modifier
                .padding(end = 7.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
        ) {
            Text(
                text = button1Text,
                fontSize = 13.sp
            )
        }

        Button(
            onClick = onButton2Click,
            modifier = Modifier
                .padding(horizontal = 7.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
        ) {
            Text(
                text = button2Text,
                fontSize = 13.sp
            )
        }

        Button(
            onClick = onButton3Click,
            modifier = Modifier
                .padding(start = 7.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
        ) {
            Text(
                text = button3Text,
                fontSize = 13.sp
            )
        }
    }
}
}


@Composable
fun Post(postData: PostData) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            // User info row
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 8.dp)
            ) {
                Image(
                    painter = painterResource(id = postData.profilePictureRes),
                    contentDescription = postData.userName,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(40.dp)
                        .border(1.3.dp, Purple80, CircleShape)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column() { Text(
                    text = postData.userName,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                    Text(
                        text = postData.location,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
            }

            // Post image
            Image(
                painter = painterResource(id = postData.postImageRes),
                contentDescription = "Post image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Safety score row
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 4.dp)
            ) { Text(
                text = "Tryghedsscore: ",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
                Text(
                    text = postData.safetyScore,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Purple80
                )
            }

            // Description
            Text(
                text = postData.description,
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}
@Composable
fun Posts() {
    val posts = listOf(
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
    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(posts) { post ->
            Post(postData = post)
        }
    }
}