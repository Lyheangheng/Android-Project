package com.android.basic.android.feature.radioButton

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
fun ScreenRadioButton(onBack: () -> Unit = {}) {


    var selectedSize by remember { mutableIntStateOf(1) }
    var selectedSugar by remember { mutableIntStateOf(2) }


    val sugarItems = listOf<SugarItems>(
        SugarItems(
            id = 1,
            label = SugarLevel.NO_SUGAR
        ),
        SugarItems(
            id = 2,
            label = SugarLevel.LOW_SUGAR
        ),
        SugarItems(
            id = 3,
            label = SugarLevel.MEDIUM_SUGAR
        ),
        SugarItems(
            id = 4,
            label = SugarLevel.HIGH_SUGAR
        ),
        SugarItems(
            id = 5,
            label = SugarLevel.VERY_HIGH_SUGAR
        )
    )
    val sizeItems = listOf<SizeItems>(
        SizeItems(
            id = 1,
            label = SizeLevel.SMALL
        ),
        SizeItems(
            id = 2,
            label = SizeLevel.MEDIUM
        ),
        SizeItems(
            id = 3,
            label = SizeLevel.LARGE
        ),
        SizeItems(
            id = 4,
            label = SizeLevel.EXTRA_LARGE
        )
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Radio Button"
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBack
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_arrow_back_ios_new_24),
                            contentDescription = null,
                        )
                    }
                },
                actions = {
                    BadgedBox(
                        badge = {
                            Badge(
                                containerColor = MaterialTheme.colorScheme.error
                            )
                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_notification_24),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 12.dp, end = 12.dp)
            ) {
                // Size section
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Pick a size",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
                sizeItems.forEachIndexed { index, item ->
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable(
                                onClick = {
                                    selectedSize = index
                                }
                            ),
                    ) {
                        RadioButton(
                            selected = index == selectedSize,
                            onClick = {
                                selectedSize = index
                            },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = MaterialTheme.colorScheme.secondary,
                            )
                        )
                        Text(
                            text = item.label.code.lowercase(LocalLocale.current.platformLocale)
                        )
                    }
                }
                // Sugar level section
                HorizontalDivider()
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp)
                ) {
                    Text(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        text = "Pick sugar level"
                    )
                }
                sugarItems.forEachIndexed { index, item ->
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable(
                                onClick = {
                                    selectedSugar = index
                                }
                            ),
                    ) {
                        RadioButton(
                            selected = index == selectedSugar,
                            onClick = {
                                selectedSugar = index
                            },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = MaterialTheme.colorScheme.secondary,
                            )
                        )
                        Text(
                            text = "${item.label.code} %"
                        )
                    }
                }
            }

        }

    }
}

data class SugarItems(
    val id: Int,
    val label: SugarLevel,
    val selected: Boolean = false
)

data class SizeItems(
    val id: Int,
    val label: SizeLevel,
    val selected: Boolean = false
)

enum class SizeLevel(val code: String) {
    SMALL("S"),
    MEDIUM("M"),
    LARGE("L"),
    EXTRA_LARGE("XL")
}

enum class SugarLevel(val code: String) {
    NO_SUGAR("00"),
    LOW_SUGAR("25"),
    MEDIUM_SUGAR("50"),
    HIGH_SUGAR("75"),
    VERY_HIGH_SUGAR("100")
}

@Preview(showBackground = false)
@Composable
fun ScreenRadioButtonPreview() {
    BaseTheme {
        ScreenRadioButton()
    }
}