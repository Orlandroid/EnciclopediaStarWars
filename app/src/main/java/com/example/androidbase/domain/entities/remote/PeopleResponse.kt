package com.example.androidbase.domain.entities.remote

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PeopleResponse(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<People>
)

@JsonClass(generateAdapter = true)
data class People(
    val birth_year: String,
    val created: String,
    val edited: String,
    val eye_color: String,
    val films: List<String>,
    val gender: String,
    val hair_color: String,
    val height: String,
    val homeworld: String,
    val mass: String,
    val name: String,
    val skin_color: String,
    val species: List<String>,
    val starships: List<String>,
    val url: String,
    val vehicles: List<String>
)