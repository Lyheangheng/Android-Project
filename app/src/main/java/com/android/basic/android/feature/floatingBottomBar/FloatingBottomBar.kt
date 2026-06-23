package com.android.basic.android.feature.floatingBottomBar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberBottomAppBarState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.basic.android.R
import com.android.basic.android.ui.theme.BaseTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenFloatingBottomBar(onBack:() -> Unit = {}) {

val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    val bottomBarScrollBehavior = BottomAppBarDefaults.exitAlwaysScrollBehavior(rememberBottomAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
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
                containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f),
                scrollBehavior = bottomBarScrollBehavior,
                contentPadding = PaddingValues(12.dp),
                actions = {
                    CustomBottomBar()
                },
                floatingActionButton = {
                    FloatingActionButton(
                        containerColor = MaterialTheme.colorScheme.background,
                        onClick = {}
                    ) {
                        Icon(painterResource(R.drawable.baseline_home_24)
                            , null,
                            tint = MaterialTheme.colorScheme.primary)
                    }
                }
            )
        }
    ) { paddingValue ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValue),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                items(100){
                    Row(modifier =  Modifier
                        .fillMaxWidth()
                    ) {
                        Text(text = "Row Column Horizontal arrangement alignment")
                    }
                    HorizontalDivider()
                }
            }

    }
}

@Composable
fun CustomBottomBar(){
    Surface(
        shape = RoundedCornerShape(50),
        shadowElevation = 8.dp,
        modifier = Modifier.wrapContentWidth()
    ) {
        Row(
            modifier = Modifier.padding(
                horizontal = 12.dp,
                vertical = 8.dp
            ),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            IconButton(onClick = {}) {
                Icon(painterResource(R.drawable.baseline_home_24), null)
            }

            IconButton(onClick = {}) {
                Icon(painterResource(R.drawable.baseline_home_24), null)
            }

            IconButton(onClick = {}) {
                Icon(painterResource(R.drawable.baseline_home_24), null)
            }

            IconButton(onClick = {}) {
                Icon(painterResource(R.drawable.baseline_home_24), null)
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun ScreenFloatingBottomBarPreview() {
    BaseTheme {
        ScreenFloatingBottomBar()
    }
}