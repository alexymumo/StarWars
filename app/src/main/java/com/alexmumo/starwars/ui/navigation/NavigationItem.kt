package com.alexmumo.starwars.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.alexmumo.starwars.R

sealed class NavigationItem(
    val route: String,
    @DrawableRes val icon: Int,
    @StringRes val title: Int
) {
    object Home : NavigationItem("home", R.drawable.ic_launcher_background, R.string.home)
}
