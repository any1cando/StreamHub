package com.panevrn.streamhub.di

import com.google.gson.Gson
import com.panevrn.data.mapper.LoginResponseMapper
import com.panevrn.data.network.EnterApi
import com.panevrn.data.repositoryimpl.EnterRepositoryImpl
import com.panevrn.domain.repository.EnterRepository
import com.panevrn.domain.usecase.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val BASE_URL = "http://10.0.2.2:8080/"

    // --- Network deps -----------------------------------

    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Provides
    @Singleton
    fun provideOkHttpClient(logging: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    @Provides
    @Singleton
    fun provideEnterApi(retrofit: Retrofit): EnterApi =
        retrofit.create(EnterApi::class.java)


    @Provides
    @Singleton
    fun provideEnterRepository(api: EnterApi, gson: Gson, mapper: LoginResponseMapper): EnterRepository =
        EnterRepositoryImpl(api, gson, mapper)


    @Provides
    @Singleton
    fun provideLoginUseCase(repo: EnterRepository): LoginUseCase = LoginUseCase(repo)
}