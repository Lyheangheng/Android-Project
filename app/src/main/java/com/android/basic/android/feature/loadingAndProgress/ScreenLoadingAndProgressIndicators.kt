package com.android.basic.android.feature.loadingAndProgress


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.basic.android.R
import com.android.basic.android.ui.theme.BaseTheme
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.android.basic.android.util.LoadingScreen
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun ScreenLoadingAndProgressIndicators(onBack: () -> Unit = {}) {

    var isDialogOpen by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    var list = remember {mutableListOf("hello")}
    var value by remember { mutableStateOf("") }

    if (isDialogOpen) {
        Dialog(
            onDismissRequest = { isDialogOpen = false },
            properties = DialogProperties(
                usePlatformDefaultWidth = false
            )
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxSize(),
                color = MaterialTheme.colorScheme.background.copy(.3f)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    // close button
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        IconButton(
                            onClick = {
                                isDialogOpen = false
                            }
                        ) {
                            Icon(
                                tint = MaterialTheme.colorScheme.outline,
                                painter = painterResource(R.drawable.ic_cancel_24),
                                contentDescription = null,
                            )
                        }
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    // Progress Indicator
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .height(64.dp),
                            color = MaterialTheme.colorScheme.outline,
                            trackColor = MaterialTheme.colorScheme.background.copy(.3f)
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    // confirm button
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.Bottom
                    ) {
                        Button(
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.outline,
                            ),
                            modifier = Modifier
                                .padding(16.dp),
                            onClick = {
                                isDialogOpen = false
                            }
                        ) {
                            Text(text = "confirm")
                        }
                    }
                }
            }
        }
    }



    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = onBack
                    ) {
                        Icon(
                            tint = MaterialTheme.colorScheme.outline,
                            painter = painterResource(R.drawable.baseline_arrow_back_ios_new_24),
                            contentDescription = null
                        )
                    }
                },
                title = {
                    Text(
                        color = MaterialTheme.colorScheme.outline,
                        text = "Progress indicators",
                        fontWeight = FontWeight.ExtraBold
                    )
                },
                actions = {
                    BadgedBox(
                        badge = {
                            Badge(
                                containerColor = MaterialTheme.colorScheme.outline
                            )
                        }
                    )
                    {
                        Icon(
                            tint = MaterialTheme.colorScheme.outline,
                            painter = painterResource(R.drawable.ic_baseline_notifications_none_24),
                            contentDescription = null,
                        )
                    }
                }
            )
        },
        bottomBar = {
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.outline
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                onClick = {
                    isDialogOpen = true

                    coroutineScope.launch {
                        delay(3000)
                        println("list: $list")
                        list.add(value)
                        value = ""
                        isDialogOpen = false
                    }
                }
            ) {
                Text(text = "show full screen dialog")
            }
        }
    )
    { padding ->
        LazyColumn (
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item{
                OutlinedTextField(
                    modifier = Modifier.padding(top = 12.dp, bottom = 12.dp),
                    value = value,
                    onValueChange = { it ->
                        value = it
                    },
                    label = {
                        Text(text = "Enter new value")
                    },
                    placeholder = {
                        Text(text = "Type here")
                    },
                    shape = RoundedCornerShape(12.dp),
                    singleLine = true,
                    maxLines = 1,
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = MaterialTheme.colorScheme.inversePrimary,
                        focusedIndicatorColor = MaterialTheme.colorScheme.outline.copy(.5f),
                        unfocusedContainerColor = MaterialTheme.colorScheme.outline.copy(.5f),
                        cursorColor = MaterialTheme.colorScheme.background,
                        focusedLabelColor = MaterialTheme.colorScheme.outline,
                        focusedPlaceholderColor = MaterialTheme.colorScheme.outline.copy(.5f),
                        focusedContainerColor = MaterialTheme.colorScheme.outline.copy(.5f),
                    ),
                    trailingIcon = {
                        Icon(
                            tint = MaterialTheme.colorScheme.background,
                            painter = painterResource(R.drawable.outline_airline_seat_recline_24),
                            contentDescription = null
                        )

                    },
                    leadingIcon = {
                        Icon(
                            tint = MaterialTheme.colorScheme.background,
                            painter = painterResource(R.drawable.outline_airline_seat_normal_24),
                            contentDescription = null
                        )
                    },
//                    prefix = {
//                        Text(
//                            text = "hi"
//                        )
//                    }
                )
            }
            items(list.size){    index ->
                Text(
                    color = MaterialTheme.colorScheme.outline,
                    text = list[index]
                )
            }

        }
    }
}


@Preview(showBackground = false)
@Composable
fun ScreenLoadingAndProgressIndicatorsPreview() {
    BaseTheme() {
//        ScreenLoadingAndProgressIndicators()
        LoadingScreen()
    }
}
