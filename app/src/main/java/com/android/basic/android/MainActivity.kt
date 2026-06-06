package com.android.basic.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.android.basic.android.component.ScreenAlertDialog
import com.android.basic.android.component.ScreenBottomSheet
import com.android.basic.android.component.ScreenDialogFullScreen
import com.android.basic.android.component.ScreenLoadingAndProgressIndicators
import com.android.basic.android.component.ScreenNavigationBar
import com.android.basic.android.component.ScreenNavigationDrawer
import com.android.basic.android.component.ScreenRadioButton
import com.android.basic.android.component.ScreenSlider
import com.android.basic.android.component.ScreenSnackBar
import com.android.basic.android.component.ScreenSwitch
import com.android.basic.android.component.ScreenTabs
import com.android.basic.android.component.ScreenTextFields
import com.android.basic.android.component.ScreenToolBar
import com.android.basic.android.component.homework.DetermineIndicators
import com.android.basic.android.component.homework.HomeworkOnlineShopHomePage
import com.android.basic.android.component.homework.ScreenSliderHomework
import com.android.basic.android.component.homework.SpotifyUI
import com.android.basic.android.ui.theme.BaseTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // This controls which screen is shown on start
//                ScreenHorizontalPager()
//                ScreenBadge()
            BaseTheme() {
//                SpotifyUI()
//                ScreenRadioButton()
//                ScreenBottomSheet()
//                ScreenSliderHomework()
//                ScreenSnackBar()
//                ScreenSwitch()
//                ScreenTabs()
//                ScreenTextFields()
                ScreenToolBar()
            }
        }
    }
}

