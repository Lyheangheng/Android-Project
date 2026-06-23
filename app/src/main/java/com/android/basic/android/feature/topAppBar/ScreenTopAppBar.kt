package com.android.basic.android.feature.topAppBar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.android.basic.android.R
import com.android.basic.android.ui.theme.BaseTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun ScreenTopAppBar(
    onBack: () -> Unit = {}
) {


    val isDownloadOpen = remember { mutableStateOf(false) }

    val isMenuOpen = remember { mutableStateOf(false) }

    if(isMenuOpen.value){
        AlertDialog(
            title = {
                Text(
                    text = "Dialog Title"
                )
            },
            onDismissRequest = {
                isMenuOpen.value = false
            },
            confirmButton = {
                Button(
                    onClick = {
                        isMenuOpen.value = false
                    },
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onSurface)
                ) {
                    Text(
                        text = "Menu"
                    )
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        isMenuOpen.value = false
                    },
                    colors = ButtonDefaults.buttonColors(Color.Gray)
                ) {
                    Text(
                        text = "Cancel"
                    )
                }
            },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = null
                )
            },
            text = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.profile_1),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentScale = ContentScale.FillBounds
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Download Descriptions",
                    )
                }

            },
            properties = DialogProperties(dismissOnClickOutside = true)
        )
    }

    if (isDownloadOpen.value) {
        AlertDialog(
            title = {
                Text(
                    text = "Dialog Title"
                )
            },
            onDismissRequest = {
                isDownloadOpen.value = false
            },
            confirmButton = {
                Button(
                    modifier = Modifier,
                    onClick = {
                        isDownloadOpen.value = false
                    },
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onSurface)
                ) {
                    Text(
                        text = "Download"
                    )
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        isDownloadOpen.value = false
                    },
                    colors = ButtonDefaults.buttonColors(Color.Gray)
                ) {
                    Text(
                        text = "Cancel"
                    )
                }
            },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = null
                )
            },
            text = {
                Text(
                    modifier = Modifier.padding(start = 30.dp),
                    text = "Download Descriptions"
                )
            },
            properties = DialogProperties(dismissOnClickOutside = true)
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
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
                        text = stringResource(R.string.lbl_company_name)
                    )
                },
                actions = {
                    IconButton(
                        onClick = { isDownloadOpen.value = true }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_download_24),
                            contentDescription = null
                        )
                    }
                    IconButton(
                        onClick = { isMenuOpen.value = true }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.more_vert),
                            contentDescription = null
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.onSurface,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary)
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier.padding(padding)
        ) {

        }
    }
}


@Preview(showBackground = false)
@Composable
fun ScreenTopAppBarPreview() {
    BaseTheme(dynamicColor = false){
        ScreenTopAppBar()
    }
}