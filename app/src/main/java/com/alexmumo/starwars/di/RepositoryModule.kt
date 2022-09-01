package com.alexmumo.starwars.di

import com.alexmumo.starwars.data.repository.MainRepository
import com.alexmumo.starwars.data.repository.SettingsRepository
import com.alexmumo.starwars.repository.SettingsRepositoryImpl
import org.koin.dsl.module

/*
* repository module
* */

val repositoryModule = module {
    single {
        MainRepository(starWarsApi = get())
    }
    single<SettingsRepository> {
        SettingsRepositoryImpl(datastoreManager = get())
    }
}
