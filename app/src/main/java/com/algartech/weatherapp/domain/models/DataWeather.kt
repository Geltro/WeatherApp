package com.algartech.weatherapp.domain.models

import com.algartech.weatherapp.data.model.CoordModel

data class DataWeather(
    val name: String,
    val coord: Coord,
)
