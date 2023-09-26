package com.example.androidbase.data.remote.users

import com.example.androidbase.data.remote.api.FakeUsersApi

class UsersRepositoryImp(private val api: FakeUsersApi) : UsersRepository {

    override suspend fun getMe() = api.getMe()


}