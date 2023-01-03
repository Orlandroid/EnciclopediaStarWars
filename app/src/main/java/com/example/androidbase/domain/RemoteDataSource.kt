package com.example.androidbase.domain

import com.example.androidbase.domain.entities.remote.PeopleResponse



interface RemoteDataSource {

    suspend fun getPeople(): PeopleResponse
}