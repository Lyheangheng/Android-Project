package com.android.basic.android.feature.userApi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.basic.android.dataModel.UserResponse
import com.android.basic.android.model.BaseUiState
import com.android.basic.android.model.request.UserApiRequest
import com.android.basic.android.model.responses.UserApiResponse
import com.android.basic.android.network.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserApiVM : ViewModel() {

    private val _userListUiState: MutableStateFlow<BaseUiState<List<UserResponse>>> =
        MutableStateFlow(
            BaseUiState.None
        )
    private val _createUserUiState: MutableStateFlow<BaseUiState<UserApiResponse>> =
        MutableStateFlow(
            BaseUiState.None
        )
    val createUserUiState = _createUserUiState.asStateFlow()

    val userListUiState = _userListUiState.asStateFlow()

    fun getUserList() {
        viewModelScope.launch {
            _userListUiState.value = BaseUiState.Loading
            try {
                val response = RetrofitClient.instance.getUsers()
                if (response.isSuccessful) {
                    _userListUiState.value = BaseUiState.Success(response.body() ?: emptyList())
                } else {
                    _userListUiState.value = BaseUiState.Error(message = response.message())
                }
            } catch (e: Exception) {
                e.printStackTrace()
                _userListUiState.value = BaseUiState.Error(e.message ?: "Unknown Error")
            }
        }
    }


    fun createUser(name: String, email: String) {
        viewModelScope.launch {
            _createUserUiState.value = BaseUiState.Loading
            try {
                val body = UserApiRequest(name, email)
                val response = RetrofitClient.instance.createUser(body)
                if (response.isSuccessful) {
                    val newUserApi = response.body()!!

                    // 1. Create a UserResponse object from the API response
                    val newUser = UserResponse(
                        id = newUserApi.id,
                        name = newUserApi.name,
                        email = newUserApi.email
                    )

                    // 2. Get the current list and add the new user to it
                    val currentList =
                        (_userListUiState.value as? BaseUiState.Success)?.data ?: emptyList()
                    _userListUiState.value = BaseUiState.Success(listOf(newUser) + currentList)

                    // 3. Mark the creation as successful
                    _createUserUiState.emit(BaseUiState.Success(newUserApi))
                } else {
                    _createUserUiState.emit(BaseUiState.Error(message = "Unknown Errors"))
                }
            } catch (e: Exception) {
                e.printStackTrace()
                _createUserUiState.emit(BaseUiState.ErrorWithException(exception = Exception("Unknown Errors")))
            }
        }
    }

    fun deleteUser(userId: Int) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.instance.deleteUser(userId)
                if (response.isSuccessful) {
                    val currentList =
                        (_userListUiState.value as? BaseUiState.Success)?.data ?: emptyList()
                    val updatedList = currentList.filter { it.id != userId }
                    _userListUiState.emit(BaseUiState.Success(updatedList))
                } else {
                    _userListUiState.emit(BaseUiState.Error(message = "Can't delete User"))
                }
            } catch (e: Exception) {
                e.printStackTrace()
                _userListUiState.emit(BaseUiState.ErrorWithException(exception = Exception()))
            }
        }
    }

    fun updateUser(id: Int, name: String, email: String) {
        viewModelScope.launch {
            try {
                val body = UserApiRequest(name, email)
                val response = RetrofitClient.instance.updateUser(id, body)

                if (response.isSuccessful) {
                    val updatedUserApi = response.body()!!

                    val currentList =
                        (_userListUiState.value as? BaseUiState.Success)?.data ?: emptyList()
                    val updatedList = currentList.map {
                        if (it.id == id) UserResponse(
                            id,
                            email = updatedUserApi.email,
                            name = updatedUserApi.name
                        ) else it
                    }
                    _userListUiState.value = BaseUiState.Success(updatedList)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun resetCreateState() {
        _createUserUiState.value = BaseUiState.None
    }

}