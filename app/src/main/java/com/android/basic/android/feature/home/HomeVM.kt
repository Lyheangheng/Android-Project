package com.android.basic.android.feature.home


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.basic.android.model.BaseUiState
import com.android.basic.android.model.ComponentModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeVM(
    private val homeRepository: HomeRepository = HomeRepository()
) : ViewModel() {

private var _componentList : MutableStateFlow<BaseUiState<List<ComponentModel>>>
= MutableStateFlow(BaseUiState.Loading)

    val componentList = _componentList.asStateFlow()

    fun getComponentList(){
        viewModelScope.launch {
            _componentList.emit(BaseUiState.Loading)
            homeRepository.getComponentListFromHomeRepo().collect {
                _componentList.emit(BaseUiState.Success(it))
            }
        }
    }

    init {
        getComponentList()
    }

}