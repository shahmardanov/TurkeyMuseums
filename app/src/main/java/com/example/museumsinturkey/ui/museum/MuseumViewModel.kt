package com.alijan.turkeymuseum.ui.museum

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alijan.turkeymuseum.data.model.Museum
import com.example.museumsinturkey.data.repo.MuseumRepository
import com.example.museumsinturkey.utill.NetworkResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MuseumViewModel @Inject constructor(private val museumRepository: MuseumRepository) :
    ViewModel() {

    private var _museums = MutableLiveData<NetworkResponse<List<Museum>>>()
    val museums: LiveData<NetworkResponse<List<Museum>>> get() = _museums

    fun getAllMuseum(city: String, district: String) {
        viewModelScope.launch {
            try {
                _museums.value = NetworkResponse.Loading()
                val resp = museumRepository.getMuseumByCityAndRegion(city, district)
                if (resp.isSuccessful) {
                    resp.body()?.let {
                        _museums.value = NetworkResponse.Success(it.data)
                    }
                } else {
                    _museums.value = NetworkResponse.Error(resp.errorBody().toString())
                }
            } catch (e: Exception) {
                _museums.value = NetworkResponse.Error(e.localizedMessage?.toString())
            }
        }
    }
}