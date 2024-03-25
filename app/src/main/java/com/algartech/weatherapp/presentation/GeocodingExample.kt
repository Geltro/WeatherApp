package com.algartech.weatherapp.presentation

/*
//data.model
data class Coord(
    @SerializedName("lat") val lat: Double,
    @SerializedName("lon") val lon: Double
)
data class DataWeather(
    @SerializedName("name") val name: String,
    @SerializedName("weather") val weather: List<Weather>,
    @SerializedName("main") val main: Main,
    @SerializedName("wind") val wind: Wind,
    @SerializedName("coord") val coord: Coord,
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

data class Weather(
    @SerializedName("description") val description: String,
    @SerializedName("main") val main: String
)
data class Wind(
    @SerializedName("deg") val deg: Int,
    @SerializedName("gust") val gust: Double,
    @SerializedName("speed") val speed: Double
)

//data
interface WeatherService {
    @GET("weather")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String
    ): DataWeather
}
//domain
object Constants {
    const val BASE_URL = "https://api.openweathermap.org/data/2.5/"

}

@Module
@InstallIn(SingletonComponent::class)
object NetworkConection {
    @Singleton
    @Provides
    fun provideWeatherService(): WeatherService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherService::class.java)
    }
}

//Presentation
//UI
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapScreen(
    mapViewModel: MapViewModel = hiltViewModel()
) {
    var city by remember { mutableStateOf("") }
    val weatherData by mapViewModel.weatherData.collectAsState()
    //mapViewModel.getWeatherData("London")
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
                .padding(top = 20.dp, bottom = 20.dp, start = 20.dp, end = 20.dp),
            value = city,
            onValueChange = { city = it },
            placeholder = { Text("Ciudad") },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            singleLine = true,
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
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

//View Model
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

*/