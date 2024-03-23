package com.algartech.weatherapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.gson.annotations.SerializedName
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.MarkerInfoWindowContent
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapComponent(
    latitude: Double,
    longitude: Double,
    name: String,
    feels_like: Double,
    grnd_level: Int,
    humidity: Int,
    pressure: Int,
    sea_level: Int,
    temp: Double,
    temp_max: Double,
    temp_min: Double,
    deg: Int,
    gust: Double,
    speed: Double


) {
    val positionState = rememberCameraPositionState {
        // Inicializa la posición de la cámara al crear el estado
        position =
            CameraPosition(LatLng(latitude, longitude), 12f, 0f, 0f) // Zoom de 12 por ejemplo
    }

    // Animar la cámara cuando cambia la posición
    LaunchedEffect(positionState.position) {
        positionState.animate(CameraUpdateFactory.newLatLng(LatLng(latitude, longitude)))
    }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        uiSettings = MapUiSettings(),
        contentDescription = "Google Map",
        cameraPositionState = positionState

    ) {
        MarkerInfoWindowContent(
            state = MarkerState(LatLng(latitude, longitude)),
            title = name,
            content = {
                // Personaliza el contenido de la ventana de información aquí
                Column {
                    Text(
                        text = name,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Feels like: $feels_like",
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                    Text(
                        text = "Ground Level: $grnd_level",
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                    Text(
                        text = "Feels like: $feels_like",
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                    Text(
                        text = "Feels like: $feels_like",
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                    Text(
                        text = "Feels like: $feels_like",
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                }
            }
        )
    }
}