package com.example.androidbase.data.remote

import com.example.androidbase.domain.entities.remote.PeopleResponse
import retrofit2.http.GET


interface Api {

    @GET("people")
    suspend fun getPeople(): PeopleResponse

}