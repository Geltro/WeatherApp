package com.algartech.weatherapp.presentation.mapscreen

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.algartech.weatherapp.R
import com.algartech.weatherapp.data.WeatherService
import com.algartech.weatherapp.data.model.DataWeather
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MapViewModel @Inject constructor(
    private val weatherService: WeatherService,
    @ApplicationContext private val context: Context
) : ViewModel() {

    private val _weatherData = MutableStateFlow<DataWeather?>(null)
    val weatherData: StateFlow<DataWeather?> = _weatherData

    fun getWeatherData(city: String) {
        viewModelScope.launch {
            val apiKey = context.getString(R.string.open_weather_key)
            try {
                val response = weatherService.getWeather(city, apiKey, "metric")
                _weatherData.value = response
                Log.i("RRRRR", _weatherData.toString())
                //print("RRESULTTTT: ${response.weather}")
            } catch (e: Exception) {
                // Manejar errores de solicitud
                e.printStackTrace()
            }
        }
    }
}