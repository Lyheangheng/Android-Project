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
import com.android.basic.android.feature.profile.ScreenProfile
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
import kotlinx.serialization.Serializable

data object HomeScreenRoute
data object SnackBarScreenRoute
data object ScreenAlertDialogRoute
data object ScreenBadgeRoute
data object ScreenBottomSheetRoute
data object ScreenCardRoute
data object ScreenCarouselRoute
data object ScreenCheckBoxRoute
data object ScreenChipRoute
data object ScreenDatePickerRoute
data object ScreenDialogFullScreenRoute
data object ScreenIconButtonRoute
data object ScreenLoadingAndProgressIndicatorsRoute
data object ScreenNavigationBarRoute
data object ScreenNavigationDrawerRoute
data object ScreenRadioButtonRoute
data object ScreenSingleChoiceSegmentedButtonRoute
data object ScreenSliderRoute
data object ScreenSwitchRoute
data object ScreenTabsRoute
data object ScreenTextFieldsRoute
data object ScreenToolBarRoute
data object ScreenToolTipsRoute
data object ScreenTopAppBarRoute
data object ScreenFloatingBottomBarRoute
data object ScreenFloatingBottomBarNewRoute
data object ScreenSliderNewRoute

@Serializable
data class UserProfile(
    val id: Int,
)

@Composable
fun Navigation() {
    val backStack = remember { mutableStateListOf<Any>(HomeScreenRoute) }
    val onBack: () -> Unit = { backStack.removeLastOrNull() }
    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { key ->
            when (key) {
                is HomeScreenRoute -> NavEntry(key) {
                    HomeScreen(
                        onClickItem = { key ->
                            backStack.add(key)
                        },
                        onClickProfile = { id ->
                            backStack.add(UserProfile(id))
                        }
                    )
                }
                is UserProfile -> NavEntry(key) {
                    ScreenProfile(
                        onBack = onBack,
                        id = key.id
                    )
                }
                is ScreenAlertDialogRoute -> NavEntry(key) {
                    ScreenAlertDialog(
                        onBack = onBack
                    )
                }
                is ScreenBadgeRoute -> NavEntry(key) {
                    ScreenBadge(
                        onBack = onBack
                    )
                }
                is SnackBarScreenRoute -> NavEntry(key) {
                    ScreenSnackBar(
                        onBack = onBack
                    )
                }
                is ScreenBottomSheetRoute -> NavEntry(key) {
                    ScreenBottomSheet(
                        onBack = onBack
                    )
                }
                is ScreenCardRoute -> NavEntry(key){
                    ScreenCardAndHomeWork1(
                        onBack = onBack
                    )
                }
                is ScreenCarouselRoute -> NavEntry(key){
                    ScreenCarousel(
                        onBack = onBack
                    )
                }
                is ScreenCheckBoxRoute -> NavEntry(key){
                    ScreenCheckBox(
                        onBack = onBack
                    )
                }
                is ScreenChipRoute -> NavEntry(key){
                    ScreenChip(
                        onBack = onBack
                    )
                }
                is ScreenDatePickerRoute -> NavEntry(key){
                    ScreenDatePicker(
                        onBack = onBack
                    )
                }
                is ScreenDialogFullScreenRoute -> NavEntry(key){
                    ScreenDialogFullScreen(
                        onBack = onBack
                    )
                }
                is ScreenIconButtonRoute -> NavEntry(key){
                    ScreenIconButtons(
                        onBack = onBack
                    )
                }
                is ScreenNavigationBarRoute -> NavEntry(key){
                    ScreenNavigationBar(
                        onBack = onBack
                    )
                }
                is ScreenLoadingAndProgressIndicatorsRoute -> NavEntry(key){
                    ScreenLoadingAndProgressIndicators(
                        onBack = onBack
                    )
                }
                is ScreenNavigationDrawerRoute -> NavEntry(key){
                    ScreenNavigationDrawer(
                        { HomeScreen1(onBack)}, onBack
                    )
                }
                is ScreenRadioButtonRoute -> NavEntry(key){
                    ScreenRadioButton(
                        onBack = onBack
                    )
                }
                is ScreenSingleChoiceSegmentedButtonRoute -> NavEntry(key){
                    ScreenSegmentedButton(
                        onBack = onBack
                    )
                }
                is ScreenSliderRoute -> NavEntry(key){
                    ScreenSlider(
                        onBack = onBack
                    )
                }
                is ScreenSwitchRoute -> NavEntry(key){
                    ScreenSwitch(
                        onBack = onBack
                    )
                }
                is ScreenTabsRoute -> NavEntry(key){
                    ScreenTabs(
                        onBack = onBack
                    )
                }
                is ScreenTextFieldsRoute -> NavEntry(key){
                    ScreenTextFields(
                        onBack = onBack
                    )
                }
                is ScreenToolBarRoute -> NavEntry(key){
                    ScreenToolBar(
                        onBack = onBack
                    )
                }
                is ScreenToolTipsRoute -> NavEntry(key){
                    ScreenToolTips(
                        onBack = onBack
                    )
                }
                is ScreenTopAppBarRoute -> NavEntry(key){
                    ScreenTopAppBar(
                        onBack = onBack
                    )
                }
                is ScreenFloatingBottomBarRoute -> NavEntry(key){
                    ScreenFloatingBottomBar(
                        onBack = onBack
                    )
                }
                is ScreenFloatingBottomBarNewRoute -> NavEntry(key){
                    ScreenFloatingBottomBar1(
                        onBack = onBack
                    )
                }
                is ScreenSliderNewRoute -> NavEntry(key){
                    ScreenSliderHomework(
                        onBack = onBack
                    )
                }
                else -> NavEntry(Unit) { Text(text = "Unknown Route") }
            }
        }
    )
}
