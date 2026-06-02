package com.android.basic.android.component.homework

import android.R.attr.enabled
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CheckboxDefaults.colors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderColors
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.basic.android.R
import com.android.basic.android.ui.theme.BaseTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenSliderHomework() {

    val totalDuration = 195f

    var sliderPosition by remember { mutableFloatStateOf(0.0f) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        color = MaterialTheme.colorScheme.inversePrimary,
                        text = "Slider"
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {

                        }) {
                        Icon(
                            tint = MaterialTheme.colorScheme.inversePrimary,
                            painter = painterResource(R.drawable.ic_arrow_back_24),
                            contentDescription = null,
                        )
                    }
                },
                actions = {
                    Icon(
                        tint = MaterialTheme.colorScheme.error,
                        painter = painterResource(R.drawable.ic_filled_favorite_24),
                        contentDescription = null,
                    )
                }
            )
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                // Song Cover
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp),
                    verticalAlignment = Alignment.Top

                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(shape = RoundedCornerShape(25.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(25.dp)),
                            painter = painterResource(R.drawable.xxxtentacion_cover),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                        )
                    }
                }
                // Song Name
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "xxxtentacion",
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text(
                        text = "I don't even speak spanish lol",
                        style = MaterialTheme.typography.titleMedium
                    )
                }
                // Slider
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Slider(
                        value = sliderPosition,
                        onValueChange = {
                            sliderPosition = it
                        },
                        thumb = {},
                        modifier = Modifier,
                        track = { sliderState ->
                            SliderDefaults.Track(
                                colors = SliderDefaults.colors(
                                    inactiveTrackColor = MaterialTheme.colorScheme.outline.copy(0.2f),
                                    activeTrackColor = MaterialTheme.colorScheme.inversePrimary,
                                ),
                                enabled = true,
                                sliderState = sliderState,
                                thumbTrackGapSize = 0.dp
                            )
                        },
                        valueRange = 0f..195f
                    )
                }
                // Song playtime
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = formatTime(sliderPosition),
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "3:15"
                    )
                }
                // Control Button
                Row(
                    modifier = Modifier.
                    fillMaxWidth()
                        .padding(start = 16.dp)
                        .wrapContentHeight(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    // shuffle button
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_shuffle_24),
                            contentDescription = null,
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    // skip left button
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_skip_previous_24),
                            contentDescription = null,
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    // play button
                    Box(
                        modifier = Modifier
                            .size(74.dp)
                            .clip(shape = CircleShape)
                            .clickable(
                                onClick = {}
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_play_circle_24),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    // skip right button
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_skip_next_24),
                            contentDescription = null,
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    // repeat button
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_repeat_24),
                            contentDescription = null,
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

private fun formatTime(seconds: Float): String {
    val totalSeconds = seconds.toInt()
    val minutes = totalSeconds / 60
    val remainingSeconds = totalSeconds % 60
    return "%02d:%02d".format(minutes, remainingSeconds)
}

@Preview(showBackground = false)
@Composable
fun ScreenSliderHomeworkPreview() {
    BaseTheme {
        ScreenSliderHomework()
    }
}