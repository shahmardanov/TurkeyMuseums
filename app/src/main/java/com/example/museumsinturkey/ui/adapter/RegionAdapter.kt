package com.alijan.turkeymuseum.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alijan.turkeymuseum.data.model.District
import com.alijan.turkeymuseum.databinding.ItemDistrictBinding

class RegionAdapter : RecyclerView.Adapter<RegionAdapter.DistrictViewHolder>() {

    private val districtList = ArrayList<District>()
    lateinit var onClick: (district: String) -> Unit

    inner class DistrictViewHolder(val itemDistrictBinding: ItemDistrictBinding) :
        RecyclerView.ViewHolder(itemDistrictBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DistrictViewHolder {
        val view = ItemDistrictBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DistrictViewHolder(view)
    }

    override fun getItemCount(): Int {
        return districtList.size
    }

    override fun onBindViewHolder(holder: DistrictViewHolder, position: Int) {
        val currentItem = districtList[position]
        holder.itemDistrictBinding.district = currentItem.cities
        holder.itemDistrictBinding.textViewItemDistrictNumber.setText("${position + 1} -")
        holder.itemDistrictBinding.clDistrict.setOnClickListener {
            onClick(currentItem.cities!!)
        }
    }

    fun updateList(newList: List<District>) {
        districtList.clear()
        districtList.addAll(newList)
        notifyDataSetChanged()
    }

}