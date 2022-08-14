package com.alexmumo.starwars.data.network.responses

import com.alexmumo.starwars.models.People

data class PeopleResponse(
    val results: List<People>
)
