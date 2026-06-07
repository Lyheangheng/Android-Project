package com.android.basic.android.component.homework

import android.graphics.drawable.Icon
import androidx.annotation.DrawableRes
import androidx.compose.animation.core.TweenSpec
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicSecureTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.KeyboardActionHandler
import androidx.compose.foundation.text.input.TextFieldDecorator
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.foundation.text.input.insert
import androidx.compose.foundation.text.input.maxLength
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SecondaryTabRow
import androidx.compose.material3.SecureTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberBottomAppBarState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.offset
import androidx.compose.ui.unit.sp
import com.android.basic.android.R
import com.android.basic.android.ui.theme.BaseTheme
import kotlinx.coroutines.launch
import java.nio.file.WatchEvent
import kotlin.math.roundToInt
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenFloatingBottomBar1() {

    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())

    val bottomBarScrollBehavior = BottomAppBarDefaults.exitAlwaysScrollBehavior(rememberBottomAppBarState())



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
                .padding(paddingValue)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
            ) {
                items(100) { count ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Text(text = "Production Item $count : This is a scrollable row")
                    }
                    HorizontalDivider()
                }
            }
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
fun HorizontalToolBar(){
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
fun ScreenFloatingBottomBar1Preview() {
    BaseTheme {
        ScreenFloatingBottomBar1()
    }
}