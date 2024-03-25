package com.algartech.weatherapp.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.algartech.weatherapp.data.entities.DataWeatherEntity

@Dao
interface WeatherDao {
    @Query("SELECT * FROM weather_data WHERE name = :cityName ")
    fun getWeatherData(cityName: String): DataWeatherEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWeatherData(weatherDataEntity: DataWeatherEntity)
}