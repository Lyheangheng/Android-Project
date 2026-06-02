package com.android.basic.android.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.platform.LocalLocale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.basic.android.R
import com.android.basic.android.ui.theme.BaseTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenSlider() {

    var sliderPosition by remember { mutableFloatStateOf(0.0f) }
    var sliderPositionRange by remember { mutableFloatStateOf(0.0f) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(
                    text = "Slider"
                )
            }, navigationIcon = {
                IconButton(
                    onClick = {

                    }) {
                    Icon(
                        painter = painterResource(R.drawable.ic_sort_24),
                        contentDescription = null,
                    )
                }
            }, actions = {
                BadgedBox(
                    badge = {
                        Badge(
                            containerColor = MaterialTheme.colorScheme.error
                        )
                    }) {
                    Icon(
                        painter = painterResource(R.drawable.ic_notification_24),
                        contentDescription = null,
                    )
                }
            })
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colorScheme.secondaryContainer.copy(0.5f)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Slider(
                    value = sliderPosition,
                    onValueChange = {
                        sliderPosition = it
                    },
                    modifier = Modifier,

                    colors = SliderDefaults.colors(
                        activeTrackColor = MaterialTheme.colorScheme.inversePrimary,
                        thumbColor = MaterialTheme.colorScheme.primary,
                        inactiveTrackColor = MaterialTheme.colorScheme.background
                    ),
                    thumb = {
                        Box(
                            modifier = Modifier
                                .clip(shape = CircleShape)
                                .size(20.dp)
                                .background(color = MaterialTheme.colorScheme.inversePrimary)
                        ){

                        }
                    }
                )
                Text(text = "sliderPosition = $sliderPosition")

                Slider(
                    value = sliderPositionRange,
                    onValueChange = {
                        sliderPositionRange = it
                    },
                    modifier = Modifier,

                    colors = SliderDefaults.colors(
                        activeTrackColor = MaterialTheme.colorScheme.inversePrimary,
                        thumbColor = MaterialTheme.colorScheme.primary,
                        inactiveTrackColor = MaterialTheme.colorScheme.background
                    ),
                    thumb = {
                        Box(
                            modifier = Modifier
                                .clip(shape = CircleShape)
                                .size(20.dp)
                                .background(color = MaterialTheme.colorScheme.inversePrimary)
                        )
                    },
                    valueRange = 0f..100f,
                    steps = 9
                )
                Text(text = "sliderPositionRange = ${sliderPositionRange.toInt()}")
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun ScreenSliderPreview() {
    BaseTheme {
        ScreenSlider()
    }
}