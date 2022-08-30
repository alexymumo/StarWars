package com.alexmumo.starwars.data.cache.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DatastoreManager(private val datastoreManager: DataStore<Preferences>) {
    suspend fun setKey(key: String, value: Int) {
        /*
        * define a key for the value
        * use the Datastore.data property to expose the appropriate stored value using Flow
        * Preferences Datastore provides an edit() function that transactionally updates the data in
        * Datastore
        * */
        val preferenceKey = intPreferencesKey(key)
        datastoreManager.edit { settings ->
            settings[preferenceKey] = value
        }
    }
    suspend fun getKey(key: String): Flow<Int?> {
        val preferenceKey = intPreferencesKey(key)
        return datastoreManager.data.map { preferences ->
            preferences[preferenceKey]
        }
    }
    companion object {
        const val THEME_KEY = "theme_key"
    }
}