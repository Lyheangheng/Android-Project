package com.android.basic.android.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.basic.android.repository.test.Product
import com.android.basic.android.repository.test.ProductRepository
import com.android.basic.android.repository.test.ProductRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import com.android.basic.android.repository.test.Result
import kotlinx.coroutines.flow.update


data class ProductListUiState(
    val products: List<Product> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val searchQuery: String = ""
) {
    val filteredProducts: List<Product>
        get() = if (searchQuery.isBlank()) products
        else products.filter { it.name.contains(searchQuery, ignoreCase = true) }
}

class ProductListViewModel(
    private val repository: ProductRepository = ProductRepositoryImpl()
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProductListUiState())
    val uiState: StateFlow<ProductListUiState> = _uiState.asStateFlow()

    init {
        loadProducts()
    }

    fun loadProducts() {
        viewModelScope.launch {
            repository.getProducts().collect { result ->
                when (result) {
                    is Result.Loading -> _uiState.update {
                        it.copy(isLoading = true, errorMessage = null)
                    }
                    is Result.Success -> _uiState.update {
                        it.copy(isLoading = false, products = result.data)
                    }
                    is Result.Error -> _uiState.update {
                        it.copy(isLoading = false, errorMessage = result.message)
                    }
                }
            }
        }
    }

    fun onSearchQueryChange(query: String) {
        _uiState.update { it.copy(searchQuery = query) }
    }

    fun dismissError() {
        _uiState.update { it.copy(errorMessage = null) }
    }
}