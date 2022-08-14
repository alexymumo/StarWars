package com.alexmumo.starwars.data.network.api

import com.alexmumo.starwars.data.network.responses.PeopleResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface StarWarsApi {
    @GET("people/?page/")
    suspend fun fetchPeople(@Query("page") page: Int): PeopleResponse
}
