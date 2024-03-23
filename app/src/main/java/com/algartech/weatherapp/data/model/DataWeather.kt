package com.algartech.weatherapp.data.model

import com.google.gson.annotations.SerializedName

data class DataWeather(
    @SerializedName("name") val name: String,
    @SerializedName("weather") val weather: List<Weather>,
    @SerializedName("main") val main: Main,
    @SerializedName("wind") val wind: Wind,
    @SerializedName("coord") val coord: Coord,
)