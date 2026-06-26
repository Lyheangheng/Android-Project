package com.android.basic.android.feature.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.android.basic.android.R
import com.android.basic.android.model.BaseUiState
import com.android.basic.android.util.LoadingUtil

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenProfile(
    id : Int,
    onBack : () -> Unit = {},
    userVm : UserVm = UserVm()
){

    val userUiState by userVm.userUiState.collectAsStateWithLifecycle()


    LaunchedEffect(userUiState) {
        when(val state = userUiState){
            is BaseUiState.Loading -> LoadingUtil.showLoading()
            is BaseUiState.Error -> {
                LoadingUtil.hideLoading()
                println("=====> ${state.message}")
            }
            is BaseUiState.Success -> {
                LoadingUtil.hideLoading()
                println("=====> ${state.data}")
            }
            else -> LoadingUtil.hideLoading()
        }
    }

    LaunchedEffect(Unit) {
        userVm.getUser(id)
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = {
                            onBack()
                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_arrow_back_ios_new_24),
                            contentDescription = null
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    navigationIconContentColor = MaterialTheme.colorScheme.background,
                    titleContentColor = MaterialTheme.colorScheme.background,
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                title = { Text("Profile Screen") }
            )
        }
    ) { paddingValues ->

        when(val state = userUiState){
            is BaseUiState.Success -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                )
                {
                    Text(text = "UserId: ${state.data?.id}")
                    Text(text = "UserAge: ${state.data?.age}")
                    Text(text = "UserName: ${state.data?.name}")
                    Text(text = "UserEmail: ${state.data?.email}")
                }
            }
            else -> {}
        }

    }

}