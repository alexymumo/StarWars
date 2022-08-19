package com.alexmumo.starwars.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.alexmumo.starwars.ui.screens.DetailScreen
import com.alexmumo.starwars.ui.screens.HomeScreen
import com.alexmumo.starwars.ui.screens.SettingScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationItem.Home.route) {
        composable(route = NavigationItem.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = NavigationItem.Details.route) {
            DetailScreen(navController = navController)
        }
        composable(route = NavigationItem.Settings.route) {
            SettingScreen(navController = navController)
        }
    }
}
