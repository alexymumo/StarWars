package com.alexmumo.starwars.data.datasources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.alexmumo.starwars.data.network.api.StarWarsApi
import com.alexmumo.starwars.models.Character
import retrofit2.HttpException
import java.io.IOException

class PeoplePagingSource(private val starWarsApi: StarWarsApi): PagingSource<Int, Character>() {
    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        return try {
            val page = params.key ?: 1
            val people = starWarsApi.fetchPeople(page)
            LoadResult.Page(
                data = people.results,
                nextKey = page + 1,
                prevKey = if (page == 1) null else page - 1
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }
}