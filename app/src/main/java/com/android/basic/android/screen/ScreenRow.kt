package com.android.basic.android.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable

fun ScreenRow(){
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ){ _ ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(Color.LightGray),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .height(128.dp)
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colorScheme.primary.copy(alpha = 0.8f)),
               verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    modifier = Modifier
//                        .fillMaxHeight()
                        .background(Color.Yellow),
                    color = Color.Red,
                    text = "Row",
                    fontSize = 24.sp
                )
                Text(
                    modifier = Modifier
//                        .fillMaxHeight()
                        .background(Color.Red),
                    color = Color.Yellow,
                    fontSize = 24.sp,
                    text = "Row"
                )

            }
        }

    }
}
@Preview(showBackground = false)
@Composable
fun ScreenRowPreview(){
    ScreenRow()
}