package com.example.heart2heartnavigation.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi // Vigtig for stickyHeader
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
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
import com.example.heart2heartnavigation.viewmodel.NavigationViewModel

@Composable
fun Header(
    modifier: Modifier = Modifier
) {
    Row(
    modifier = modifier
        .fillMaxWidth()
        .background(Color.White)
        .padding(vertical = 12.dp),
    horizontalArrangement = Arrangement.SpaceEvenly,
    verticalAlignment = Alignment.CenterVertically
) {
        Button(onClick = {},
            colors = ButtonDefaults.buttonColors
                (containerColor = Color.Gray)
        ) {
            Text("Heart-venner", fontSize = 12.sp)
        }
        Button(onClick = {}, colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)) {
            Text("Lokation", fontSize = 12.sp)
        }
        Button(onClick = {}, colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)) {
            Text("Sted/Type", fontSize = 12.sp)
        }
    }
}


@Composable
fun Posts(viewModel: NavigationViewModel) {

    val posts = viewModel.postList

    LazyColumn(
        modifier = Modifier.fillMaxSize()

    ) {
        stickyHeader {
            Header()
        }

        items(posts) { post ->
            PostCard(postData = post)
        }
    }
}

@Composable
fun PostCard(postData: PostData){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier
            .padding(12.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = postData.profilePictureRes),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp).clip(CircleShape)
                        .border(1.5.dp, Purple80, CircleShape),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(postData.userName, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                    Text(postData.location, fontSize = 11.sp, color = Color.Gray)
                }
            }
            Spacer(modifier = Modifier.height(10.dp))

            Image(
                painter = painterResource(id = postData.postImageRes),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth().height(200.dp).clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(10.dp))

            Row {
                Text("Tryghedsscore: ", fontWeight = FontWeight.Bold)
                Text(postData.safetyScore, color = Purple80, fontWeight = FontWeight.Bold)
            }
            Text(text = postData.description, fontSize = 14.sp, color = Color.DarkGray)
        }
    }
}








/*

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
        stickyHeader {
            Header(
                modifier = Modifier.background(Color.White)
            )
        }
        items(posts) { post ->
            Post(postData = post)
        }
    }
}

 */