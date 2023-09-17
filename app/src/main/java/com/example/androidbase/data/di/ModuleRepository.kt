package com.example.androidbase.data.di

import com.example.androidbase.data.Repository
import com.example.androidbase.data.remote.api.DummyJsonApi
import com.example.androidbase.data.remote.login.LoginRepository
import com.example.androidbase.data.remote.login.LoginRepositoryImp
import com.example.androidbase.data.remote.products.ProductsRepository
import com.example.androidbase.data.remote.products.ProductsRepositoryImp
import com.example.androidbase.domain.LocalDataSource
import com.example.androidbase.domain.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)

object ModuleRepository {

    @Singleton
    @Provides
    fun provideRepository(
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource
    ): Repository = Repository(localDataSource, remoteDataSource)

    @Singleton
    @Provides
    fun provideLoginRepository(api: DummyJsonApi): LoginRepository = LoginRepositoryImp(api)

    @Singleton
    @Provides
    fun provideProductRepository(api: DummyJsonApi): ProductsRepository = ProductsRepositoryImp(api)

}