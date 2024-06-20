package com.alijan.turkeymuseum.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alijan.turkeymuseum.data.model.Museum
import com.alijan.turkeymuseum.databinding.ItemMuseumBinding

class MuseumAdapter : RecyclerView.Adapter<MuseumAdapter.MuseumViewHolder>() {

    private val museumList = ArrayList<Museum>()

    inner class MuseumViewHolder(val itemMuseumBinding: ItemMuseumBinding) :
        RecyclerView.ViewHolder(itemMuseumBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MuseumViewHolder {
        val view = ItemMuseumBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MuseumViewHolder(view)
    }

    override fun getItemCount(): Int {
        return museumList.size
    }

    override fun onBindViewHolder(holder: MuseumViewHolder, position: Int) {
        val currentItem = museumList[position]
        holder.itemMuseumBinding.item = currentItem
    }

    fun updateList(newList: List<Museum>) {
        museumList.clear()
        museumList.addAll(newList)
        notifyDataSetChanged()
    }

}