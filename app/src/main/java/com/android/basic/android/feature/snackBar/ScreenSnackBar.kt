package com.android.basic.android.feature.snackBar

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.basic.android.R
import com.android.basic.android.ui.theme.BaseTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenSnackBar(
    onBack: () -> Unit
) {

    val context = LocalContext.current
    val snackBarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()


    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(
                    text = "Snack Bar and Toast Message"
                )
            }, navigationIcon = {
                IconButton(
                    onClick = onBack
                    ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_arrow_back_24),
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
        snackbarHost = {
            SnackbarHost(
                hostState = snackBarHostState
            )
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {
                        scope.launch {
                            snackBarHostState.showSnackbar("SnackBar")
                        }
                    }
                ) {
                    Text(text = "Show SnackBar")
                }
                Spacer(Modifier.weight(1f))
                Button(
                    onClick = {
                        scope.launch {
                            val result = snackBarHostState.showSnackbar(
                                message = "Action SnackBar",
                                actionLabel = "Undo",
                                withDismissAction = true,
                                duration = SnackbarDuration.Long
                            )

                            when (result) {
                                SnackbarResult.ActionPerformed -> {}
                                SnackbarResult.Dismissed -> {}
                            }
                        }
                    }
                ) {
                    Text(text = "show action snack bar")
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {
                        scope.launch {
                            val toast = Toast.makeText(
                                context,
                                "toast message",
                                Toast.LENGTH_LONG
                            )
                            toast.show()
                        }
                    }
                ) {
                    Text(text = "show toast message")
                }
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun ScreenSnackBarPreview() {
    BaseTheme {
//        ScreenSnackBar()
    }
}