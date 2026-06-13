package com.android.basic.android.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.android.basic.android.R
import com.android.basic.android.model.BadgeViewModel
import com.android.basic.android.model.BaseUiState
import com.android.basic.android.util.LoadingUtil

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenBadge(
    badgeViewModel: BadgeViewModel = viewModel()
) {


    val messageUiState by badgeViewModel.messageUiState.collectAsStateWithLifecycle()

    var message by remember { mutableStateOf("") }

    var hasNewNotification by remember { mutableStateOf(false) }
    var badgeNumber by remember { mutableStateOf(0) }


LaunchedEffect(Unit) {
    badgeViewModel.requestData()
}


    LaunchedEffect(messageUiState){
        when(val state = messageUiState){
            is BaseUiState.Loading -> {
                LoadingUtil.showLoading()
            }
            is BaseUiState.Success -> {
                LoadingUtil.hideLoading()
                message = state.data
            }
            is BaseUiState.Error -> {
                LoadingUtil.hideLoading()
            }
            is BaseUiState.ErrorWithException -> {
                LoadingUtil.hideLoading()
            }
            else -> {}
        }
    }




    Scaffold(
        modifier = Modifier.navigationBarsPadding(),
        topBar = {
            LargeTopAppBar(
                title = {
                    Text(
                        text = "Badge Component"
                    )
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.secondary,
                ),
                actions = {
                    BadgedBox(
                        badge = {
                            if (hasNewNotification) {
                                Badge()
                            }
                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_notification_24),
                            contentDescription = null,
                            tint = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    BadgedBox(
                        badge = {
                            if(badgeNumber > 0){
                                Badge() {

                                    val badgeNumberString = if(badgeNumber > 99) "99+" else badgeNumber
                                    Text(
                                        text = "$badgeNumberString"
                                    )
                                }
                            }
                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_notification_24),
                            contentDescription = null,
                            tint = Color.Black
                        )
                    }

                }
            )
        },
        bottomBar = {
            Row(
                modifier = Modifier.padding(12.dp)
            ) {
                FilledTonalButton(
                    onClick = {
                        hasNewNotification = !hasNewNotification
                    }
                ) {
                    Text(
                        text = "switch button"
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    onClick = {
                        badgeNumber += 25
                    }
                ) {
                    Text(
                        text = "update badge"
                    )
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

        }
    }
}

@Preview(showBackground = false)
@Composable
fun ScreenBadgePreview() {
    ScreenBadge()
}