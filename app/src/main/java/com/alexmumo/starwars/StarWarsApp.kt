package com.alexmumo.starwars

import android.app.Application
import com.alexmumo.starwars.data.cache.di.cacheModule
import com.alexmumo.starwars.data.network.di.networkModule
import com.alexmumo.starwars.di.presentationModule
import com.alexmumo.starwars.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class StarWarsApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
        initTimber()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun initKoin() {
        startKoin {
            androidLogger(level = Level.NONE)
            androidContext(this@StarWarsApp)
            modules(repositoryModule, presentationModule, networkModule, cacheModule)
        }
    }
}
