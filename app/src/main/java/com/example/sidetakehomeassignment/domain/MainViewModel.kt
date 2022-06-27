package com.example.sidetakehomeassignment.domain

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sidetakehomeassignment.data.EarthquakeList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository)  : ViewModel() {

    val earthquakeList = MutableLiveData<EarthquakeList>()
    val errorMessage = MutableLiveData<String>()

    fun getAllEarthquakes(){

        viewModelScope.launch {

            val response = repository.getAllEarthquake()
            earthquakeList.postValue(response.body())
        }
    }
}