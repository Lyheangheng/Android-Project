package com.android.basic.android.feature.singleChoiceSegmentedButton

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.android.basic.android.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenSegmentedButton(onBack: () -> Unit = {}) {


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
                        onBack
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_arrow_back_ios_new_24),
                            contentDescription = null
                        )
                    }
                },
                title = {
                    Text(
                        text = "SingleChoiceSegmentButton"
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
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row() {

                SingleChoiceSegmentedButtonRow() {
                    options.forEachIndexed { index, label ->
                        SegmentedButton(
                            shape = SegmentedButtonDefaults.itemShape(
                                index = index,
                                count = options.size
                            ),
                            onClick = { selectedIndex = index },
                            selected = index == selectedIndex,
                            label = { Text(label) }
                        )
                    }
                }
            }
            Row() {
                MultiChoiceSegmentedButtonRow() {
                    options.forEachIndexed { index, label ->
                        SegmentedButton(
                            checked = selectedOptions[index],
                            onCheckedChange = { selectedOptions[index] = it },
                            shape = SegmentedButtonDefaults.itemShape(
                                index = index,
                                count = options.size
                            ),
                            label = { Text(label) }
                        )
                    }
                }
            }
            }
        }
    }



@Preview(showBackground = false)
@Composable
fun ScreenSegmentedButtonPreview() {

        ScreenSegmentedButton()

}