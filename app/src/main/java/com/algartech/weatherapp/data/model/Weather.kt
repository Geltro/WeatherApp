package com.algartech.weatherapp.data.model

import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("description") val description: String,
    @SerializedName("main") val main: String
)