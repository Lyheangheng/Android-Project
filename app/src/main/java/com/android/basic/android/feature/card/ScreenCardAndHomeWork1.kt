package com.android.basic.android.feature.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.basic.android.R
import com.android.basic.android.storage.breakfastLists
import com.android.basic.android.storage.lunchLists
import com.android.basic.android.storage.snackLists

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenCardAndHomeWork1(
    onBack : () -> Unit = {}
) {

    val scrollState = rememberScrollState()


    var selectedIndex by remember { mutableStateOf(0) }
    var options = listOf("Day", "Month", "Week", "Year")

    var selectedOptions = remember { mutableStateListOf(false, false, false, false) }

    var hasNewNotification by remember { mutableStateOf(false) }
    var badgeNumber by remember { mutableStateOf(0) }

    Scaffold(
        modifier = Modifier.navigationBarsPadding(),
        topBar = {
            MediumTopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = onBack
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_arrow_back_ios_new_24),
                            contentDescription = null
                        )
                    }
                },
                title = {
                    Text(
                        fontWeight = FontWeight.Bold,
                        text = "Recipes"
                    )
                },
                actions = {
                    Icon(
                        painter = painterResource(R.drawable.more_vert),
                        contentDescription = null
                    )
                },
            )
        }
    )
    { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(scrollState),
        ) {
            // Snacks Row
            Row(
                modifier = Modifier.padding(start = 12.dp)
            ) {
                // text "snacks" and "see all"
                Text(
                    fontSize = 20.sp,
                    text = "Snacks",
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    modifier = Modifier.padding(end = 12.dp),
                    text = "see all",
                    color = Color.Blue.copy(alpha = 0.5f)
                )
            }
            // Pictures and descriptions
            LazyRow(
                contentPadding = PaddingValues(12.dp)
            ){
                items(count = snackLists.size) { index ->

                    val snack = snackLists[index]

                    Column() {
                        Card(
                            modifier = Modifier
                                .size(width = 320.dp, height = 200.dp)
                                .padding(end = 12.dp)
                        ) {
                            Image(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                painter = painterResource(snack.image),
                                contentDescription = null,
                                contentScale = ContentScale.FillBounds
                            )
                        }
                        //descriptions
                        Column(
                            modifier = Modifier
                                .padding(top = 12.dp)
                                .alpha(.8f)
                        ) {
                            Text(
                                text = snack.description
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.ic_play_circle_24),
                                    contentDescription = null
                                )
                                Text(
                                    text = "${snack.time} • Workout"
                                )
                            }
                        }
                    }
                }
            }
            // Breakfast Row
            Row(
                modifier = Modifier.padding(start = 12.dp)
            ) {
                // text "Breakfast" and "see all"
                Text(
                    fontSize = 20.sp,
                    text = "Breakfast",
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    modifier = Modifier.padding(end = 12.dp),
                    text = "see all",
                    color = Color.Blue.copy(alpha = 0.5f)
                )
            }
            //Pictures and descriptions
            LazyRow(
                contentPadding = PaddingValues(12.dp)
            ){
                items( count = breakfastLists.size) { index ->

                    val breakfast = breakfastLists[index]

                    Column() {
                        Card(
                            modifier = Modifier
                                .size(width = 320.dp, height = 200.dp)
                                .padding(end = 12.dp)
                        ) {
                            Image(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                painter = painterResource(breakfast.image),
                                contentDescription = null,
                                contentScale = ContentScale.FillBounds
                            )
                        }
                        //descriptions
                        Column(
                            modifier = Modifier
                                .padding(top = 12.dp)
                                .alpha(.8f)
                        ) {
                            Text(
                                text = breakfast.description
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.ic_play_circle_24),
                                    contentDescription = null
                                )
                                Text(
                                    text = "${breakfast.time}• Workout"
                                )
                            }
                        }
                    }
                }
            }
            // Lunch Row
            Row(
                modifier = Modifier.padding(start = 12.dp)
            ) {
                // text "Lunch" and "see all"
                Text(
                    fontSize = 20.sp,
                    text = "Lunch",
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    modifier = Modifier.padding(end = 12.dp),
                    text = "see all",
                    color = Color.Blue.copy(alpha = 0.5f)
                )
            }
            //Pictures and descriptions
            LazyRow(
                contentPadding = PaddingValues(12.dp)
            ){
                items(count = lunchLists.size) { index ->

                    val lunch = lunchLists[index]

                    Column() {
                        Card(
                            modifier = Modifier
                                .size(width = 320.dp, height = 200.dp)
                                .padding(end = 12.dp)
                        ) {
                            Image(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                painter = painterResource(lunch.image),
                                contentDescription = null,
                                contentScale = ContentScale.FillBounds
                            )
                        }
                        //descriptions
                        Column(
                            modifier = Modifier
                                .padding(top = 12.dp)
                                .alpha(.8f)
                        ) {
                            Text(
                                text = lunch.description
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.ic_play_circle_24),
                                    contentDescription = null
                                )
                                Text(
                                    text = "${lunch.time} min • Workout"
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
fun ScreenCardAndHomeWork1Preview() {

    ScreenCardAndHomeWork1()

}