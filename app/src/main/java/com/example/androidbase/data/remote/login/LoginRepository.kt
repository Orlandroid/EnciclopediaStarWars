package com.example.androidbase.data.remote.login

import com.example.androidbase.domain.entities.remote.login.LoginRequest
import com.example.androidbase.domain.entities.remote.login.LoginResponse


interface LoginRepository {

    suspend fun login(body: LoginRequest): LoginResponse
}