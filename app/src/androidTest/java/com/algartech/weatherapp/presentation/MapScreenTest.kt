package com.algartech.weatherapp.presentation

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.performTextReplacement
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.algartech.weatherapp.data.model.Coord
import com.algartech.weatherapp.data.model.DataWeather
import com.algartech.weatherapp.data.model.Main
import com.algartech.weatherapp.data.model.Weather
import com.algartech.weatherapp.data.model.Wind
import com.algartech.weatherapp.presentation.mapscreen.MapScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

// Datos de ejemplo
val data = DataWeather(
    name = "City",
    weather = listOf(Weather("Clear", "Clear sky")),
    main = Main(25.0, 200, 30, 101, 8, 8.9, 5.9, 9.6),
    wind = Wind(90, 5.0, 10.0),
    coord = Coord(59.9, 95.5)
)

@RunWith(AndroidJUnit4::class)
class MapScreenTest {


    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testWeatherInfoContent() {


        // Renderiza el componente
        composeTestRule.setContent {
            DataWeather(data.name, data.weather, data.main, data.wind, data.coord)
        }

        // Verifica que el nombre de la ciudad se muestre correctamente
        composeTestRule.onNodeWithText("City").assertExists()

        // Verifica que la información del clima se muestre correctamente
        composeTestRule.onNodeWithText("Clear").assertExists()
        composeTestRule.onNodeWithText("Clear sky").assertExists()

        // Verifica que la información de temperatura se muestre correctamente
        composeTestRule.onNodeWithText("Temperature: 25.0").assertExists()
        composeTestRule.onNodeWithText("Max Temperature: 30.0").assertExists()
        composeTestRule.onNodeWithText("Min Temperature: 20.0").assertExists()
        composeTestRule.onNodeWithText("Feels Like: 25.0").assertExists()

        // Verifica que la información del viento se muestre correctamente
        composeTestRule.onNodeWithText("Wind").performClick()
        composeTestRule.onNodeWithText("Degree: 90.0").assertExists()
        composeTestRule.onNodeWithText("Gust: 10.0").assertExists()
        composeTestRule.onNodeWithText("Speed: 5.0").assertExists()
    }

    @Test
    fun testMapScreenContent() {
        // Configurar ViewModel simulado
        val viewModel = MockMapViewModel()

        // Renderizar la pantalla del mapa
        composeTestRule.setContent {
            MapScreen()
        }

        // Verificar que el campo de texto esté presente y sea modificable
        composeTestRule.onNodeWithTag("outlinedTextField").assertExists()
        composeTestRule.onNodeWithTag("outlinedTextField").assertIsEnabled().assertHasClickAction()
        composeTestRule.onNodeWithTag("outlinedTextField").performTextReplacement("New York")

        // Aquí puedes agregar más aserciones según sea necesario para verificar el comportamiento de la pantalla
    }
}


