package com.algartech.weatherapp.di

import com.algartech.weatherapp.data.database.WeatherDao
import com.algartech.weatherapp.data.database.WeatherDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WeatherModule {
    @Singleton
    @Provides
    fun provideWeatherDao(database: WeatherDatabase): WeatherDao {
        return database.weatherDao()
    }
}