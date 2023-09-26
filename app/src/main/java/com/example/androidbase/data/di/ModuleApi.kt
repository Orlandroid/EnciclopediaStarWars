package com.example.androidbase.data.di


import com.example.androidbase.data.remote.api.DummyJsonApi
import com.example.androidbase.data.remote.api.FakeUsersApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ModuleApi {


    private const val BASE_URL_DUMMY_JSON = "https://dummyjson.com/"
    private const val FAKE_USERS_URL = "https://randomuser.me/"
    private const val FAKE_USERS = "FakeUsers"

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .retryOnConnectionFailure(true)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL_DUMMY_JSON)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    @Named(FAKE_USERS)
    fun provideRetrofitFakeUsers(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(FAKE_USERS_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): DummyJsonApi =
        retrofit.create(DummyJsonApi::class.java)


    @Singleton
    @Provides
    fun provideApiServiceFakeUsers(@Named(FAKE_USERS) retrofit: Retrofit): FakeUsersApi =
        retrofit.create(FakeUsersApi::class.java)


}