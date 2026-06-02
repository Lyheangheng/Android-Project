package com.android.basic.android.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ScreenBox() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background
    ) { padding ->
        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(400.dp)
                    .background(
                        color = Color.Red,
                        shape = CircleShape))
            Box(
                modifier = Modifier
                    .size(300.dp)
                    .background(
                        color = Color.Blue,
                        shape = CircleShape))
            Box(
                modifier = Modifier
                    .size(200.dp)
                    .background(
                        color = Color.Yellow,
                        shape = CircleShape),
                contentAlignment = Alignment.Center){
                Text(
                    text = "Wazabi",
                    fontSize = 24.sp,
                )
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun PreviewScreenBox(){
    ScreenBox()
}