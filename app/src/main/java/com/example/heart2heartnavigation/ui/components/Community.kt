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
    modifier: Modifier = Modifier,
    darkMode: Boolean
) {
    val backgroundColor = if (darkMode) Color.Black else Color.White

    Column(
        modifier = Modifier
            .background(backgroundColor)
            .padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Community",
            fontSize = 35.sp,
            color = pink,
            modifier = Modifier
                .padding(top = 40.dp, bottom = 10.dp),
        )

    Row(
    modifier = modifier
        .fillMaxWidth()
        .background(backgroundColor)
        .padding(top = 16.dp, bottom = 12.dp),
    horizontalArrangement = Arrangement.SpaceEvenly,
    verticalAlignment = Alignment.CenterVertically
) {
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors
                (containerColor = pink)
        ) {
            Text("Heart-venner", fontSize = 12.sp)
        }
        Button(onClick = {}, colors = ButtonDefaults.buttonColors(containerColor = pink)) {
            Text("Lokation", fontSize = 12.sp)
        }
        Button(onClick = {}, colors = ButtonDefaults.buttonColors(containerColor = pink)) {
            Text("Sted/Type", fontSize = 12.sp)
        }
    }
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth(),
            thickness = 1.dp,
            color = pink
        )
    }
}


@Composable
fun Posts(
    viewModel: NavigationViewModel,
    darkMode: Boolean
) {

    val posts = viewModel.postList
    val darkMode = viewModel.darkMode

    LazyColumn(
        modifier = Modifier.fillMaxSize()

    ) {
        stickyHeader {
            Header(darkMode = darkMode)
        }

        items(posts) { post ->
            PostCard(postData = post, darkMode = darkMode)
        }
    }
}

@Composable
fun PostCard(
    postData: PostData,
    darkMode: Boolean
){
    val textColor = if (darkMode) Color.White else Color.Black
    val secondaryTextColor = if (darkMode) Color.LightGray else Color.DarkGray

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (darkMode) Color(0xFF1E1E1E) else Color.White, // Mørkegrå i dark mode
            contentColor = textColor
        )
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
                    Text(postData.userName, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = textColor)
                    Text(postData.location, fontSize = 11.sp, color = textColor)
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
                Text(postData.safetyScore, color = pink, fontWeight = FontWeight.Bold)
            }
            Text(text = postData.description, fontSize = 14.sp, color = textColor)
        }
    }
}




