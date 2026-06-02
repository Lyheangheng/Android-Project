package com.android.basic.android.component.homework

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.contentType
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.basic.android.R
import com.android.basic.android.ui.theme.BaseTheme
import kotlin.random.Random


data class FilterChipItems(
    val id: Int,
    val label: String,
    var selected: Boolean = false
)

data class RecentSongs(
    val id: Int,
    @DrawableRes val image: Int,
    val songName: String,
    val artist: String
)

data class CardSongsSection(
    val cardColor: Color,
    @DrawableRes val image1: Int,
    @DrawableRes val image2: Int,
    @DrawableRes val image3: Int,
    val title: String
)


@Composable
fun SpotifyUI() {

    var selectedChipID by remember { mutableIntStateOf(1) }

    val chipItems = listOf<FilterChipItems>(
        FilterChipItems(
            id = 1,
            label = "All",
        ),
        FilterChipItems(
            id = 2,
            label = "Music"
        ),
        FilterChipItems(
            id = 3,
            label = "Podcasts"
        )
    )
    val recentSongs = listOf<RecentSongs>(
        RecentSongs(
            id = 1,
            image = R.drawable.the_marias_cover,
            songName = "Sienna",
            artist = "The Marias"
        ),
        RecentSongs(
            id = 2,
            image = R.drawable.secret_door_cover,
            songName = "Secret Door",
            artist = "Arctic Monkey"
        ),
        RecentSongs(
            id = 3,
            image = R.drawable.lana_cover,
            songName = "Let the light in",
            artist = "Lana Del Rey"
        ),
    )
    val cardSongsSection = listOf<CardSongsSection>(
        CardSongsSection(
            cardColor = Color.Gray,
            image1 = R.drawable.cas_cover,
            image2 = R.drawable.mj_cover,
            image3 = R.drawable.the_marias_cover,
            title = "Sienna"
        ),
        CardSongsSection(
            cardColor = Color.Gray,
            image1 = R.drawable.about_you_cover,
            image2 = R.drawable.xxxtentacion_cover,
            image3 = R.drawable.lover_rock_cover,
            title = "Love"
        ),
        CardSongsSection(
            cardColor = Color.Gray,
            image1 = R.drawable.she_and_him_cover,
            image2 = R.drawable.arctic_monkey_cover,
            image3 = R.drawable.olivia_cover,
            title = "Wanna be yours"
        ),
        CardSongsSection(
            cardColor = Color.Gray,
            image1 = R.drawable.the_marias_cover,
            image2 = R.drawable.secret_door_cover,
            image3 = R.drawable.lana_cover,
            title = "Let the light in"
        ),
        CardSongsSection(
            cardColor = Color.Gray,
            image1 = R.drawable.cas_cover,
            image2 = R.drawable.mj_cover,
            image3 = R.drawable.sombr_cover,
            title = "Sienna"
        )
    )


    Scaffold(
        bottomBar = {
            NavigationBar(
            ){
                NavigationBarItem(
                    selected = true,
                    onClick = {},
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.ic_settings_24),
                            contentDescription = null
                        )
                    },

                )
            }
        }

    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
        ) {
            items(1) {
                // Profile and Content Chips
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Profile Picture
                    Box(
                        modifier = Modifier
                            .padding(start = 12.dp)
                            .size(52.dp)
                            .clip(CircleShape),
                    ) {
                        Image(
                            painter = painterResource(R.drawable.profile_1),
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                    }
                    // Chips
                    chipItems.forEach { item ->
                        FilterChip(
                            modifier = Modifier
                                .height(32.dp)
                                .padding(start = 12.dp),
                            shape = RoundedCornerShape(24.dp),
                            selected = item.id == selectedChipID,
                            onClick = {
                                selectedChipID = item.id
                            },
                            label = {
                                Text(
                                    text = item.label
                                )
                            }
                        )
                    }
                }
                // Recent rotation
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 12.dp, top = 12.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        text = "Your Recent rotation",
                    )
                }
                // Recent songs display

                recentSongs.forEach { item ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                modifier = Modifier
                                    .size(72.dp),
                                painter = painterResource(item.image),
                                contentDescription = null,
                            )
                            // Song name and artist
                            Column(
                                modifier = Modifier
                                    .padding(start = 12.dp)
                            )
                            {
                                Text(
                                    fontWeight = FontWeight.Bold,
                                    text = item.songName,
                                    fontSize = MaterialTheme.typography.titleMedium.fontSize
                                )
                                Text(
                                    text = item.artist,
                                    fontSize = MaterialTheme.typography.bodyMedium.fontSize
                                )
                            }
                            Spacer(modifier = Modifier.weight(1f))
                            // Icon
                            Icon(
                                painter = painterResource(R.drawable.ic_check_24),
                                contentDescription = null,
                            )
                            Icon(
                                modifier = Modifier.padding(start = 24.dp),
                                painter = painterResource(R.drawable.ic_menu),
                                contentDescription = null,
                            )
                        }
                    }
                }
                // Jump back in
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 12.dp, top = 12.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        text = "Jump back in",
                    )
                }
                    // Card Section
                    LazyRow(
                        modifier = Modifier
                            .padding(start = 12.dp, top = 12.dp)
                    ) {
                        items(1) {

                            cardSongsSection.forEach { item ->
                                Card(
                                    colors = CardDefaults.cardColors(
                                        containerColor = item.cardColor
                                    ),
                                    modifier = Modifier.size(220.dp)
                                        .padding(end = 10.dp)
                                ) {
                                    Column(
                                        modifier = Modifier.fillMaxSize()
                                    ) {
                                        // RADIO
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(end = 8.dp, top = 5.dp),
                                            horizontalArrangement = Arrangement.End
                                        ) {
                                            Text(
                                                text = "RADIO"
                                            )
                                        }
                                        // Images
                                        Box(
                                            modifier = Modifier
                                                .padding(top = 12.dp)
                                                .fillMaxWidth()
                                                .height(140.dp),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            // Left Image (Distant)
                                            Image(
                                                painter = painterResource(item.image1),
                                                contentDescription = null,
                                                contentScale = ContentScale.Crop,
                                                modifier = Modifier
                                                    .size(80.dp)
                                                    .offset(x = (-80).dp)
                                                    .clip(CircleShape)
                                            )

                                            // Right Image
                                            Image(
                                                painter = painterResource(item.image2),
                                                contentDescription = null,
                                                contentScale = ContentScale.Crop,
                                                modifier = Modifier
                                                    .size(80.dp)
                                                    .offset(x = 80.dp)
                                                    .clip(CircleShape)
                                            )

                                            // Center Image
                                            Image(
                                                painter = painterResource(item.image3),
                                                contentDescription = null,
                                                contentScale = ContentScale.Crop,
                                                modifier = Modifier
                                                    .size(125.dp)
                                                    .clip(CircleShape)
                                                    .border(
                                                        width = 4.dp,
                                                        color = item.cardColor,
                                                        shape = CircleShape
                                                    )
                                            )
                                        }
                                        // Title
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(start = 12.dp)
                                        ) {
                                            Text(
                                                fontWeight = FontWeight.ExtraBold,
                                                text = item.title,
                                                fontSize = 32.sp,
                                            )
                                        }
                                    }
                                }
                            }


                        }
                    }

            }
        }
    }
}

@Preview
@Composable
fun SpotifyUIPreview() {
    BaseTheme() {
        SpotifyUI()
    }
}