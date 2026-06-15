package com.android.basic.android.model

sealed class BaseUiState<out T> {
    data object None: BaseUiState<Nothing>()
    data object Loading : BaseUiState<Nothing>()
    data class Success<out T>(val data: T) : BaseUiState<T>()
    data class Error(val message: String) : BaseUiState<Nothing>()
    data class ErrorWithException(val exception: Exception) : BaseUiState<Nothing>()
}

/**
 * Global loading state
 * 1. base ui state
 * 2. loading util(singleton)
 * 3. Use view model
 * 4. use loading content in screen
 * 5. loading UI Content
 */