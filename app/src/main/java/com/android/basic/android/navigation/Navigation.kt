package com.android.basic.android.navigation

import android.os.Build
import androidx.annotation.RequiresApi
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
import com.android.basic.android.feature.notification.ScreenNotificationPermisson
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
import com.android.basic.android.feature.userApi.ScreenUserApi
import kotlinx.serialization.Serializable


@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun Navigation() {
    val backStack = remember { mutableStateListOf<Any>(NavigationKey.HomeScreenRoute) }
    val onBack: () -> Unit = { backStack.removeLastOrNull() }
    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { key ->
            when (key) {
                is NavigationKey.HomeScreenRoute -> NavEntry(key) {
                    HomeScreen(
                        onClickItem = { key ->
                            backStack.add(key)
                        },
                        onClickProfile = { id ->
                            backStack.add(NavigationKey.UserProfile(id))
                        }
                    )
                }

                is NavigationKey.UserApiScreenRoute -> NavEntry(key) {
                    ScreenUserApi(
                        onBack = { backStack.removeLastOrNull() }
                    )
                }

                is NavigationKey.UserProfile -> NavEntry(key) {
                    ScreenProfile(
                        onBack = onBack,
                        id = key.id
                    )
                }

                is NavigationKey.ScreenAlertDialogRoute -> NavEntry(key) {
                    ScreenAlertDialog(
                        onBack = onBack
                    )
                }

                is NavigationKey.ScreenBadgeRoute -> NavEntry(key) {
                    ScreenBadge(
                        onBack = onBack
                    )
                }

                is NavigationKey.SnackBarScreenRoute -> NavEntry(key) {
                    ScreenSnackBar(
                        onBack = onBack
                    )
                }

                is NavigationKey.ScreenBottomSheetRoute -> NavEntry(key) {
                    ScreenBottomSheet(
                        onBack = onBack
                    )
                }

                is NavigationKey.ScreenCardRoute -> NavEntry(key) {
                    ScreenCardAndHomeWork1(
                        onBack = onBack
                    )
                }

                is NavigationKey.ScreenCarouselRoute -> NavEntry(key) {
                    ScreenCarousel(
                        onBack = onBack
                    )
                }

                is NavigationKey.ScreenCheckBoxRoute -> NavEntry(key) {
                    ScreenCheckBox(
                        onBack = onBack
                    )
                }

                is NavigationKey.ScreenChipRoute -> NavEntry(key) {
                    ScreenChip(
                        onBack = onBack
                    )
                }

                is NavigationKey.ScreenDatePickerRoute -> NavEntry(key) {
                    ScreenDatePicker(
                        onBack = onBack
                    )
                }

                is NavigationKey.ScreenDialogFullScreenRoute -> NavEntry(key) {
                    ScreenDialogFullScreen(
                        onBack = onBack
                    )
                }

                is NavigationKey.ScreenIconButtonRoute -> NavEntry(key) {
                    ScreenIconButtons(
                        onBack = onBack
                    )
                }

                is NavigationKey.ScreenNavigationBarRoute -> NavEntry(key) {
                    ScreenNavigationBar(
                        onBack = onBack
                    )
                }

                is NavigationKey.ScreenLoadingAndProgressIndicatorsRoute -> NavEntry(key) {
                    ScreenLoadingAndProgressIndicators(
                        onBack = onBack
                    )
                }

                is NavigationKey.ScreenNavigationDrawerRoute -> NavEntry(key) {
                    ScreenNavigationDrawer(
                        { HomeScreen1(onBack) }, onBack
                    )
                }

                is NavigationKey.ScreenRadioButtonRoute -> NavEntry(key) {
                    ScreenRadioButton(
                        onBack = onBack
                    )
                }

                is NavigationKey.ScreenSingleChoiceSegmentedButtonRoute -> NavEntry(key) {
                    ScreenSegmentedButton(
                        onBack = onBack
                    )
                }

                is NavigationKey.ScreenSliderRoute -> NavEntry(key) {
                    ScreenSlider(
                        onBack = onBack
                    )
                }

                is NavigationKey.ScreenSwitchRoute -> NavEntry(key) {
                    ScreenSwitch(
                        onBack = onBack
                    )
                }

                is NavigationKey.ScreenTabsRoute -> NavEntry(key) {
                    ScreenTabs(
                        onBack = onBack
                    )
                }

                is NavigationKey.ScreenTextFieldsRoute -> NavEntry(key) {
                    ScreenTextFields(
                        onBack = onBack
                    )
                }

                is NavigationKey.ScreenToolBarRoute -> NavEntry(key) {
                    ScreenToolBar(
                        onBack = onBack
                    )
                }

                is NavigationKey.ScreenToolTipsRoute -> NavEntry(key) {
                    ScreenToolTips(
                        onBack = onBack
                    )
                }

                is NavigationKey.ScreenTopAppBarRoute -> NavEntry(key) {
                    ScreenTopAppBar(
                        onBack = onBack
                    )
                }

                is NavigationKey.ScreenFloatingBottomBarRoute -> NavEntry(key) {
                    ScreenFloatingBottomBar(
                        onBack = onBack
                    )
                }

                is NavigationKey.ScreenFloatingBottomBarNewRoute -> NavEntry(key) {
                    ScreenFloatingBottomBar1(
                        onBack = onBack
                    )
                }

                is NavigationKey.ScreenSliderNewRoute -> NavEntry(key) {
                    ScreenSliderHomework(
                        onBack = onBack
                    )
                }

                is NavigationKey.NotificationPermissionRoute -> NavEntry(key) {
                    ScreenNotificationPermisson(
                        onBack = { backStack.removeLastOrNull() }
                    )
                }

                else -> NavEntry(Unit) { Text(text = "Unknown Route") }
            }
        }
    )
}
