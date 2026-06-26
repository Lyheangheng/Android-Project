package com.android.basic.android.feature.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.basic.android.model.BaseUiState
import com.android.basic.android.model.UserModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserVm(
    private val userRepository: UserProfileRepository = UserProfileRepository()
): ViewModel() {

    private var _userUiState : MutableStateFlow<BaseUiState<UserModel?>> =
        MutableStateFlow(BaseUiState.Loading)

    val userUiState = _userUiState.asStateFlow()


    fun getUser(
        id : Int
    ){
        viewModelScope.launch {
            _userUiState.emit(BaseUiState.Loading)
            userRepository.getUserProfile(id).collect { userData ->
                if(userData != null){
                    _userUiState.emit(BaseUiState.Success(userData))
                }else{
                    _userUiState.emit(BaseUiState.Error("User not found"))
                }
            }
        }
    }
}