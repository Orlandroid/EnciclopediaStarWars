package com.example.androidbase.data.remote.api

import com.example.androidbase.domain.entities.remote.users.UsersResponse
import retrofit2.http.GET


interface FakeUsersApi {

    @GET("api")
    suspend fun getMe(): UsersResponse

}