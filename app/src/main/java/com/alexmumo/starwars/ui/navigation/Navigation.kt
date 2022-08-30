package com.alexmumo.starwars.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.alexmumo.starwars.ui.screens.DetailScreen
import com.alexmumo.starwars.ui.screens.HomeScreen
import com.alexmumo.starwars.ui.screens.settings.SettingScreen

@Composable
fun Navigation(
    navController: NavHostController,
    paddingValues: PaddingValues
) {
    NavHost(navController = navController, startDestination = NavigationItem.Home.route) {
        composable(route = NavigationItem.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = NavigationItem.Details.route) {
            DetailScreen(navController = navController)
        }
        composable(route = NavigationItem.Settings.route) {
            SettingScreen(navController = navController, paddingValues = paddingValues)
        }
    }
}
