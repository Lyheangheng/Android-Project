package com.android.basic.android.feature.home

import com.android.basic.android.model.ComponentModel
import com.android.basic.android.navigation.ScreenAlertDialogRoute
import com.android.basic.android.navigation.ScreenBadgeRoute
import com.android.basic.android.navigation.ScreenBottomSheetRoute
import com.android.basic.android.navigation.ScreenCardRoute
import com.android.basic.android.navigation.ScreenCarouselRoute
import com.android.basic.android.navigation.ScreenCheckBoxRoute
import com.android.basic.android.navigation.ScreenChipRoute
import com.android.basic.android.navigation.ScreenDatePickerRoute
import com.android.basic.android.navigation.ScreenDialogFullScreenRoute
import com.android.basic.android.navigation.ScreenFloatingBottomBarNewRoute
import com.android.basic.android.navigation.ScreenFloatingBottomBarRoute
import com.android.basic.android.navigation.ScreenIconButtonRoute
import com.android.basic.android.navigation.ScreenLoadingAndProgressIndicatorsRoute
import com.android.basic.android.navigation.ScreenNavigationBarRoute
import com.android.basic.android.navigation.ScreenNavigationDrawerRoute
import com.android.basic.android.navigation.ScreenRadioButtonRoute
import com.android.basic.android.navigation.ScreenSingleChoiceSegmentedButtonRoute
import com.android.basic.android.navigation.ScreenSliderNewRoute
import com.android.basic.android.navigation.ScreenSliderRoute
import com.android.basic.android.navigation.ScreenSwitchRoute
import com.android.basic.android.navigation.ScreenTabsRoute
import com.android.basic.android.navigation.ScreenTextFieldsRoute
import com.android.basic.android.navigation.ScreenToolBarRoute
import com.android.basic.android.navigation.ScreenToolTipsRoute
import com.android.basic.android.navigation.ScreenTopAppBarRoute
import com.android.basic.android.navigation.SnackBarScreenRoute
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HomeRepository {

    val component = listOf<ComponentModel>(
        ComponentModel(
            id = 1,
            title = "Snack Bar Screen",
            description = "Click to go to Snack bar screen ",
            route = SnackBarScreenRoute
        ),
        ComponentModel(
            id = 2,
            title = "Alert Dialog Screen",
            description = "Click to go to Alert Dialog Screen ",
            route = ScreenAlertDialogRoute
        ),
        ComponentModel(
            id = 3,
            title = "Badge Screen",
            description = "Click to go to Badge screen ",
            route = ScreenBadgeRoute
        ),
        ComponentModel(
            id = 4,
            title = "Bottom Sheet Screen",
            description = "Click to go to Bottom Sheet screen ",
            route = ScreenBottomSheetRoute
        ),
        ComponentModel(
            id = 5,
            title = "Card Screen",
            description = "Click to go to Card Screen ",
            route = ScreenCardRoute
        ),
        ComponentModel(
            id = 6,
            title = "Carousel Screen",
            description = "Click to go to Carousel Screen ",
            route = ScreenCarouselRoute
        ),
        ComponentModel(
            id = 7,
            title = "Check Box Screen",
            description = "Click to go to Check Box Screen ",
            route = ScreenCheckBoxRoute
        ),
        ComponentModel(
            id = 8,
            title = "Chip Screen",
            description = "Click to go to Chip Screen ",
            route = ScreenChipRoute
        ),
        ComponentModel(
            id = 9,
            title = "Date Picker Screen",
            description = "Click to go to Date Picker Screen ",
            route = ScreenDatePickerRoute
        ),
        ComponentModel(
            id = 10,
            title = "Full Screen Dialog Screen",
            description = "Click to go to Full Screen Dialog Screen",
            route = ScreenDialogFullScreenRoute
        ),
        ComponentModel(
            id = 11,
            title = "Icon Button Screen",
            description = "Click to go to Icon Button Screen",
            route = ScreenIconButtonRoute
        ),
        ComponentModel(
            id = 12,
            title = "Loading And Progress Screen",
            description = "Click to go to Loading And Progress Screen",
            route = ScreenLoadingAndProgressIndicatorsRoute
        ),
        ComponentModel(
            id = 13,
            title = "Navigation Bar Screen",
            description = "Click to go to Navigation Bar Screen",
            route = ScreenNavigationBarRoute
        ),
        ComponentModel(
            id = 14,
            title = "Navigation Drawer Screen",
            description = "Click to go to Navigation Drawer Screen",
            route = ScreenNavigationDrawerRoute
        ),
        ComponentModel(
            id = 15,
            title = "Radio Button Screen",
            description = "Click to go to Radio Button Screen",
            route = ScreenRadioButtonRoute
        ),
        ComponentModel(
            id = 16,
            title = "Segmented Button Screen",
            description = "Click to go to Segmented Button Screen",
            route = ScreenSingleChoiceSegmentedButtonRoute
        ),
        ComponentModel(
            id = 17,
            title = "Slider Screen",
            description = "Click to go to Slider Screen",
            route = ScreenSliderRoute
        ),
        ComponentModel(
            id = 18,
            title = "Switch Screen",
            description = "Click to go to Switch Screen",
            route = ScreenSwitchRoute
        ),
        ComponentModel(
            id = 19,
            title = "Tabs Screen",
            description = "Click to go to Tabs Screen",
            route = ScreenTabsRoute
        ),
        ComponentModel(
            id = 20,
            title = "Text Field Screen",
            description = "Click to go to Text Field Screen",
            route = ScreenTextFieldsRoute
        ),
        ComponentModel(
            id = 21,
            title = "Tool bar Screen",
            description = "Click to go to Tool bar Screen",
            route = ScreenToolBarRoute
        ),
        ComponentModel(
            id = 22,
            title = "Tool Tips Screen",
            description = "Click to go to Tool Tips Screen",
            route = ScreenToolTipsRoute
        ),
        ComponentModel(
            id = 23,
            title = "Top App Bar Screen",
            description = "Click to go to Top App Bar Screen",
            route = ScreenTopAppBarRoute
        ),
        ComponentModel(
            id = 24,
            title = "Floating Bottom Bar Screen",
            description = "Click to go to Floating Bottom Bar Screen",
            route = ScreenFloatingBottomBarRoute
        ),
        ComponentModel(
            id = 25,
            title = "Floating Bottom Bar New Screen",
            description = "Click to go to Floating Bottom Bar New Screen",
            route = ScreenFloatingBottomBarNewRoute
        ),
        ComponentModel(
            id = 26,
            title = "Slider New Screen",
            description = "Click to go to Slider New Screen",
            route = ScreenSliderNewRoute
        ),
    )

    suspend fun getComponentListFromHomeRepo() : Flow<List<ComponentModel>> {
//        delay(2000)
        return flow{
            emit(component)
        }
    }
}