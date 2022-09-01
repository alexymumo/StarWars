package com.alexmumo.starwars.ui.screens.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexmumo.starwars.data.repository.SettingsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SettingsViewModel constructor(private val settingsRepository: SettingsRepository) : ViewModel() {
    private val _theme = MutableStateFlow<Int>(0)
    val theme get() = _theme.asStateFlow()

    init {
        getTheme()
    }

    fun savePref(key: String,selection: Int) {
        viewModelScope.launch {
            settingsRepository.setTheme(theme = selection)
        }
    }

    private fun getTheme() {
        viewModelScope.launch {
            settingsRepository.getTheme().collect {
                _theme.value = it ?: 2
            }
        }
    }
}
