package com.android.basic.android.component.homework


import android.app.Dialog
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.basic.android.R
import com.android.basic.android.ui.theme.BaseTheme
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.android.basic.android.storage.productLists
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.nio.file.WatchEvent




@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun DetermineIndicators() {

    var isDialogOpen by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()


    var currentProgress by remember { mutableFloatStateOf(0f) }
    var loading by remember { mutableStateOf(false) }

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
                    CircularProgressIndicator(
                        progress = {currentProgress},
                        modifier = Modifier
                            .height(64.dp)
                            .align(Alignment.CenterHorizontally),
                        color = MaterialTheme.colorScheme.outline,
                        trackColor = MaterialTheme.colorScheme.background.copy(.3f)
                    )
                    LinearProgressIndicator(
                        progress = {currentProgress},
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally),
                        color = MaterialTheme.colorScheme.outline,
                        trackColor = MaterialTheme.colorScheme.background.copy(.3f)
                    )
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
                                isDialogOpen = true

                                coroutineScope.launch {

                                }
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
                    Icon(
                        tint = MaterialTheme.colorScheme.outline,
                        painter = painterResource(R.drawable.ic_sort_24),
                        contentDescription = null
                    )
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
                        loadProgress { progress ->
                            currentProgress = progress
                        }
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
            item{}
        }
    }
}


@Preview(showBackground = false)
@Composable
fun DetermineIndicatorsPreview() {
    BaseTheme() {
        DetermineIndicators()
    }
}

suspend fun loadProgress(updateProgress: (Float) -> Unit){
    for(i in 1..100){
        updateProgress(i/100f)
        delay(100)
    }
}