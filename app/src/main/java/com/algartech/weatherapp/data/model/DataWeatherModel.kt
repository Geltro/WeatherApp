package com.algartech.weatherapp.data.model

import com.google.gson.annotations.SerializedName

data class DataWeatherModel(
    @SerializedName("name") val name: String,
    @SerializedName("coord") val coord: CoordModel,/*
    @SerializedName("weather") val weather: List<Weather>,
    @SerializedName("main") val main: Main,
    @SerializedName("wind") val wind: Wind,*/
)