package com.algartech.weatherapp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.algartech.weatherapp.ui.theme.Purple40
import com.algartech.weatherapp.ui.theme.Purple80
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MapScreen() {
    var query by remember { mutableStateOf(TextFieldValue("Buscar")) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Purple40)
    ) {
        GoogleMap(modifier = Modifier.fillMaxSize()) {
            Marker()
        }

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color.Transparent)
                .padding(top = 20.dp, bottom = 20.dp, start = 20.dp, end = 20.dp),
            value = query.text,
            onValueChange = { query = TextFieldValue(it) },
            placeholder = { Text("Buscar") },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search"
                )
            }, shape = RoundedCornerShape(50.dp),
            colors = TextFieldDefaults.textFieldColors(containerColor = Purple80)
        )




    }
}