package com.example.sidetakehomeassignment.domain

import com.example.sidetakehomeassignment.data.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {

    val formatted = "true"
    val north = "44.1"
    val south = "-9.9"
    val east = "-22.4"
    val west = "55.2"
    val username = "mkoppelman"

    suspend fun getAllEarthquake() =
            retrofitService.getAllEarthquake(formatted,north,south,east,west,username)
}

