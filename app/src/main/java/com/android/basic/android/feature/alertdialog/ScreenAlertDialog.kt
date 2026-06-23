package com.android.basic.android.feature.alertdialog


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.basic.android.R
import com.android.basic.android.ui.theme.BaseTheme


@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun ScreenAlertDialog(
    onBack: () -> Unit = {}
) {

    var isDialogOpen by remember { mutableStateOf(false) }

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
                            painter = painterResource(R.drawable.ic_sort_24),
                            contentDescription = null
                        )
                    }
                },
                title = {
                    Text(
                        color = MaterialTheme.colorScheme.outline,
                        text = "Screen Alert Dialog",
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
                }
            ) {
                Text(text = "click to show dialog")
            }
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

            if (isDialogOpen) {
                AlertDialog(
                    title = {
                        Text(
                            text = "Alert Dialog Title"
                        )
                    },
                    text = {
                        Text(
                            text = "The AlertDialog composable provides a convenient API for creating a Material Design themed dialog. AlertDialog has specific parameters for handling particular elements of the dialog. Among them are the following:"
                        )
                    },
                    onDismissRequest = {
                        isDialogOpen = false
                    },
                    confirmButton = {
                        Button(
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.outline
                            ),
                            onClick = {
                                isDialogOpen = false
                            }
                        ) {
                            Text(
                                text = "Confirm"
                            )
                        }
                    },
                    dismissButton = {
                        Button(
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.outline.copy(0.7f)
                            ),
                            onClick = {
                                isDialogOpen = false
                            }
                        ) {
                            Text(
                                text = "Dismiss"
                            )
                        }

                    },
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.ic_launcher_foreground),
                            contentDescription = null
                        )
                    },
                    tonalElevation = 12.dp,
//                    containerColor = MaterialTheme.colorScheme.primary,
                    iconContentColor =  MaterialTheme.colorScheme.outline,
                    titleContentColor =  MaterialTheme.colorScheme.outline,
//                    textContentColor = MaterialTheme.colorScheme.background,
                )
            }
        }
    }
}


@Preview(showBackground = false)
@Composable
fun ScreenAlertDialogPreview() {
    BaseTheme() {
        ScreenAlertDialog()
    }
}

