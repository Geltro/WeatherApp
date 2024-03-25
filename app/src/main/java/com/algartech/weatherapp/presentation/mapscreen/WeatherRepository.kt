package com.algartech.weatherapp.presentation.mapscreen

import com.algartech.weatherapp.data.WeatherApi
import com.algartech.weatherapp.data.database.WeatherDao
import com.algartech.weatherapp.data.model.DataWeatherModel
import com.algartech.weatherapp.domain.toEntity
import com.algartech.weatherapp.domain.toModel
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val weatherApi: WeatherApi,
    private val weatherDao: WeatherDao
) {

    suspend fun getWeather(city: String): DataWeatherModel {
        val localData = weatherDao.getWeatherData(city)
        if (localData != null) {
            return localData.toModel()
        }

        val remoteData = weatherApi.getWeather(city)
        weatherDao.insertWeatherData(remoteData.toEntity())

        return remoteData
    }
}
