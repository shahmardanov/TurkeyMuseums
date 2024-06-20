package com.alijan.turkeymuseum.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alijan.turkeymuseum.data.model.City
import com.example.museumsinturkey.databinding.ItemCityBinding

class CityAdapter : RecyclerView.Adapter<CityAdapter.CityViewHolder>() {

    private val listOfCity = ArrayList<City>()
    lateinit var onClick: (city: String) -> Unit

    inner class CityViewHolder(val itemCityBinding: ItemCityBinding) :
        RecyclerView.ViewHolder(itemCityBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val view = ItemCityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CityViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listOfCity.size
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val currentItem = listOfCity[position]
        holder.itemCityBinding.city = currentItem.cities
        holder.itemCityBinding.textViewItemCityNumber.setText("${position + 1} -")
        holder.itemCityBinding.clItemCity.setOnClickListener {
            onClick(currentItem.cities!!)
        }
    }

    fun updateList(newList: List<City>) {
        listOfCity.clear()
        listOfCity.addAll(newList)
        notifyDataSetChanged()
    }

}