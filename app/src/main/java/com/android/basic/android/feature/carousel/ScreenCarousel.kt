package com.android.basic.android.feature.carousel

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.basic.android.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenCarousel(
    onBack : () -> Unit = {}
) {

    Scaffold(
        modifier = Modifier,
        topBar = {
            CenterAlignedTopAppBar(
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
                        text = "Carousel",
                        fontWeight = FontWeight.ExtraBold
                    )
                },
                actions = {
                    BadgedBox(
                        badge = {
                            Badge()
                        }
                    )
                    {
                        Icon(
                            painter = painterResource(R.drawable.ic_baseline_notifications_none_24),
                            contentDescription = null,
                        )
                    }

                },
            )
        }
    )
    { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(color = Color.LightGray.copy(alpha = 0.3f))
        ) {
            items(1) {
                HorizontalMultiBrowseCarousel(
                    state = rememberCarouselState { lists.count()},
                    preferredItemWidth = 520.dp,
                    itemSpacing = 8.dp,
                    contentPadding = PaddingValues(8.dp)
                ) { index ->

                    val image = lists[index]
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1f/1f)
//                            .clip(shape = RoundedCornerShape(35.dp))
                            .maskClip(MaterialTheme.shapes.extraLarge),
                        painter = painterResource(image.image),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
    }
}


@Preview(showBackground = false)
@Composable
fun ScreenCarouselPreview() {

    ScreenCarousel()

}

data class Carousel(
    val id: Int,
    @DrawableRes val image: Int,
    val contentDescription: String
)

val lists = listOf<Carousel>(
    Carousel(1, R.drawable.profile_1, "Image 1"),
    Carousel(2, R.drawable.profile_2, "Image 2"),
    Carousel(3, R.drawable.profile_3, "Image 3"),
    Carousel(4, R.drawable.profile_4, "Image 4"),
    Carousel(5, R.drawable.profile_5, "Image 5"),
    Carousel(6, R.drawable.profile_6, "Image 6"),
    Carousel(7, R.drawable.profile_7, "Image 7"),
    Carousel(8, R.drawable.profile_8, "Image 8"),
    Carousel(9, R.drawable.profile_9, "Image 9"),
    Carousel(10, R.drawable.profile_10, "Image 10"),
    Carousel(11, R.drawable.profile_11, "Image 11"),
    Carousel(12, R.drawable.profile_12, "Image 12"),
    Carousel(13, R.drawable.profile_13, "Image 13"),
    Carousel(14, R.drawable.profile_14, "Image 14"),
    Carousel(15, R.drawable.profile_15, "Image 15"),
)