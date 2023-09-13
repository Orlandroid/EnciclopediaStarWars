package com.example.androidbase.data.remote.api

import com.example.androidbase.domain.entities.remote.PeopleResponse
import retrofit2.http.GET


interface FakeStoreApi {

    @GET("people")
    suspend fun getPeople(): PeopleResponse

}