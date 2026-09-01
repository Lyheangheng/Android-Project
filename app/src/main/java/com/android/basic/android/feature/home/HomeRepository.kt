package com.android.basic.android.feature.home

import com.android.basic.android.model.ComponentModel
import com.android.basic.android.navigation.NavigationKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HomeRepository {
    val component = listOf<ComponentModel>(
        ComponentModel(
            id = 1,
            title = "Snack Bar Screen",
            description = "Click to go to Snack bar screen ",
            route = NavigationKey.SnackBarScreenRoute
        ),
        ComponentModel(
            id = 2,
            title = "Alert Dialog Screen",
            description = "Click to go to Alert Dialog Screen ",
            route = NavigationKey.ScreenAlertDialogRoute
        ),
        ComponentModel(
            id = 3,
            title = "Badge Screen",
            description = "Click to go to Badge screen ",
            route = NavigationKey.ScreenBadgeRoute
        ),
        ComponentModel(
            id = 4,
            title = "Bottom Sheet Screen",
            description = "Click to go to Bottom Sheet screen ",
            route = NavigationKey.ScreenBottomSheetRoute
        ),
        ComponentModel(
            id = 5,
            title = "Card Screen",
            description = "Click to go to Card Screen ",
            route = NavigationKey.ScreenCardRoute
        ),
        ComponentModel(
            id = 6,
            title = "Carousel Screen",
            description = "Click to go to Carousel Screen ",
            route = NavigationKey.ScreenCarouselRoute
        ),
        ComponentModel(
            id = 7,
            title = "Check Box Screen",
            description = "Click to go to Check Box Screen ",
            route = NavigationKey.ScreenCheckBoxRoute
        ),
        ComponentModel(
            id = 8,
            title = "Chip Screen",
            description = "Click to go to Chip Screen ",
            route = NavigationKey.ScreenChipRoute
        ),
        ComponentModel(
            id = 9,
            title = "Date Picker Screen",
            description = "Click to go to Date Picker Screen ",
            route = NavigationKey.ScreenDatePickerRoute
        ),
        ComponentModel(
            id = 10,
            title = "Full Screen Dialog Screen",
            description = "Click to go to Full Screen Dialog Screen",
            route = NavigationKey.ScreenDialogFullScreenRoute
        ),
        ComponentModel(
            id = 11,
            title = "Icon Button Screen",
            description = "Click to go to Icon Button Screen",
            route = NavigationKey.ScreenIconButtonRoute
        ),
        ComponentModel(
            id = 12,
            title = "Loading And Progress Screen",
            description = "Click to go to Loading And Progress Screen",
            route = NavigationKey.ScreenLoadingAndProgressIndicatorsRoute
        ),
        ComponentModel(
            id = 13,
            title = "Navigation Bar Screen",
            description = "Click to go to Navigation Bar Screen",
            route = NavigationKey.ScreenNavigationBarRoute
        ),
        ComponentModel(
            id = 14,
            title = "Navigation Drawer Screen",
            description = "Click to go to Navigation Drawer Screen",
            route = NavigationKey.ScreenNavigationDrawerRoute
        ),
        ComponentModel(
            id = 15,
            title = "Radio Button Screen",
            description = "Click to go to Radio Button Screen",
            route = NavigationKey.ScreenRadioButtonRoute
        ),
        ComponentModel(
            id = 16,
            title = "Segmented Button Screen",
            description = "Click to go to Segmented Button Screen",
            route = NavigationKey.ScreenSingleChoiceSegmentedButtonRoute
        ),
        ComponentModel(
            id = 17,
            title = "Slider Screen",
            description = "Click to go to Slider Screen",
            route = NavigationKey.ScreenSliderRoute
        ),
        ComponentModel(
            id = 18,
            title = "Switch Screen",
            description = "Click to go to Switch Screen",
            route = NavigationKey.ScreenSwitchRoute
        ),
        ComponentModel(
            id = 19,
            title = "Tabs Screen",
            description = "Click to go to Tabs Screen",
            route = NavigationKey.ScreenTabsRoute
        ),
        ComponentModel(
            id = 20,
            title = "Text Field Screen",
            description = "Click to go to Text Field Screen",
            route = NavigationKey.ScreenTextFieldsRoute
        ),
        ComponentModel(
            id = 21,
            title = "Tool bar Screen",
            description = "Click to go to Tool bar Screen",
            route = NavigationKey.ScreenToolBarRoute
        ),
        ComponentModel(
            id = 22,
            title = "Tool Tips Screen",
            description = "Click to go to Tool Tips Screen",
            route = NavigationKey.ScreenToolTipsRoute
        ),
        ComponentModel(
            id = 23,
            title = "Top App Bar Screen",
            description = "Click to go to Top App Bar Screen",
            route = NavigationKey.ScreenTopAppBarRoute
        ),
        ComponentModel(
            id = 24,
            title = "Floating Bottom Bar Screen",
            description = "Click to go to Floating Bottom Bar Screen",
            route = NavigationKey.ScreenFloatingBottomBarRoute
        ),
        ComponentModel(
            id = 25,
            title = "Floating Bottom Bar New Screen",
            description = "Click to go to Floating Bottom Bar New Screen",
            route = NavigationKey.ScreenFloatingBottomBarNewRoute
        ),
        ComponentModel(
            id = 26,
            title = "Slider New Screen",
            description = "Click to go to Slider New Screen",
            route = NavigationKey.ScreenSliderNewRoute
        ),
        ComponentModel(
            id = 27,
            title = "Notification Permission Screen",
            description = "Click to go to Notification Permission Screen",
            route = NavigationKey.NotificationPermissionRoute
        ),
        ComponentModel(
            id = 28,
            title = "UserAPi Screen",
            description = "Click to go to UserApi Screen",
            route = NavigationKey.UserApiScreenRoute
        ),
        ComponentModel(
            id = 29,
            title = "Camera Launcher Screen",
            description = "Click to go to Camera Launcher Screen",
            route = NavigationKey.ScreenCameraLauncher
        ),
    )

    suspend fun getComponentListFromHomeRepo(): Flow<List<ComponentModel>> {
//        delay(2000)
        return flow {
            emit(component)
        }
    }
}