package com.alexmumo.starwars.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.alexmumo.starwars.R

sealed class NavigationItem(
    val route: String,
    @DrawableRes val icon: Int?,
    @StringRes val title: Int?
) {
    object Home : NavigationItem("home", R.drawable.ic_home, R.string.home)
    object Details : NavigationItem("detail{name}", R.drawable.ic_detail, R.string.detail)
    object Settings : NavigationItem("setting", R.drawable.ic_home, R.string.detail)
}
