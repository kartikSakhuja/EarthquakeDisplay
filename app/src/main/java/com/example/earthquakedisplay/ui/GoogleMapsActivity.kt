package com.example.earthquakedisplay.ui

import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.earthquakedisplay.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import dagger.hilt.android.AndroidEntryPoint
import java.util.*


@AndroidEntryPoint
class GoogleMapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private var mMap: GoogleMap? = null
    private var lat : String? = null
    private var lng : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_google_maps)

        val intent = intent
        lat = intent.extras?.getString("Latitude")
        lng = intent.extras?.getString("Longitude")

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val location = LatLng(lat!!.toDouble(), lng!!.toDouble())
            mMap!!.addMarker(
                MarkerOptions()
                    .position(location)
                    .title("Earthquake Location" + ": " + location.latitude + "," + location.longitude)
            )

        mMap!!.moveCamera(CameraUpdateFactory.newLatLng(location))

    }
}

