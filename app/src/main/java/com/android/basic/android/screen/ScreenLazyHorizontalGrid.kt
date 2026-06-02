package com.android.basic.android.screen

import com.android.basic.android.R
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.WhitePoint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.basic.android.model.clothesList
import com.android.basic.android.model.foodList
import com.android.basic.android.model.songList


//val configuration = androidx.compose.ui.platform.LocalConfiguration.current
//val screenWidth = configuration.screenWidthDp.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun ScreenLazyHorizontalGrid() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text("LazyHorizontalGrid")
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
        Column(
            modifier = Modifier.padding(padding)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                //HeadText
                Text(
                    fontSize = 30.sp,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily(
                        Font(R.font.lato_italic)
                    ),
                    text = "Quick picks"
                )
                // play all btn
                Spacer(modifier = Modifier.weight(1f))
                TextButton(
                    modifier = Modifier,
                    onClick = {},
                    contentPadding = PaddingValues(0.dp),
                    border = BorderStroke(1.dp, Color.Black),
                ) {
                    Text(
                        fontSize = 13.sp,
                        text = "Play all",
                        color = Color.Black
                    )
                }
                //Arrow icon
                Icon(
                    modifier = Modifier
                        .padding(start = 15.dp),
                    painter = painterResource(R.drawable.ic_settings_24),
                    contentDescription = null,
                )
                Icon(
                    painter = painterResource(R.drawable.ic_settings_24),
                    contentDescription = null
                )
            }
            LazyHorizontalGrid(
                modifier = Modifier
                    .height(340.dp),
                rows = GridCells.Fixed(4),
                verticalArrangement = Arrangement.Center,
                contentPadding = PaddingValues(start = 5.dp),
            ) {
                items(songList.size) { index ->
                    val song = songList[index]
                    // HorizontalGrid
                    Row(
                        modifier = Modifier
//                            .background(Color.Gray)
                            .padding(10.dp)
                            .width(300.dp),

                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        // Songs cover
                        Box(
                            modifier = Modifier
                                .size(height = 80.dp, width = 80.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                        ) {
                            Image(
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(10.dp)),
                                painter = painterResource(song.image),
                                contentDescription = "",
                                contentScale = ContentScale.FillBounds,

                                )
                        }
                        // Song title , plays amount and descriptions
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp)
                                .weight(1f)
                        ) {
                            Text(
                                fontWeight = FontWeight.Bold,
                                text = song.title,
                            )
                            Row(
                            ) {
                                Text(
                                    text = song.description,
                                    overflow = TextOverflow.Ellipsis,
                                    maxLines = 1
                                )
                            }
                        }
                        // more_vert icon
                        Icon(
                            modifier = Modifier
                                .padding(start = 35.dp),
                            painter = painterResource(R.drawable.more_vert),
                            contentDescription = null
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = false)
@Composable
fun ScreenLazyHorizontalGridPreview() {
    ScreenLazyHorizontalGrid()
}
