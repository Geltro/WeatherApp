package com.algartech.weatherapp.domain

import com.algartech.weatherapp.data.WeatherApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkConection {
    @Singleton
    @Provides
    fun provideOkhttpClient(): OkHttpClient = OkHttpClient.Builder().apply {

    }.build()

    @Singleton
    @Provides
    fun provideRetrofit(
        httpClient: OkHttpClient = provideOkhttpClient()
    ): Retrofit =
        Retrofit.Builder().apply {
            baseUrl(Constants.BASE_URL)
            client(httpClient)
            addConverterFactory(GsonConverterFactory.create())
        }.build()


    @Singleton
    @Provides
    fun provideWeatherService(retrofit: Retrofit = provideRetrofit()): WeatherApi =
        retrofit.create(WeatherApi::class.java)
}
