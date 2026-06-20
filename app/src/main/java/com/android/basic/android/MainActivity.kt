package com.android.basic.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.android.basic.android.component.ScreenBadge
import com.android.basic.android.navigation.Navigation
import com.android.basic.android.ui.theme.BaseTheme
import com.android.basic.android.util.LoadingScreen
import com.android.basic.android.util.LoadingUtil


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // This controls which screen is shown on start
//                ScreenHorizontalPager()
//                ScreenBadge()
            BaseTheme() {
                if(LoadingUtil.isLoading){
                    LoadingScreen()
                }
//                SpotifyUI()
//                ScreenRadioButton()
//                ScreenBottomSheet()
//                ScreenSliderHomework()
//                ScreenSnackBar()
//                ScreenSwitch()
//                ScreenTabs()
//                ScreenTextFields()
//                ScreenToolBar()
//                ScreenFloatingBottomBar()
//                ScreenFloatingBottomBar1()
//                ScreenToolTips()
//                ProductListScreen()
//                UserProfileScreen()
//                ScreenBadge()
                Navigation()
            }
        }
    }
}

