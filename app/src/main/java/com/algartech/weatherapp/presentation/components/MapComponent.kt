package com.algartech.weatherapp.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.algartech.weatherapp.R
import com.algartech.weatherapp.data.model.DataWeather
import com.algartech.weatherapp.data.model.Main
import com.algartech.weatherapp.data.model.Weather
import com.algartech.weatherapp.data.model.Wind
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.MarkerInfoWindowContent
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapComponent(data: DataWeather) {
    val positionState = rememberCameraPositionState {
        // Inicializa la posición de la cámara al crear el estado
        position = CameraPosition(LatLng(data.coord.lat, data.coord.lon), 12f, 0f, 0f)
    }

    // Animar la cámara cuando cambia la posición
    LaunchedEffect(positionState.position) {
        positionState.animate(CameraUpdateFactory.newLatLng(LatLng(data.coord.lat, data.coord.lon)))
    }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        uiSettings = MapUiSettings(),
        contentDescription = stringResource(id = R.string.google_map),
        cameraPositionState = positionState
    ) {
        MarkerInfoWindowContent(
            state = MarkerState(LatLng(data.coord.lat, data.coord.lon)),
            title = data.name,
            content = {
                WeatherInfo(
                    name = data.name,
                    weatherData = data.weather.firstOrNull(),
                    mainData = data.main,
                    windData = data.wind
                )
            }
        )
    }
}

@Composable
private fun WeatherInfo(name: String, weatherData: Weather?, mainData: Main, windData: Wind) {
    Column {
        Text(
            text = name,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Row {
            Column {
                EditableText(text = stringResource(id = R.string.weather), tile = true)
                weatherData?.let { weather ->
                    EditableText(text = weather.main)
                    EditableText(text = weather.description)
                }
                EditableText(text = stringResource(id = R.string.ground_level) + mainData.grnd_level)
                EditableText(text = stringResource(id = R.string.humidity) + mainData.humidity)
                EditableText(text = stringResource(id = R.string.pressure) + mainData.pressure)
                EditableText(text = stringResource(id = R.string.sea_level) + mainData.sea_level)
            }
            Spacer(modifier = Modifier.size(8.dp))
            Column {
                EditableText(text = stringResource(id = R.string.temp), true)
                EditableText(text = stringResource(id = R.string.temperature) + mainData.temp)
                EditableText(text = stringResource(id = R.string.max_temperature) + mainData.temp_max)
                EditableText(text = stringResource(id = R.string.min_temperature) + mainData.temp_min)
                EditableText(text = stringResource(id = R.string.feels_like) + mainData.feels_like)

                EditableText(text = stringResource(id = R.string.wind), true)
                EditableText(text = stringResource(id = R.string.degree) + windData.deg)
                EditableText(text = stringResource(id = R.string.gust) + windData.gust)
                EditableText(text = stringResource(id = R.string.speed) + windData.speed)
            }
        }
    }
}