package com.alexmumo.starwars.ui.screens

import android.annotation.SuppressLint
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.alexmumo.starwars.ui.navigation.BottomNav
import com.alexmumo.starwars.ui.navigation.Navigation

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNav(navController = navController)
        },
        backgroundColor = MaterialTheme.colors.surface
    ) { paddingValues ->
        Navigation(navController = navController, paddingValues = paddingValues)
    }
}
