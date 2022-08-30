package com.alexmumo.starwars.di

import com.alexmumo.starwars.ui.screens.settings.SettingsViewModel
import com.alexmumo.starwars.ui.viewmodels.CharacterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        CharacterViewModel(get())
    }
    viewModel {
        SettingsViewModel(get())
    }
}
