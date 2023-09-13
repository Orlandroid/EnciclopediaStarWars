package com.example.androidbase.data.remote


import com.example.androidbase.data.remote.api.DummyJsonApi
import com.example.androidbase.domain.RemoteDataSource
import com.example.androidbase.domain.entities.remote.PeopleResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSourceImpl @Inject constructor(
    private val api: DummyJsonApi
) : RemoteDataSource {
    override suspend fun getPeople(): PeopleResponse {
        TODO("Not yet implemented")
    }


}