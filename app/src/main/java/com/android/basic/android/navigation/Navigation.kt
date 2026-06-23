package com.android.basic.android.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.android.basic.android.feature.radioButton.ScreenRadioButton
import com.android.basic.android.feature.iconButton.ScreenIconButtons
import com.android.basic.android.feature.datePicker.ScreenDatePicker
import com.android.basic.android.feature.chip.ScreenChip
import com.android.basic.android.feature.alertdialog.ScreenAlertDialog
import com.android.basic.android.feature.badge.ScreenBadge
import com.android.basic.android.feature.bottomSheet.ScreenBottomSheet
import com.android.basic.android.feature.card.ScreenCardAndHomeWork1
import com.android.basic.android.feature.carousel.ScreenCarousel
import com.android.basic.android.feature.checkBox.ScreenCheckBox
import com.android.basic.android.feature.dialogFullScreen.ScreenDialogFullScreen
import com.android.basic.android.feature.floatingBottomBar.ScreenFloatingBottomBar
import com.android.basic.android.feature.floatingBottomBar.ScreenFloatingBottomBar1
import com.android.basic.android.feature.home.HomeScreen
import com.android.basic.android.feature.loadingAndProgress.ScreenLoadingAndProgressIndicators
import com.android.basic.android.feature.navigationBar.ScreenNavigationBar
import com.android.basic.android.feature.navigationDrawer.HomeScreen1
import com.android.basic.android.feature.navigationDrawer.ScreenNavigationDrawer
import com.android.basic.android.feature.singleChoiceSegmentedButton.ScreenSegmentedButton
import com.android.basic.android.feature.slider.ScreenSlider
import com.android.basic.android.feature.slider.ScreenSliderHomework
import com.android.basic.android.feature.snackBar.ScreenSnackBar
import com.android.basic.android.feature.switchScreen.ScreenSwitch
import com.android.basic.android.feature.tabs.ScreenTabs
import com.android.basic.android.feature.textFields.ScreenTextFields
import com.android.basic.android.feature.toolBar.ScreenToolBar
import com.android.basic.android.feature.toolTips.ScreenToolTips
import com.android.basic.android.feature.topAppBar.ScreenTopAppBar

data object HomeScreen
data object SnackBarScreen
data object ScreenAlertDialog
data object ScreenBadge
data object ScreenBottomSheet
data object ScreenCard
data object ScreenCarousel
data object ScreenCheckBox
data object ScreenChip
data object ScreenDatePicker
data object ScreenDialogFullScreen
data object ScreenIconButton
data object ScreenLoadingAndProgressIndicators
data object ScreenNavigationBar
data object ScreenNavigationDrawer
data object ScreenRadioButton
data object ScreenSingleChoiceSegmentedButton
data object ScreenSlider
data object ScreenSwitch
data object ScreenTabs
data object ScreenTextFields
data object ScreenToolBar
data object ScreenToolTips
data object ScreenTopAppBar
data object ScreenFloatingBottomBar
data object ScreenFloatingBottomBarNew
data object ScreenSliderNew

@Composable
fun Navigation() {
    val backStack = remember { mutableStateListOf<Any>(HomeScreen) }
    val onBack: () -> Unit = { backStack.removeLastOrNull() }
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
                is ScreenAlertDialog -> NavEntry(key) {
                    ScreenAlertDialog(
                        onBack = onBack
                    )
                }
                is ScreenBadge -> NavEntry(key) {
                    ScreenBadge(
                        onBack = onBack
                    )
                }
                is SnackBarScreen -> NavEntry(key) {
                    ScreenSnackBar(
                        onBack = onBack
                    )
                }
                is ScreenBottomSheet -> NavEntry(key) {
                    ScreenBottomSheet(
                        onBack = onBack
                    )
                }
                is ScreenCard -> NavEntry(key){
                    ScreenCardAndHomeWork1(
                        onBack = onBack
                    )
                }
                is ScreenCarousel -> NavEntry(key){
                    ScreenCarousel(
                        onBack = onBack
                    )
                }
                is ScreenCheckBox -> NavEntry(key){
                    ScreenCheckBox(
                        onBack = onBack
                    )
                }
                is ScreenChip -> NavEntry(key){
                    ScreenChip(
                        onBack = onBack
                    )
                }
                is ScreenDatePicker -> NavEntry(key){
                    ScreenDatePicker(
                        onBack = onBack
                    )
                }
                is ScreenDialogFullScreen -> NavEntry(key){
                    ScreenDialogFullScreen(
                        onBack = onBack
                    )
                }
                is ScreenIconButton -> NavEntry(key){
                    ScreenIconButtons(
                        onBack = onBack
                    )
                }
                is ScreenNavigationBar -> NavEntry(key){
                    ScreenNavigationBar(
                        onBack = onBack
                    )
                }
                is ScreenLoadingAndProgressIndicators -> NavEntry(key){
                    ScreenLoadingAndProgressIndicators(
                        onBack = onBack
                    )
                }
                is ScreenNavigationDrawer -> NavEntry(key){
                    ScreenNavigationDrawer(
                        { HomeScreen1(onBack)}, onBack
                    )
                }
                is ScreenRadioButton -> NavEntry(key){
                    ScreenRadioButton(
                        onBack = onBack
                    )
                }
                is ScreenSingleChoiceSegmentedButton -> NavEntry(key){
                    ScreenSegmentedButton(
                        onBack = onBack
                    )
                }
                is ScreenSlider -> NavEntry(key){
                    ScreenSlider(
                        onBack = onBack
                    )
                }
                is ScreenSwitch -> NavEntry(key){
                    ScreenSwitch(
                        onBack = onBack
                    )
                }
                is ScreenTabs -> NavEntry(key){
                    ScreenTabs(
                        onBack = onBack
                    )
                }
                is ScreenTextFields -> NavEntry(key){
                    ScreenTextFields(
                        onBack = onBack
                    )
                }
                is ScreenToolBar -> NavEntry(key){
                    ScreenToolBar(
                        onBack = onBack
                    )
                }
                is ScreenToolTips -> NavEntry(key){
                    ScreenToolTips(
                        onBack = onBack
                    )
                }
                is ScreenTopAppBar -> NavEntry(key){
                    ScreenTopAppBar(
                        onBack = onBack
                    )
                }
                is ScreenFloatingBottomBar -> NavEntry(key){
                    ScreenFloatingBottomBar(
                        onBack = onBack
                    )
                }
                is ScreenFloatingBottomBarNew -> NavEntry(key){
                    ScreenFloatingBottomBar1(
                        onBack = onBack
                    )
                }
                is ScreenSliderNew -> NavEntry(key){
                    ScreenSliderHomework(
                        onBack = onBack
                    )
                }
                else -> NavEntry(Unit) { Text(text = "Unknown Route") }
            }
        }
    )
}