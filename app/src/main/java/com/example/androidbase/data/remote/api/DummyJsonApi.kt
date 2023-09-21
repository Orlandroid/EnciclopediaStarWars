package com.example.androidbase.data.remote.api

import com.example.androidbase.domain.entities.remote.login.LoginRequest
import com.example.androidbase.domain.entities.remote.login.LoginResponse
import com.example.androidbase.domain.entities.remote.products.ProductResponse
import com.example.androidbase.presentation.ui.example.FeaturedContent
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface DummyJsonApi {


    @POST("auth/login")
    suspend fun login(@Body bodyLogin: LoginRequest): LoginResponse

    @GET("products")
    suspend fun getProducts(): ProductResponse

    @GET("fakeResponsePractice.json")
    suspend fun getHomeContent(): FeaturedContent

}