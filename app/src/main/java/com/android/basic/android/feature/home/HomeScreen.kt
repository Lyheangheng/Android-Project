package com.android.basic.android.feature.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.android.basic.android.R
import com.android.basic.android.model.BaseUiState
import com.android.basic.android.ui.theme.BaseTheme
import com.android.basic.android.util.LoadingUtil

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    homeVM: HomeVM = HomeVM(),
    onClickItem: (Any) -> Unit,
) {

    val componentList by homeVM.componentList.collectAsStateWithLifecycle()


    LaunchedEffect(componentList) {
        when (val state = componentList) {
            is BaseUiState.Loading, BaseUiState.None -> LoadingUtil.showLoading()
            is BaseUiState.Success -> LoadingUtil.hideLoading()
            is BaseUiState.Error -> LoadingUtil.hideLoading()
            else -> LoadingUtil.hideLoading()
        }
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back_24),
                            contentDescription = null
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    navigationIconContentColor = MaterialTheme.colorScheme.background,
                    titleContentColor = MaterialTheme.colorScheme.background,
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                title = { Text("Home Screen") }
            )
        }
    ) { paddingValues ->

        when (val state = componentList) {
            is BaseUiState.Success -> {
                LazyColumn(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize(),
                ) {
                    items(
                        count = state.data.size,
                        key = { index -> state.data[index].id })
                    { index ->
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 8.dp)
                                .clickable(
                                    onClick = { onClickItem(state.data[index].route) }
                                ),
                        ) {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(36.dp),
                                text = state.data[index].title
                            )
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(36.dp),
                                text = state.data[index].description
                            )
                            HorizontalDivider()
                        }
                    }
                }
            }

            else -> {}
        }

    }

}

@Preview
@Composable
fun HomeScreenPreview() {
    BaseTheme {
        HomeScreen(
            onClickItem = {}
        )
    }
}