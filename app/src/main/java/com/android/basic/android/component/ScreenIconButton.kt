package com.android.basic.android.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.FilledTonalIconToggleButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.android.basic.android.R
import com.android.basic.android.ui.theme.BaseTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenIconButtons() {

    var isChecked by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            MediumTopAppBar(
                title = {
                    Text(
                        text = "Icon Buttons"
                    )
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.secondary,
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row() {
                FilledTonalIconToggleButton(
                    enabled = true,
                    checked = isChecked,
                    onCheckedChange = { value ->
                        isChecked = value
                    },
                    colors = IconButtonDefaults.filledIconToggleButtonColors(
                        containerColor = if(isChecked) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.background,
                    )
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_check_24),
                        contentDescription = null,
                    )
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                FilledTonalIconButton(
                    onClick = {}
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_cancel_24),
                        contentDescription = null,
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                //OutlinedIconButton
                OutlinedIconButton(
                    onClick = {}
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_check_24),
                        contentDescription = null,
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                ElevatedButton(
                    onClick = {}
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_cloud_done_24),
                        contentDescription = null,
                    )
                    Text(text = "Elevated Button")
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_notification_24),
                        contentDescription = null,
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
//                SingleChoiceSegmentedButtonRow() {
//                        SegmentedButton(
//                            onClick = {},
//                            selected = true,
//                            shape = SegmentedButtonDefaults.itemShape(0, 3),
//                            icon = { SegmentedButtonDefaults.Icon(active = true) },
//                            label = { Text("Option 1") }
//                        )
//                }
            }
        }
    }
}




@Preview(showBackground = false)
@Composable
fun ScreenIconButtonsPreview() {
        ScreenIconButtons()
}