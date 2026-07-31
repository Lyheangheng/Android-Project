package com.android.basic.android.navigation

import kotlinx.serialization.Serializable

object NavigationKey {
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
    data object NotificationPermissionRoute
    data object UserApiScreenRoute

    @Serializable
    data class UserProfile(
        val id: Int,
    )

}