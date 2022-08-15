package com.alexmumo.starwars.di

import com.alexmumo.starwars.data.repository.MainRepository
import org.koin.dsl.module

val repositoryModule = module {
    single {
        MainRepository(starWarsApi = get())
    }
}
