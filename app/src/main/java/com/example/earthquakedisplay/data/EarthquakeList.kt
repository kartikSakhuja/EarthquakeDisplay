package com.example.earthquakedisplay.data

import com.google.gson.annotations.SerializedName

data class EarthquakeList(
    @SerializedName("earthquakes")
    val earthquakes: List<Earthquake>
)