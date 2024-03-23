package com.algartech.weatherapp.domain

import com.algartech.weatherapp.data.WeatherService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

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
/*
@Singleton
@Provides
fun provideOkhttpClient(): OkHttpClient = OkHttpClient.Builder().apply { }.build()

@Singleton
@Provides
fun providesRetrofit(
    httpClient: OkHttpClient = provideOkhttpClient()
): Retrofit =
    Retrofit.Builder().apply {
        baseUrl(Constants.BASE_URL)
        client(httpClient)
        addConverterFactory(GsonConverterFactory.create())
    }.build()*/

/* val retrofit: WeatherService by lazy {
     Retrofit
         .Builder()
         .baseUrl(Constants.BASE_URL)
         .addConverterFactory(GsonConverterFactory.create())
         .build()
         .create(WeatherService::class.java)
 }*/
