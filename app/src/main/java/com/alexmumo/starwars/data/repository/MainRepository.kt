package com.alexmumo.starwars.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.alexmumo.starwars.data.datasources.PeoplePagingSource
import com.alexmumo.starwars.data.network.api.StarWarsApi
import com.alexmumo.starwars.models.People
import kotlinx.coroutines.flow.Flow

class MainRepository(private val starWarsApi: StarWarsApi) {
    fun fetchPeople(): Flow<PagingData<People>> {
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
