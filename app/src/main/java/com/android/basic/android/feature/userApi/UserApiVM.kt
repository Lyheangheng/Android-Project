package com.android.basic.android.feature.userApi

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.basic.android.dataModel.UserResponse
import com.android.basic.android.model.BaseUiState
import com.android.basic.android.network.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserApiVM : ViewModel() {

    private val _userListUiState: MutableStateFlow<BaseUiState<List<UserResponse>>> =
        MutableStateFlow(
            BaseUiState.None
        )

    val userListUiState = _userListUiState.asStateFlow()

    fun getUserList() {
        viewModelScope.launch {
            _userListUiState.value = BaseUiState.Loading
            try {
                val response = RetrofitClient.instance.getUsers()
                if (response.isSuccessful) {
                    _userListUiState.value =
                        BaseUiState.Success(data = response.body() ?: emptyList())
                } else {
                    _userListUiState.value = BaseUiState.Error(message = response.message())
                }
            } catch (e: Exception) {
                e.printStackTrace()
                _userListUiState.value = BaseUiState.Error(e.message ?: "Unknown Error")
            }
        }
    }

    init {
        getUserList()
    }

}