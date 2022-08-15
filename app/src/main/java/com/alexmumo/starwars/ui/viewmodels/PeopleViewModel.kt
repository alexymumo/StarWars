package com.alexmumo.starwars.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.alexmumo.starwars.data.repository.MainRepository
import com.alexmumo.starwars.models.People
import kotlinx.coroutines.flow.Flow

class PeopleViewModel constructor(private val mainRepository: MainRepository) : ViewModel() {

    val people: Flow<PagingData<People>> get() = fetchPeople()

    private fun fetchPeople(): Flow<PagingData<People>> {
        return mainRepository.fetchPeople().cachedIn(viewModelScope)
    }
}
