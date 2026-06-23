package com.android.basic.android.feature.toolTips

import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.android.basic.android.R
import com.android.basic.android.TooltipViewModel
import com.android.basic.android.model.ReceiverAccountModel
import com.android.basic.android.ui.theme.BaseTheme
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenToolTips(onBack : () -> Unit = {}) {


    val scrollBehavior =
        TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())

    val bottomBarScrollBehavior =
        BottomAppBarDefaults.exitAlwaysScrollBehavior(rememberBottomAppBarState())

    val scope = rememberCoroutineScope()
    val toolTipState = rememberTooltipState()
    val toolTipState1 = rememberTooltipState()



    val tooltipViewModel: TooltipViewModel = TooltipViewModel()
    val accountInfo by tooltipViewModel.receiverAccount.collectAsStateWithLifecycle()
    var receiverAccount by remember { mutableStateOf<ReceiverAccountModel?>(null) }


    LaunchedEffect(accountInfo) {

        accountInfo.let{
            if(it != null){
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
                        PlainTooltip{
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
                    ){
                        Icon(
                            painter = painterResource(R.drawable.ic_menu),
                            contentDescription = null
                        )
                    }
                }
//                TooltipBox(
//                    positionProvider = TooltipDefaults.rememberRichTooltipPositionProvider(),
//                    state = toolTipState,
//                    tooltip = {
//                        RichTooltip(
//                            title = {
//                                Text(text = "title")
//                            },
//                            action = {
//                                TextButton(
//                                    shape = MaterialTheme.shapes.small,
//                                    onClick = {
//                                        scope.launch {
//                                            toolTipState.dismiss()
//                                        }
//                                    }
//                                ){
//                                    Text(text = "Dismiss")
//                                }
//                            },
//                            shape = RoundedCornerShape(8.dp),
//                            tonalElevation = 2.dp,
//                            shadowElevation = 8.dp,
//                        ) {
//                            Text(text = """
//                            A RichTooltip displays a tooltip with a title and dismiss action.
//                            When activated, either by a long-press or hovering over the TooltipBox content with the mouse pointer, the tooltip is displayed for about one second. You can dismiss this tooltip by either tapping elsewhere on the screen or using the dismiss action button.
//                            When the dismiss action executes, the system launches a coroutine to call tooltipState.dismiss. This verifies the action execution isn't blocked while the tooltip is displayed.
//                            onClick = coroutineScope.launch { tooltipState.show() } } launches a coroutine to manually show the tooltip using tooltipState.show.
//                            The action parameter allows for the adding of interactive elements to a tooltip, such as a button.
//                            The caretSize parameter modifies the size of the tooltip's arrow.
//                        """.trimIndent())
//                        }
//                    }
//                ) {
//                    IconButton(
//                        onClick = {
//                            scope.launch {
//                                toolTipState.show()
//                            }
//                        }
//                    ) {
//                        Icon(
//                            painter = painterResource(R.drawable.ic_mic_24),
//                            contentDescription = null,
//                        )
//                    }
//                }
            }



            // Floating Vertical tool bar
            FloatingVerticalToolbar()
        }
    }
}

@Composable
fun FloatingVerticalToolbar() {

    var offsetX by remember { mutableFloatStateOf(0f) }
    var offsetY by remember { mutableFloatStateOf(0f) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.BottomStart
    ) {

        Surface(
            modifier = Modifier
                .offset {
                    IntOffset(
                        offsetX.roundToInt(),
                        offsetY.roundToInt()
                    )
                }
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consume()
                        offsetX += dragAmount.x
                        offsetY += dragAmount.y
                    }
                }
                .width(65.dp),
            shape = RoundedCornerShape(32.dp),
            shadowElevation = 8.dp,
            tonalElevation = 2.dp
        ) {
            Column(
                modifier = Modifier.padding(vertical = 12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                IconButton(onClick = {}) {
                    Icon(
                        painterResource(id = R.drawable.ic_undo_24),
                        contentDescription = null
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        painterResource(id = R.drawable.ic_redo_24),
                        contentDescription = null
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        painterResource(id = R.drawable.ic_add_24),
                        contentDescription = null
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        painterResource(id = R.drawable.ic_text_format_24),
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
fun ScreenToolTipsPreview() {
    BaseTheme {
        ScreenToolTips()
    }
}