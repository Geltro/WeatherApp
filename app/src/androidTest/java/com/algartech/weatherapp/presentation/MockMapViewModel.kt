package com.algartech.weatherapp.presentation

import androidx.lifecycle.ViewModel
import com.algartech.weatherapp.data.model.Coord
import com.algartech.weatherapp.data.model.DataWeather
import com.algartech.weatherapp.data.model.Main
import com.algartech.weatherapp.data.model.Weather
import com.algartech.weatherapp.data.model.Wind
import kotlinx.coroutines.flow.MutableStateFlow

class MockMapViewModel : ViewModel() {
    val weatherData: MutableStateFlow<DataWeather?> = MutableStateFlow(null)

    fun getWeatherData(city: String) {
        // Simulamos la recepción de datos de clima para la ciudad especificada
        weatherData.value = DataWeather(
            name = "City",
            weather = listOf(Weather("Clear", "Clear sky")),
            main = Main(25.0, 200, 30, 101, 8, 8.9, 5.9, 9.6),
            wind = Wind(90, 5.0, 10.0),
            coord = Coord(59.9, 95.5)
        )
    }
}
