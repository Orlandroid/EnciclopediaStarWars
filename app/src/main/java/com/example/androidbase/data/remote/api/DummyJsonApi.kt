package com.example.androidbase.data.remote.api

import com.example.androidbase.domain.entities.remote.login.LoginRequest
import com.example.androidbase.domain.entities.remote.login.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST


interface DummyJsonApi {

    @POST("auth/login")
    suspend fun login(@Body bodyLogin: LoginRequest): LoginResponse

}