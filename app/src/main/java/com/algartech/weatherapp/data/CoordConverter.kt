package com.algartech.weatherapp.data

import androidx.room.TypeConverter
import com.algartech.weatherapp.data.entities.CoordEntity

class CoordConverter {
    @TypeConverter
    fun fromCoord(coord: CoordEntity): String {
        return "${coord.lat},${coord.lon}"
    }

    @TypeConverter
    fun toCoord(coordString: String): CoordEntity {
        val (lat, lon) = coordString.split(",")
        return CoordEntity(lat.toDouble(), lon.toDouble())
    }
}