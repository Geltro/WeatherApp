package com.algartech.weatherapp.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather_data")
data class DataWeatherEntity(
    @PrimaryKey
    val name: String,
    val coord: CoordEntity
) {
    fun setCoord(coord: CoordEntity) {
        this.coord
    }
}