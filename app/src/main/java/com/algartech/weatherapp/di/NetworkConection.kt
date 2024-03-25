package com.algartech.weatherapp.di

import com.algartech.weatherapp.data.WeatherApi
import com.algartech.weatherapp.domain.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkConection {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideWeatherService(retrofit: Retrofit): WeatherApi {
        return retrofit.create(WeatherApi::class.java)
    }
}

