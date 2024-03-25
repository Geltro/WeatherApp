package com.algartech.weatherapp.presentation.mapscreen

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.algartech.weatherapp.R
import com.algartech.weatherapp.data.WeatherApi
import com.algartech.weatherapp.data.database.WeatherDao
import com.algartech.weatherapp.data.entities.DataWeatherEntity
import com.algartech.weatherapp.data.model.DataWeatherModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MapViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository
) : ViewModel() {

    private val _weatherData = MutableStateFlow<DataWeatherModel?>(null)
    val weatherData: StateFlow<DataWeatherModel?> = _weatherData

    fun getWeatherData(city: String) {
        viewModelScope.launch {
            try {
                val weather = weatherRepository.getWeather(city)
                _weatherData.value = weather
            } catch (e: Exception) {
                // Manejar errores de solicitud
                e.printStackTrace()
            }
        }
    }
}