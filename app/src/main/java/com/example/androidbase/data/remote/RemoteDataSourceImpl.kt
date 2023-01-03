package com.example.androidbase.data.remote


import com.example.androidbase.domain.RemoteDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSourceImpl @Inject constructor(
    private val api: Api
) : RemoteDataSource {

    override suspend fun getPeople() = api.getPeople()

}