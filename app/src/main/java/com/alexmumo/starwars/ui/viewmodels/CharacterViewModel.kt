package com.alexmumo.starwars.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.alexmumo.starwars.data.repository.MainRepository
import com.alexmumo.starwars.models.Character
import kotlinx.coroutines.flow.Flow

class CharacterViewModel constructor(private val mainRepository: MainRepository) : ViewModel() {

    val people: Flow<PagingData<Character>> get() = fetchPeople()

    private fun fetchPeople(): Flow<PagingData<Character>> {
        return mainRepository.fetchPeople().cachedIn(viewModelScope)
    }
}
