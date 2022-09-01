package com.alexmumo.starwars.data.repository

import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    suspend fun setTheme(theme: Int)

    suspend fun getTheme(): Flow<Int?>
}
