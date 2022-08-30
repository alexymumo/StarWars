package com.alexmumo.starwars.data.repository

import androidx.paging.PagingData
import com.alexmumo.starwars.models.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    suspend fun fetchCharacters(): Flow<PagingData<Character>>
}
