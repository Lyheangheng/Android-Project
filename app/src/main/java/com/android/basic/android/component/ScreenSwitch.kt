package com.android.basic.android.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.basic.android.R
import com.android.basic.android.ui.theme.BaseTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenSwitch() {

var checked by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(
                    text = "Switch"
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
    ) { paddingValue ->
        Column(
            modifier = Modifier
                .padding(paddingValue)
                .fillMaxSize(),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    )
                {
                    Switch(
                        checked = checked,
                        onCheckedChange = {
                            checked = it
                        }
                    )
                    Text(
                        modifier = Modifier.padding(start = 5.dp),
                        text = "switch"
                    )
                    Spacer(Modifier.width(25.dp))
                    Switch(
                        checked = checked,
                        onCheckedChange = {
                            checked = it
                        },
                        colors = SwitchDefaults.colors(
                            checkedBorderColor = MaterialTheme.colorScheme.inversePrimary,
                            checkedThumbColor = MaterialTheme.colorScheme.onBackground,
                            checkedTrackColor = MaterialTheme.colorScheme.outline,
                            checkedIconColor = MaterialTheme.colorScheme.onPrimary,
                        ),
                        thumbContent = {
                            if(checked){
                                Icon(
                                    painter = painterResource(R.drawable.ic_check_24),
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.onPrimary
                                )
                            }
                        }
                    )
                    Text(
                        modifier = Modifier.padding(start = 5.dp),
                        text = " customize switch  "
                    )
                }
            }
        }
    }
}


@Preview(showBackground = false)
@Composable
fun ScreenSwitchPreview() {
    BaseTheme {
        ScreenSwitch()
    }
}