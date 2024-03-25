package com.algartech.weatherapp.data.model

import com.google.gson.annotations.SerializedName

data class CoordModel(
    @SerializedName("lat") val lat: Double,
    @SerializedName("lon") val lon: Double
)