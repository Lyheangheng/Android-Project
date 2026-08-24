package com.android.basic.android.feature.singleMediaPicker

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.defaultDecayAnimationSpec
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberBottomAppBarState
import androidx.compose.material3.rememberTooltipState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.android.basic.android.R
import com.android.basic.android.TooltipViewModel
import com.android.basic.android.feature.notification.contentTitle
import com.android.basic.android.model.ReceiverAccountModel
import com.android.basic.android.ui.theme.BaseTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SingleMediaPicker(onBack: () -> Unit = {}) {


    val scrollBehavior =
        TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())

    val bottomBarScrollBehavior =
        BottomAppBarDefaults.exitAlwaysScrollBehavior(rememberBottomAppBarState())

    val scope = rememberCoroutineScope()
    val toolTipState1 = rememberTooltipState()


    val tooltipViewModel: TooltipViewModel = viewModel()
    val accountInfo by tooltipViewModel.receiverAccount.collectAsStateWithLifecycle()
    var receiverAccount by remember { mutableStateOf<ReceiverAccountModel?>(null) }

    val pickMedia =
        rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->

            if (uri != null) {
                println("=====> media selected: $uri")
            } else {
                println("=====> no media selected")
            }
        }


    fun launchMediaPicker(){
        pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
    }





    LaunchedEffect(accountInfo) {

        accountInfo.let {
            if (it != null) {
                receiverAccount = accountInfo
                println("=====> $accountInfo")
            }
        }


    }





    Scaffold(
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection)
            .nestedScroll(bottomBarScrollBehavior.nestedScrollConnection),
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f),
                ),
                scrollBehavior = scrollBehavior,
                title = {
                    Text(
                        color = MaterialTheme.colorScheme.inversePrimary,
                        text = "Tool Bars"
                    )
                }, navigationIcon = {
                    IconButton(
                        onClick = onBack
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_arrow_back_ios_new_24),
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
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                })
        },
        bottomBar = {
            BottomAppBar(
                scrollBehavior = bottomBarScrollBehavior,
                actions = {
                    HorizontalToolBar()
                },
                floatingActionButton = {
                    FloatingActionButton(
                        elevation = FloatingActionButtonDefaults.elevation(
                            defaultElevation = 8.dp,
                        ),
                        containerColor = MaterialTheme.colorScheme.background,
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_call_end_24),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            )
        }
    ) { paddingValue ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValue),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                    ) {
                    FilledTonalButton(
                        onClick = {
                            launchMediaPicker()
                        },
                        colors = ButtonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            contentColor = MaterialTheme.colorScheme.onBackground,
                            disabledContainerColor = MaterialTheme.colorScheme.onBackground,
                            disabledContentColor = MaterialTheme.colorScheme.onBackground
                        )
                    ) {
                        Icon(
                            painterResource(R.drawable.ic_add_24),
                            null
                        )
                        Text("Choose Photo")
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    TooltipBox(
                        positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
                        state = toolTipState1,
                        tooltip = {
                            PlainTooltip {
                                Text(text = "$receiverAccount")
                            }
                        }
                    ) {
                        IconButton(
                            onClick = {
                                scope.launch {
                                    tooltipViewModel.getAccountInfo()
                                    toolTipState1.show()
                                }
                            }
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_menu),
                                contentDescription = null
                            )
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun HorizontalToolBar() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            modifier = Modifier
                .height(60.dp),
            shape = RoundedCornerShape(32.dp),
            tonalElevation = 2.dp,
            shadowElevation = 8.dp,
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {

                IconButton(onClick = {}) {
                    Icon(
                        painterResource(id = R.drawable.ic_videocam_off_24),
                        contentDescription = null
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        painterResource(id = R.drawable.ic_mic_24),
                        contentDescription = null
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        painterResource(id = R.drawable.ic_front_hand_24),
                        contentDescription = null
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        painterResource(id = R.drawable.more_vert),
                        contentDescription = null
                    )
                }

            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun ScreenSingleMediaPreview() {
    BaseTheme {
        SingleMediaPicker()
    }
}