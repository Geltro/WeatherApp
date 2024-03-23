package com.algartech.weatherapp.presentation

/*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// Definimos la interfaz para la API de OpenWeatherMap
interface WeatherService {
    @GET("weather")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String
    ): WeatherResponse
}

// Definimos el modelo de datos para la respuesta de la API
data class WeatherResponse(
    val main: Main
)

data class Main(
    val temp: Double
)

// Definimos el ViewModel para manejar los datos meteorológicos
class WeatherViewModel : ViewModel() {
    var weatherData by mutableStateOf<String>("")

    fun fetchWeatherData(city: String) {
        viewModelScope.launch {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val service = retrofit.create(WeatherService::class.java)
            val response = service.getWeather(city, "b6414ca4be408a45c7d8cc5c840bd066", "metric")

            weatherData = "Temperature: ${response.main.temp} °C"
        }
    }
}

// Componente de UI principal
@Composable
fun WeatherApp(viewModel: WeatherViewModel = viewModel()) {
    val context = LocalContext.current
    var city by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = city,
            onValueChange = { city = it },
            label = { Text("City") },
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Button(
            onClick = { viewModel.fetchWeatherData(city) },
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text("Get Weather")
        }

        // Se muestra la información meteorológica
        Text(
            text = viewModel.weatherData,
            textAlign = TextAlign.Center
        )
    }

}

// Función principal
@Composable
fun WeatherAppContent() {
    val viewModel: WeatherViewModel = viewModel()
    WeatherApp(viewModel = viewModel)
}*/