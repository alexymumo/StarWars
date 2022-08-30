package com.alexmumo.starwars.repository

import com.alexmumo.starwars.data.cache.datastore.DatastoreManager
import com.alexmumo.starwars.data.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow
/*
* implementation of the SettingRepository interface
* */
class SettingsRepositoryImpl constructor(private val datastoreManager: DatastoreManager) : SettingsRepository {
    override suspend fun setTheme(theme: Int) {
        datastoreManager.setKey(key = DatastoreManager.THEME_KEY, value = theme)
    }

    override suspend fun getTheme(): Flow<Int?> {
        return datastoreManager.getKey(key = DatastoreManager.THEME_KEY)
    }
}
