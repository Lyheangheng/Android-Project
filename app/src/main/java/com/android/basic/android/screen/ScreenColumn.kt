package com.android.basic.android.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable

fun ScreenColumn(){
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
            Text(
                color = Color.Yellow,
                text = "Welcome to the Home Screen"
            )
            Text("This is the Home Screen")
            Text("This is the Home Screen2")
        }

    }
}
@Preview(showBackground = false)
@Composable
fun ScreenColumnPreview(){
    ScreenColumn()
}