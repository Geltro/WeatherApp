package com.algartech.weatherapp.presentation.mapscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.algartech.weatherapp.R
import com.algartech.weatherapp.presentation.components.MapComponent
import com.algartech.weatherapp.ui.theme.Purple40
import com.algartech.weatherapp.ui.theme.Purple80


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapScreen(
    mapViewModel: MapViewModel = hiltViewModel()
) {
    var city by remember { mutableStateOf("") }
    val weatherData by mapViewModel.weatherData.collectAsState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Purple40)
    ) {
        weatherData?.let { data ->
            MapComponent(data)
        }

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color.Transparent)
                .padding(top = 20.dp, bottom = 20.dp, start = 20.dp, end = 20.dp)
                .testTag("outlinedTextField"),
            value = city,
            onValueChange = { city = it },
            placeholder = { Text(stringResource(id = R.string.city)) },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Text
            ),
            singleLine = true,
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(id = R.string.search),
                    modifier = Modifier.clickable {
                        mapViewModel.getWeatherData(city)
                    }
                )
            }, shape = RoundedCornerShape(50.dp),
            colors = TextFieldDefaults.textFieldColors(containerColor = Purple80)
        )
        Spacer(
            modifier = Modifier
                .size(20.dp)
                .background(Color.Transparent)
        )


    }
}




