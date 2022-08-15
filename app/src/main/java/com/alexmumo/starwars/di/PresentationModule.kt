package com.alexmumo.starwars.di

import com.alexmumo.starwars.ui.viewmodels.PeopleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        PeopleViewModel(get())
    }
}
