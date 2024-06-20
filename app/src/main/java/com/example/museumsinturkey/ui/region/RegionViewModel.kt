package com.alijan.turkeymuseum.ui.city

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alijan.turkeymuseum.data.model.Region
import com.example.museumsinturkey.data.repo.MuseumRepository
import com.example.museumsinturkey.utill.NetworkResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegionViewModel @Inject constructor(private val museumRepository: MuseumRepository) :
    ViewModel() {

    private var region2 = MutableLiveData<NetworkResponse<List<Region>>>()
    val region: LiveData<NetworkResponse<List<Region>>> get() = region2

    fun getAllDistrict(city: String) {
        viewModelScope.launch {
            try {
                region2.value = NetworkResponse.Loading()
                val resp = museumRepository.getAllRegions(city)
                if (resp.isSuccessful) {
                    resp.body()?.let {
                        region2.value = NetworkResponse.Success(it.data)
                    }
                } else {
                    region2.value = NetworkResponse.Error(resp.errorBody().toString())
                }
            } catch (e: Exception) {
                region2.value = NetworkResponse.Error(e.localizedMessage?.toString())
            }
        }
    }

}