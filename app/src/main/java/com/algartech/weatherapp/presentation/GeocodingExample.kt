package com.algartech.weatherapp.presentation

/*
// Definimos la interfaz para la API de OpenWeatherMap
interface WeatherService {
    @GET("weather")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String
    ): DataWeather
}

// Definimos el modelo de datos para la respuesta de la API

data class DataWeather(
    @SerializedName("name") val name: String,
    @SerializedName("weather") val weather: List<Weather>,
    @SerializedName("main") val main: Main,
    @SerializedName("wind") val wind: Wind,
    @SerializedName("coord") val coord: Coord,
)
data class Weather(
    @SerializedName("description") val description: String,
    @SerializedName("main") val main: String
)
data class Main(
    @SerializedName("feels_like") val feels_like: Double,
    @SerializedName("grnd_level") val grnd_level: Int,
    @SerializedName("humidity") val humidity: Int,
    @SerializedName("pressure") val pressure: Int,
    @SerializedName("sea_level") val sea_level: Int,
    @SerializedName("temp") val temp: Double,
    @SerializedName("temp_max") val temp_max: Double,
    @SerializedName("temp_min") val temp_min: Double
)
data class Wind(
    @SerializedName("deg") val deg: Int,
    @SerializedName("gust") val gust: Double,
    @SerializedName("speed") val speed: Double
)
data class Coord(
    @SerializedName("lat") val lat: Double,
    @SerializedName("lon") val lon: Double
)


@Module
@InstallIn(SingletonComponent::class)
object NetworkConection {
    @Singleton
    @Provides
    fun provideWeatherService(): com.algartech.weatherapp.data.network.WeatherService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherService::class.java)
    }
}

// Definimos el ViewModel para manejar los datos meteorológicos
@HiltViewModel
class MapViewModel @Inject constructor(
    private val weatherService: WeatherService,
    @ApplicationContext private val context: Context
) : ViewModel() {

    private val _weatherData = MutableStateFlow<DataWeather?>(null)
    val weatherData: StateFlow<DataWeather?> = _weatherData

    fun getWeatherData(city: String) {
        viewModelScope.launch {
            val apiKey = context.getString(R.string.open_wather_key)
            try {
                val response = weatherService.getWeather(city, apiKey, "metric")
                _weatherData.value = response
                //Log.i("RRRRR", _weatherData.toString())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
// Componente de UI principal
@Composable
fun WeatherApp(viewModel: MapViewModel = viewModel()) {
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
            onClick = { viewModel.getWeatherData(city) },
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text("Get Weather")
        }

        // Se muestra la información meteorológica

    }

}

// Función principal
@Composable
fun WeatherAppContent() {
    val viewModel: MapViewModel = viewModel()
    WeatherApp(viewModel = viewModel)
}*/