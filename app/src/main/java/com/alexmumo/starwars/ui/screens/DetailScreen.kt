package com.alexmumo.starwars.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.alexmumo.starwars.ui.viewmodels.PeopleViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun DetailScreen(
    navController: NavController,
    viewModel: PeopleViewModel = getViewModel()
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
    }
}
