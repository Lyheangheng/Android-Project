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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Add
//import androidx.compose.material.icons.filled.ArrowBack
//import androidx.compose.material.icons.filled.CheckCircle
//import androidx.compose.material.icons.filled.KeyboardArrowLeft
//import androidx.compose.material.icons.filled.KeyboardArrowRight
//import androidx.compose.material.icons.filled.Settings
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
import com.android.basic.android.storage.accountList


//val configuration = androidx.compose.ui.platform.LocalConfiguration.current
//val screenWidth = configuration.screenWidthDp.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun ScreenHorizontalPager() {


    val pageState = rememberPagerState(pageCount = { accountList.size })
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text("HorizontalPager")
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
                            painter = painterResource(R.drawable.ic_settings_24),
                            contentDescription = null
                        )
                    }
                }
            )
        },
    ) { padding ->
        HorizontalPager(
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding)
                ,
            state = pageState,
            verticalAlignment = Alignment.Top,
            contentPadding = PaddingValues(16.dp),
            pageSpacing = 8.dp
        ) { page ->
            val account = accountList[page]
            // Card container
            Box(
                modifier = Modifier
                    .height(225.dp)
                    .fillMaxSize()
                    .clip(shape = RoundedCornerShape(16.dp))
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxSize(),
                    painter = painterResource(R.drawable.background_card),
                    contentDescription = "",
                    contentScale = ContentScale.FillBounds
                )
                //Content Container
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    //VISA symbol
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_settings_24),
                            contentDescription = null,
                            tint = Color.White
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        // Visa
                        Text(
                            fontSize = 30.sp,
                            text = "VISA",
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    //Card Numbers
                    Row() {
                        Text(
                            fontSize = 30.sp,
                            text = account.accountNo,
                            color = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    //String of card holder expire dates and cvv
                    Row() {
                        Text(
                            color = Color.White.copy(0.5f),
                            text = "CARD HOLDER",
                            fontSize = 10.sp
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            
                            modifier = Modifier.padding(end = 45.dp),
                            text = "EXPIRES",
                            color = Color.White.copy(0.5f),
                            fontSize = 10.sp
                        )
                        Text(
                            color = Color.White.copy(0.5f),
                            text = "CVV",
                            fontSize = 10.sp,
                        )
                    }
                    //Actual card holder name, expire dates and cvv number
                    Row() {
                        Text(
                            color = Color.White,
                            text = account.accountName
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            color = Color.White,
                            modifier = Modifier.padding(end = 40.dp),
                            text = account.expiredDate
                        )
                        Text(
                            color = Color.White,
                            text = account.cvv
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = false)
@Composable
fun ScreenHorizontalPagerPreview() {
    ScreenHorizontalPager()
}
