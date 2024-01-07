package com.jlanda.glorycalculator.ui.navigation

sealed class AppScreens (val route:String) {
    object SplashScreen: AppScreens("splash_screen")
    object MainScreen: AppScreens("main_screen")
    object ResultScreen: AppScreens("result_screen")
}
