package com.android.basic.android.model

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BadgeViewModel: ViewModel() {
    private var _message: MutableStateFlow<BaseUiState<String>> = MutableStateFlow (BaseUiState.None)
    val messageUiState = _message.asStateFlow()


    fun requestData() {
        viewModelScope.launch {
            _message.emit(BaseUiState.Loading)
            delay(3000)
            _message.emit(BaseUiState.Success("This is success message"))
        }
    }
}

