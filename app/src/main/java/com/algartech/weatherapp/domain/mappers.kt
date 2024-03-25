package com.algartech.weatherapp.domain

import com.algartech.weatherapp.data.entities.CoordEntity
import com.algartech.weatherapp.data.entities.DataWeatherEntity
import com.algartech.weatherapp.data.model.CoordModel
import com.algartech.weatherapp.data.model.DataWeatherModel
import com.algartech.weatherapp.domain.models.Coord
import com.algartech.weatherapp.domain.models.DataWeather

fun DataWeatherEntity.toModel(): DataWeather {
    return DataWeather(name = this.name, this.coord.toModel())
}

fun CoordEntity.toModel(): Coord {
    return Coord(
        lat = this.lat, lon = this.lon
    )
}
fun DataWeather.toEntity(): DataWeatherEntity {
    return DataWeatherEntity(
        name = this.name,
        coord = this.coord.toEntity()
    )
}

fun Coord.toEntity(): CoordEntity {
    return CoordEntity(
        lat = this.lat,
        lon = this.lon
    )
}

fun DataWeatherModel.toEntity(): DataWeather {
    return DataWeather(
        name = this.name,
        coord = this.coord.toEntity()
    )
}

fun CoordModel.toEntity(): Coord {
    return Coord(
        lat = this.lat,
        lon = this.lon
    )
}

fun DataWeather.toModel(): DataWeatherModel {
    return DataWeatherModel(
        name = this.name,
        coord = this.coord.toModel()
    )
}

fun Coord.toModel(): CoordModel {
    return CoordModel(
        lat = this.lat,
        lon = this.lon
    )
}