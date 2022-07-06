package com.example.earthquakedisplay.util

import com.example.earthquakedisplay.data.RetrofitService
import com.example.earthquakedisplay.domain.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val BASE_URL = "http://api.geonames.org"

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesEarthquakeApi() : RetrofitService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RetrofitService::class.java)

    @Singleton
    @Provides
    fun provideMainRepository(api:RetrofitService) : MainRepository = MainRepository(api)

}