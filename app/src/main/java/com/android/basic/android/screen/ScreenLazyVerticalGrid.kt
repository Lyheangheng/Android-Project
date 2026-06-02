package com.android.basic.android.screen

import com.android.basic.android.R
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.basic.android.model.clothesList
import com.android.basic.android.model.foodList


@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun ScreenLazyVerticalGrid() {
    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text("LazyVerticalGrid")
                },
                navigationIcon = {
                    IconButton(onClick = { /* Handle navigation icon click */ }) {
                        Icon(
                            painter = painterResource(R.drawable.ic_menu),
                            contentDescription = null
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(R.drawable.more_vert),
                            contentDescription = null
                        )
                    }
                }
            )
        },
    ) { padding ->
        LazyVerticalGrid(
            modifier = Modifier
                .padding(padding),
            columns = GridCells.Fixed(2)
        ) {
            items(clothesList.size){ index ->
                val cloth = clothesList[index]
                // Image
                Column(
                    modifier = Modifier
                        .padding(5.dp)
                        .safeContentPadding()
//                        .background(color = Color.LightGray)
                ) {
                    // Image
                    Box(
                        modifier = Modifier
                            .height(180.dp)
                    )
                    {
                        Image(
                            modifier = Modifier
                                .fillMaxSize(),
                            contentScale = ContentScale.Crop,
                            painter = painterResource(id = cloth.image),
                            contentDescription = "Clothes"
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    // Description
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ){
                        Text(
                            modifier = Modifier
                                .fillMaxWidth(),
                            text = cloth.description,
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 1
                        )
                    }
                    //Price and Add to cart btn
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "${cloth.clothesCurrencyCode.code}${cloth.price}",
                            color = Color.Red,
                            fontSize = 20.sp
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        FilledTonalButton(
                            modifier = Modifier,
                            onClick = {},
                            contentPadding = PaddingValues(0.dp),
                            colors = ButtonDefaults.buttonColors(
                                contentColor = Color.Black,
                                containerColor = Color.White
                            ),
                            border = BorderStroke(1.dp, Color.Black)
                        ) {
                            Icon(
                                modifier = Modifier
                                    .size(15.dp),
                                painter = painterResource(R.drawable.add_shop_cart),
                                contentDescription = null,
                                tint = Color.Black
                            )
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = false)
@Composable
fun ScreenScreenLazyVerticalGridPreview() {
    ScreenLazyVerticalGrid()
}
