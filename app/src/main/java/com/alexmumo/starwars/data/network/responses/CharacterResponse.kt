package com.alexmumo.starwars.data.network.responses

import com.alexmumo.starwars.models.Character

data class CharacterResponse(
    val results: List<Character>
)
