package com.example.sidetakehomeassignment.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("/earthquakesJSON")
    suspend fun getAllEarthquake(@Query("formatted") formatted : String,
                         @Query("north") north : String,
                         @Query("south") south : String,
                         @Query("east") east : String,
                         @Query("west") west : String,
                         @Query("username") username : String) : Response<EarthquakeList>


}