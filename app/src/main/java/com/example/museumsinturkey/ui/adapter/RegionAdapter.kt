package com.alijan.turkeymuseum.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alijan.turkeymuseum.data.model.Region
import com.example.museumsinturkey.databinding.ItemRegionBinding

class RegionAdapter : RecyclerView.Adapter<RegionAdapter.DistrictViewHolder>() {

    private val listOfRegions = ArrayList<Region>()
    lateinit var onClick: (district: String) -> Unit

    inner class DistrictViewHolder(val itemDistrictBinding: ItemRegionBinding) :
        RecyclerView.ViewHolder(itemDistrictBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DistrictViewHolder {
        val view = ItemRegionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DistrictViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listOfRegions.size
    }

    override fun onBindViewHolder(holder: DistrictViewHolder, position: Int) {
        val currentItem = listOfRegions[position]
        holder.itemDistrictBinding.district = currentItem.cities
        holder.itemDistrictBinding.textViewItemDistrictNumber.setText("${position + 1} -")
        holder.itemDistrictBinding.clDistrict.setOnClickListener {
            onClick(currentItem.cities!!)
        }
    }

    fun updateList(newList: List<Region>) {
        listOfRegions.clear()
        listOfRegions.addAll(newList)
        notifyDataSetChanged()
    }

}