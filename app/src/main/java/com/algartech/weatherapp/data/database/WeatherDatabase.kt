package com.algartech.weatherapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.algartech.weatherapp.data.CoordConverter
import com.algartech.weatherapp.data.entities.DataWeatherEntity

@Database(entities = [DataWeatherEntity::class], version = 1, exportSchema = false)
@TypeConverters(CoordConverter::class)
abstract class WeatherDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}