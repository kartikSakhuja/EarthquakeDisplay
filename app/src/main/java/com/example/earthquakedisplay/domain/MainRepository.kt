package com.example.earthquakedisplay.domain

import com.example.earthquakedisplay.data.RetrofitService
import javax.inject.Inject

class MainRepository @Inject constructor(private val retrofitService: RetrofitService) {

    private val formatted = "true"
    private val north = "44.1"
    private val south = "-9.9"
    private val east = "-22.4"
    private val west = "55.2"
    private val username = "mkoppelman"

    suspend fun getAllEarthquake() =
            retrofitService.getAllEarthquake(formatted,north,south,east,west,username)
}

