package com.android.basic.android.screen

import android.R
import android.R.attr.navigationIcon
import android.R.attr.onClick
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.basic.android.model.foodList


@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun ScreenLazyRow() {
    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "TopAppBar")

                },
                navigationIcon = {
                    IconButton(onClick = { /* Handle navigation icon click */ }) {
                        Icon(
                            painter = painterResource(com.android.basic.android.R.drawable.ic_settings_24),
                            contentDescription = null
                        )
                    }
                },
            )
        },
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            item {
                LazyRow(
                    modifier = Modifier
                ) {
                    items(foodList.size) { index ->
                        val food = foodList[index]
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(end = 15.dp)
                                .size(width = 150.dp, height = 150.dp)
                                .clip(RoundedCornerShape(25.dp)),
//                                .background(color = Color.Gray),
                        ) {

                            Image(
                                painter = painterResource(food.image),
                                contentScale = ContentScale.FillBounds,
                                contentDescription = null,
                                modifier = Modifier,
                            )
                            Column(
                                modifier = Modifier
                                    .fillMaxSize(),
                                verticalArrangement = Arrangement.Bottom,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = food.label,
                                    fontWeight = FontWeight.ExtraBold,
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .align(Alignment.TopStart)
                                    .padding(top = 10.dp, start = 10.dp)
                                    .size(20.dp)
                                    .clip(CircleShape)
                                    .background(color = Color.LightGray),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 10.sp,
                                    text = food.id.toString()
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = false)
@Composable
fun ScreenLazyRowPreview() {
    ScreenLazyRow()
}
