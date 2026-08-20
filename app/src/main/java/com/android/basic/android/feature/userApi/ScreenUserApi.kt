package com.android.basic.android.feature.userApi

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberBottomAppBarState
import androidx.compose.material3.rememberModalBottomSheetState
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.android.basic.android.R
import com.android.basic.android.model.BaseUiState
import com.android.basic.android.model.responses.UserApiResponse
import com.android.basic.android.util.LoadingUtil
import com.android.basic.android.util.ValidEmail
import kotlinx.serialization.Serializable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenUserApi(
    onBack: () -> Unit = {}, userApiVM: UserApiVM = viewModel()
) {


    val userUiState by userApiVM.userListUiState.collectAsStateWithLifecycle()
    val createUserState by userApiVM.createUserUiState.collectAsStateWithLifecycle()


    val scrollBehavior =
        TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())

    val bottomBarScrollBehavior =
        BottomAppBarDefaults.exitAlwaysScrollBehavior(rememberBottomAppBarState())


//    val scope = rememberCoroutineScope()
//    val toolTipState = rememberTooltipState()
//    val toolTipState1 = rememberTooltipState()
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

//    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }

    var userToEdit by remember { mutableStateOf<UserApiResponse?>(null) }


    LaunchedEffect(Unit) {
        userApiVM.getUserList()
    }

    LaunchedEffect(userUiState) {
        when (val state = userUiState) {
            is BaseUiState.Loading -> LoadingUtil.showLoading()
            is BaseUiState.Success -> {
                LoadingUtil.hideLoading()
            }

            is BaseUiState.Error -> {
                LoadingUtil.hideLoading()
                println(state.message)
            }

            else -> {}
        }
    }

    LaunchedEffect(createUserState) {
        when (val state = createUserState) {
            is BaseUiState.Loading -> LoadingUtil.showLoading()
            is BaseUiState.Success -> {
                LoadingUtil.hideLoading()
//                userApiVM.getUserList()
                showBottomSheet = false
                userApiVM.resetCreateState()
            }

            is BaseUiState.Error -> {
                LoadingUtil.hideLoading()
                println(state.message)
            }

            else -> {}
        }
    }

    fun createUser() {
        userApiVM.createUser(
            name = name, email = email
        )
    }

    fun updateUser() {
        userApiVM.updateUser(userToEdit!!.id, name, email)
    }

    Scaffold(
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection)
            .nestedScroll(bottomBarScrollBehavior.nestedScrollConnection), topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f),
                ), scrollBehavior = scrollBehavior, title = {
                    Text(
                        color = MaterialTheme.colorScheme.inversePrimary, text = "Tool Bars"
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
            BottomAppBar(actions = {}, floatingActionButton = {
                FloatingActionButton(
                    containerColor = MaterialTheme.colorScheme.primary,
                    onClick = {
                        userToEdit = null
                        name = ""
                        email = ""
                        showBottomSheet = true
                    }
                ) {
                    Icon(
                        painterResource(R.drawable.ic_add_24), null
                    )
                }
            })
        }

    ) { paddingValue ->
        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = {
                    showBottomSheet = false
                }) {
                Column(
                    modifier = Modifier.padding(35.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        TextField(value = name, onValueChange = {
                            name = it
                        }, label = {
                            Text("name")
                        })
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        TextField(
                            value = email,
                            onValueChange = {
                                email = it
                            },
                            label = {
                                Text("email")
                            },
                            isError = email.isEmpty() || !ValidEmail.isValidEmail(email)
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 35.dp)
                ) {
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            if (userToEdit == null) {
                                createUser()
                            } else {
                                updateUser()
                                showBottomSheet = false
                            }
                        }
                    ) {
                        Text(
                            if (userToEdit == null) "Create" else "Save Changes"
                        )
                    }
                }
            }
        }
        when (val state = userUiState) {
            is BaseUiState.Success -> {
                LazyColumn(
                    contentPadding = paddingValue
                ) {
                    items(state.data.size) { index ->
                        UserItems(
                            item = state.data[index],
                            onDeleteClick = { id ->
                                userApiVM.deleteUser(id)
                            },
                            onEditClick = { user ->
                                userToEdit = user
                                name = user.name ?: ""
                                email = user.email ?: ""
                                showBottomSheet = true
                            }
                        )
                    }
                }
            }

            else -> {}
        }

        @Composable
        fun HorizontalToolBar() {
            Box(
                modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                Surface(
                    modifier = Modifier.height(60.dp),
                    shape = RoundedCornerShape(32.dp),
                    tonalElevation = 2.dp,
                    shadowElevation = 8.dp,
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 16.dp),
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
    }
}


@Composable
fun UserItems(
    item: UserApiResponse,
    onDeleteClick: (String) -> Unit,
    onEditClick: (UserApiResponse) -> Unit
) {

    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                val initial = item.name?.firstOrNull()?.uppercase() ?: "?"
                Text(initial)
            }
            Spacer(modifier = Modifier.width(25.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(text = item.name ?: "", style = MaterialTheme.typography.bodyLarge)
                Text(text = item.email ?: "", style = MaterialTheme.typography.bodyMedium)
            }
//            Spacer(modifier = Modifier.weight(1f))
            IconButton(
                onClick = {
                    expanded = true
                }
            ) {
                Icon(
                    painter = painterResource(R.drawable.more_vert),
                    null
                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = {
                        expanded = false
                    }
                ) {
                    DropdownMenuItem(
                        onClick = {
                            onEditClick(item)
                            expanded = false
                        },
                        text = {
                            Text(
                                text = "Edit",
                                color = Color.Blue
                            )
                        }
                    )
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = "Delete",
                                color = MaterialTheme.colorScheme.error
                            )
                        },
                        onClick = {
                            onDeleteClick(item.id)
                            expanded = false
                        }
                    )
                }
            }
        }
        Spacer(Modifier.height(5.dp))
        HorizontalDivider()
    }
}


@Preview(showBackground = false)
@Composable
fun ScreenUserApiPreview() {
    ScreenUserApi()
}