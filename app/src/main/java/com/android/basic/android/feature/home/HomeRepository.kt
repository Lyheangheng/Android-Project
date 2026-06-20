package com.android.basic.android.feature.home

import com.android.basic.android.model.ComponentModel
import com.android.basic.android.navigation.SnackBarScreen
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HomeRepository {

    val component = listOf<ComponentModel>(
        ComponentModel(
            id = 1,
            title = "Snack Bar Screen",
            description = "Click to go to Snack bar screen ",
            route = SnackBarScreen
        )
    )

    suspend fun getComponentListFromHomeRepo() : Flow<List<ComponentModel>> {
        delay(2000)
        return flow{
            emit(component)
        }
    }
}