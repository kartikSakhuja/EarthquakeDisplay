package com.example.earthquakedisplay.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.earthquakedisplay.R
import com.example.earthquakedisplay.data.Earthquake
import com.example.earthquakedisplay.databinding.AdapterEarthquakeBinding

class MainAdapter: RecyclerView.Adapter<MainViewHolder>() {

    var earthquakes = mutableListOf<Earthquake>()

    fun setEarthquakeList(earthquakes: List<Earthquake>) {
        this.earthquakes = earthquakes.toMutableList()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterEarthquakeBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }


    @SuppressLint("ResourceAsColor", "SetTextI18n")
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val earthquake = earthquakes[position]


        if (earthquake.magnitude >= 8.0){
            holder.itemView.setBackgroundColor(R.color.purple_500)
            holder.binding.txtMagnitude.text = "Magnitude : "+ earthquake.magnitude.toString()
        }
        else{
            holder.binding.txtMagnitude.text = "Magnitude : "+ earthquake.magnitude.toString()
        }

        holder.binding.txtDepth.text = "Depth : " + earthquake.depth.toString()
        holder.binding.txtLat.text = "Latitude : " + earthquake.lat.toString()
        holder.binding.txtLong.text = "Longitude : " + earthquake.lng.toString()
    }


    override fun getItemCount(): Int {
        return earthquakes.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

}


class MainViewHolder(val binding: AdapterEarthquakeBinding) : RecyclerView.ViewHolder(binding.root) {
}