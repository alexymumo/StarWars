package com.alexmumo.starwars.data.cache.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.alexmumo.starwars.data.cache.datastore.DatastoreManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

val Context.datastoreManager: DataStore<Preferences> by preferencesDataStore(
    name = "settings",
    scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
)
val cacheModule: Module = module {
    single { DatastoreManager(datastoreManager = androidContext().datastoreManager) }
}
