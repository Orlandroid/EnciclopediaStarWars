package com.example.androidbase.data.remote.login

import com.example.androidbase.data.remote.api.DummyJsonApi
import com.example.androidbase.domain.entities.remote.login.LoginRequest

class LoginRepositoryImp(private val api: DummyJsonApi) : LoginRepository {

    override suspend fun login(body: LoginRequest) = api.login(body)
}