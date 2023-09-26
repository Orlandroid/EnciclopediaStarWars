package com.example.androidbase.data.remote.users

import com.example.androidbase.domain.entities.remote.users.UsersResponse


interface UsersRepository {

    suspend fun getMe(): UsersResponse

}