package com.alexmumo.starwars.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.alexmumo.starwars.data.datasources.PeoplePagingSource
import com.alexmumo.starwars.data.network.api.StarWarsApi
import com.alexmumo.starwars.data.repository.CharacterRepository
import com.alexmumo.starwars.models.Character
import kotlinx.coroutines.flow.Flow

/*
* provides implementation to the CharacterRepository interface
* */

class MainRepositoryImpl(private val starWarsApi: StarWarsApi) : CharacterRepository {
    override suspend fun fetchCharacters(): Flow<PagingData<Character>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                PeoplePagingSource(starWarsApi)
            }
        ).flow
    }
}
