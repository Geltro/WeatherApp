package com.algartech.weatherapp.data

import com.algartech.weatherapp.data.model.DataWeather
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("weather")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String
    ): DataWeather
}