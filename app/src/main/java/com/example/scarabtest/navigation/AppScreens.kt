package com.example.scarabtest.navigation

import com.example.scarabtest.utils.Constants.HOME_SCREEN
import com.example.scarabtest.utils.Constants.SPLASH_SCREEN

sealed class AppScreens(val route: String) {

    data object HomeScreen : AppScreens(HOME_SCREEN)
    data object SplashScreen : AppScreens(SPLASH_SCREEN)


}



