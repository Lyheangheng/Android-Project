package com.android.basic.android.feature.home

import com.android.basic.android.feature.navigationBar.ScreenNavigationBar
import com.android.basic.android.feature.textFields.ScreenTextFields
import com.android.basic.android.model.ComponentModel
import com.android.basic.android.navigation.ScreenAlertDialog
import com.android.basic.android.navigation.ScreenBadge
import com.android.basic.android.navigation.ScreenBottomSheet
import com.android.basic.android.navigation.ScreenCard
import com.android.basic.android.navigation.ScreenCarousel
import com.android.basic.android.navigation.ScreenCheckBox
import com.android.basic.android.navigation.ScreenChip
import com.android.basic.android.navigation.ScreenDatePicker
import com.android.basic.android.navigation.ScreenDialogFullScreen
import com.android.basic.android.navigation.ScreenFloatingBottomBar
import com.android.basic.android.navigation.ScreenFloatingBottomBarNew
import com.android.basic.android.navigation.ScreenIconButton
import com.android.basic.android.navigation.ScreenLoadingAndProgressIndicators
import com.android.basic.android.navigation.ScreenNavigationBar
import com.android.basic.android.navigation.ScreenNavigationDrawer
import com.android.basic.android.navigation.ScreenRadioButton
import com.android.basic.android.navigation.ScreenSingleChoiceSegmentedButton
import com.android.basic.android.navigation.ScreenSlider
import com.android.basic.android.navigation.ScreenSliderNew
import com.android.basic.android.navigation.ScreenSwitch
import com.android.basic.android.navigation.ScreenTabs
import com.android.basic.android.navigation.ScreenTextFields
import com.android.basic.android.navigation.ScreenToolBar
import com.android.basic.android.navigation.ScreenToolTips
import com.android.basic.android.navigation.ScreenTopAppBar
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
        ),
        ComponentModel(
            id = 2,
            title = "Alert Dialog Screen",
            description = "Click to go to Alert Dialog Screen ",
            route = ScreenAlertDialog
        ),
        ComponentModel(
            id = 3,
            title = "Badge Screen",
            description = "Click to go to Badge screen ",
            route = ScreenBadge
        ),
        ComponentModel(
            id = 4,
            title = "Bottom Sheet Screen",
            description = "Click to go to Bottom Sheet screen ",
            route = ScreenBottomSheet
        ),
        ComponentModel(
            id = 5,
            title = "Card Screen",
            description = "Click to go to Card Screen ",
            route = ScreenCard
        ),
        ComponentModel(
            id = 6,
            title = "Carousel Screen",
            description = "Click to go to Carousel Screen ",
            route = ScreenCarousel
        ),
        ComponentModel(
            id = 7,
            title = "Check Box Screen",
            description = "Click to go to Check Box Screen ",
            route = ScreenCheckBox
        ),
        ComponentModel(
            id = 8,
            title = "Chip Screen",
            description = "Click to go to Chip Screen ",
            route = ScreenChip
        ),
        ComponentModel(
            id = 9,
            title = "Date Picker Screen",
            description = "Click to go to Date Picker Screen ",
            route = ScreenDatePicker
        ),
        ComponentModel(
            id = 10,
            title = "Full Screen Dialog Screen",
            description = "Click to go to Full Screen Dialog Screen",
            route = ScreenDialogFullScreen
        ),
        ComponentModel(
            id = 11,
            title = "Icon Button Screen",
            description = "Click to go to Icon Button Screen",
            route = ScreenIconButton
        ),
        ComponentModel(
            id = 12,
            title = "Loading And Progress Screen",
            description = "Click to go to Loading And Progress Screen",
            route = ScreenLoadingAndProgressIndicators
        ),
        ComponentModel(
            id = 13,
            title = "Navigation Bar Screen",
            description = "Click to go to Navigation Bar Screen",
            route = ScreenNavigationBar
        ),
        ComponentModel(
            id = 14,
            title = "Navigation Drawer Screen",
            description = "Click to go to Navigation Drawer Screen",
            route = ScreenNavigationDrawer
        ),
        ComponentModel(
            id = 15,
            title = "Radio Button Screen",
            description = "Click to go to Radio Button Screen",
            route = ScreenRadioButton
        ),
        ComponentModel(
            id = 16,
            title = "Segmented Button Screen",
            description = "Click to go to Segmented Button Screen",
            route = ScreenSingleChoiceSegmentedButton
        ),
        ComponentModel(
            id = 17,
            title = "Slider Screen",
            description = "Click to go to Slider Screen",
            route = ScreenSlider
        ),
        ComponentModel(
            id = 18,
            title = "Switch Screen",
            description = "Click to go to Switch Screen",
            route = ScreenSwitch
        ),
        ComponentModel(
            id = 19,
            title = "Tabs Screen",
            description = "Click to go to Tabs Screen",
            route = ScreenTabs
        ),
        ComponentModel(
            id = 20,
            title = "Text Field Screen",
            description = "Click to go to Text Field Screen",
            route = ScreenTextFields
        ),
        ComponentModel(
            id = 21,
            title = "Tool bar Screen",
            description = "Click to go to Tool bar Screen",
            route = ScreenToolBar
        ),
        ComponentModel(
            id = 22,
            title = "Tool Tips Screen",
            description = "Click to go to Tool Tips Screen",
            route = ScreenToolTips
        ),
        ComponentModel(
            id = 23,
            title = "Top App Bar Screen",
            description = "Click to go to Top App Bar Screen",
            route = ScreenTopAppBar
        ),
        ComponentModel(
            id = 24,
            title = "Floating Bottom Bar Screen",
            description = "Click to go to Floating Bottom Bar Screen",
            route = ScreenFloatingBottomBar
        ),
        ComponentModel(
            id = 25,
            title = "Floating Bottom Bar New Screen",
            description = "Click to go to Floating Bottom Bar New Screen",
            route = ScreenFloatingBottomBarNew
        ),
        ComponentModel(
            id = 26,
            title = "Slider New Screen",
            description = "Click to go to Slider New Screen",
            route = ScreenSliderNew
        ),
    )

    suspend fun getComponentListFromHomeRepo() : Flow<List<ComponentModel>> {
//        delay(2000)
        return flow{
            emit(component)
        }
    }
}