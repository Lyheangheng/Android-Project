package com.android.basic.android.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.android.basic.android.feature.home.HomeScreen
import com.android.basic.android.feature.snackBar.ScreenSnackBar

data object HomeScreen
data object SnackBarScreen

@Composable
fun Navigation() {
    val backStack = remember { mutableStateListOf<Any>(HomeScreen) }
    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { key ->
            when (key) {
                is HomeScreen -> NavEntry(key) {
                    HomeScreen(
                        onClickItem = { key ->
                            backStack.add(key)
                        }
                    )
                }
                is SnackBarScreen -> NavEntry(key) {
                    ScreenSnackBar(
                        onBack = {
                            backStack.removeLastOrNull()
                        }
                    )
                }
                else -> NavEntry(Unit) { Text(text = "Unknown Route") }
            }
        }
    )
}