package com.example.androidbase.data.remote.api

import com.example.androidbase.domain.entities.remote.login.LoginRequest
import com.example.androidbase.domain.entities.remote.login.LoginResponse
import com.example.androidbase.domain.entities.remote.products.Product
import com.example.androidbase.domain.entities.remote.products.ProductResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface DummyJsonApi {

    @POST("auth/login")
    suspend fun login(@Body bodyLogin: LoginRequest): LoginResponse

    @GET("products")
    suspend fun getProducts(): ProductResponse

    @GET("products/{productId}")
    suspend fun getSingleProduct(@Path("productId") product: Int): Product

}