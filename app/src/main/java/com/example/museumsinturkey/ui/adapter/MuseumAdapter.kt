package com.alijan.turkeymuseum.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alijan.turkeymuseum.data.model.Museum
import com.example.museumsinturkey.databinding.ItemMuseumBinding

class MuseumAdapter : RecyclerView.Adapter<MuseumAdapter.MuseumViewHolder>() {

    private val listOfMuseum = ArrayList<Museum>()

    inner class MuseumViewHolder(val itemMuseumBinding: ItemMuseumBinding) :
        RecyclerView.ViewHolder(itemMuseumBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MuseumViewHolder {
        val view = ItemMuseumBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MuseumViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listOfMuseum.size
    }

    override fun onBindViewHolder(holder: MuseumViewHolder, position: Int) {
        val currentItem = listOfMuseum[position]
        holder.itemMuseumBinding.item = currentItem
    }

    fun updateList(newList: List<Museum>) {
        listOfMuseum.clear()
        listOfMuseum.addAll(newList)
        notifyDataSetChanged()
    }

}