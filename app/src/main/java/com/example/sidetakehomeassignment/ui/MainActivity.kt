package com.example.sidetakehomeassignment.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.sidetakehomeassignment.*
import com.example.sidetakehomeassignment.databinding.ActivityMainBinding
import com.example.sidetakehomeassignment.domain.MainRepository
import com.example.sidetakehomeassignment.domain.MainViewModel
import com.example.sidetakehomeassignment.domain.MyViewModelFactory
import com.example.sidetakehomeassignment.util.AppModule
import com.example.sidetakehomeassignment.util.OnItemClickListener
import com.example.sidetakehomeassignment.util.addOnItemClickListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    private val retrofitService = AppModule.providesEarthquakeApi()
    val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, MyViewModelFactory(MainRepository(retrofitService))).get(MainViewModel::class.java)

        viewModel.getAllEarthquakes()

        binding.recyclerview.adapter = adapter

        viewModel.earthquakeList.observe(this, Observer {
            binding.progressBar.isVisible = false
            adapter.setEarthquakeList(it.earthquakes)
            adapter.notifyDataSetChanged()
        })

        viewModel.errorMessage.observe(this, Observer {
            binding.progressBar.isVisible = false
            Toast.makeText(this,"Please try again after sometime",Toast.LENGTH_LONG).show()
        })

        binding.recyclerview.addOnItemClickListener(object: OnItemClickListener {
            override fun onItemClicked(position: Int, view: View) {
                adapter.earthquakes.get(position).lat
                val intent = Intent(this@MainActivity, GoogleMapsActivity::class.java)
                intent.putExtra("Latitude", adapter.earthquakes.get(position).lat.toString())
                intent.putExtra("Longitude", adapter.earthquakes.get(position).lng.toString())
                startActivity(intent)
            }
        })

    }
}