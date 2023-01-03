package com.example.androidbase.data.di

import com.example.androidbase.data.local.LocalDataSourceImpl
import com.example.androidbase.data.remote.RemoteDataSourceImpl
import com.example.androidbase.domain.LocalDataSource
import com.example.androidbase.domain.RemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindRemoteDataSource(impl: RemoteDataSourceImpl): RemoteDataSource

    @Binds
    abstract fun bindLocalDataSource(impl: LocalDataSourceImpl): LocalDataSource

}