package com.jlanda.glorycalculator.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.jlanda.glorycalculator.ui.screen.MainScreen
import com.jlanda.glorycalculator.ui.screen.ResultScreen
import com.jlanda.glorycalculator.ui.screen.SplashScreen

@Composable
fun AppNavigation () {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.MainScreen.route){
        composable(route = AppScreens.MainScreen.route){ MainScreen(navController) }
        composable(route = AppScreens.SplashScreen.route){ SplashScreen(navController) }
        composable(route = AppScreens.ResultScreen.route + "/{result}", arguments = listOf(
            navArgument(name = "result"){
                type= NavType.IntType
            }
        )){ ResultScreen(navController, it.arguments?.getInt("result")) }
    }

}