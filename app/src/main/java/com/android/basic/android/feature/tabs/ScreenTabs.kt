package com.android.basic.android.feature.tabs

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.TweenSpec
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SecondaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.android.basic.android.R
import com.android.basic.android.ui.theme.BaseTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenTabs(onBack: () -> Unit = {}) {

    var selectedTabIndex by remember { mutableIntStateOf(TabIndex.Overview.index) }


    val tabsItem = listOf<TabItem>(
        TabItem("Overview", R.drawable.ic_menu),
        TabItem("Inspect", R.drawable.ic_settings_24)
    )

    val pagerState = rememberPagerState(pageCount = { tabsItem.size })
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.outline
                ),
                title = {
                    Text(
                        text = "Tabs Component"
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
                        )
                    }
                })
        },
    ) { paddingValue ->

        Column(
            modifier = Modifier.padding(paddingValue)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            SecondaryTabRow(
                modifier = Modifier,
                selectedTabIndex = pagerState.currentPage,
            ) {
                TabsHeader(
                    tabsItem = tabsItem,
                    selectedTabIndex = pagerState.currentPage,
                    onTabSelected = { index ->
                        scope.launch {
                            pagerState.animateScrollToPage(
                                page = index,
                                animationSpec = TweenSpec(durationMillis = 500)
                            )
                        }
                    }
                )
            }

            HorizontalPager(
                state = pagerState,
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.Top
            ) { pageIndex ->
                when (pageIndex) {
                    TabIndex.Overview.index -> OverviewContent(modifier = Modifier.weight(1f))
                    TabIndex.Inspect.index -> InspectContent(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

data class TabItem(val label: String, @DrawableRes val icon: Int)


@Composable
fun TabsHeader(tabsItem: List<TabItem>, selectedTabIndex: Int, onTabSelected: (Int) -> Unit) {

    for (index in tabsItem.indices) {
        Tab(
            selected = selectedTabIndex == index,
            onClick = {
                onTabSelected(index)
            },
            text = {
                Text(text = tabsItem[index].label)
            },
            icon = {
                Icon(
                    painter = painterResource(tabsItem[index].icon),
                    contentDescription = null
                )
            }
        )
    }


}

@Composable
fun OverviewContent(modifier: Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Overview Content")
    }
}

@Composable
fun InspectContent(modifier: Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Inspect Content")
    }
}

enum class TabIndex(val index: Int) {
    Overview(0),
    Inspect(1)
}


@Preview(showBackground = false)
@Composable
fun ScreenTabsPreview() {
    BaseTheme {
        ScreenTabs()
    }
}