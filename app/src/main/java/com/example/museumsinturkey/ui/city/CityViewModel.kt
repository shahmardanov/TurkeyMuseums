package com.alijan.turkeymuseum.ui.city

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alijan.turkeymuseum.data.model.City
import com.example.museumsinturkey.data.repo.MuseumRepository
import com.example.museumsinturkey.utill.NetworkResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CityViewModel @Inject constructor(private val museumRepository: MuseumRepository) :
    ViewModel() {

    private var _cities = MutableLiveData<NetworkResponse<List<City>>>()
    val cities: LiveData<NetworkResponse<List<City>>> get() = _cities

    init {
        getAllCity()
    }

    private fun getAllCity() {
        viewModelScope.launch {
            try {
                _cities.value = NetworkResponse.Loading()
                val resp = museumRepository.getAllCity()
                if (resp.isSuccessful) {
                    resp.body()?.let {
                        _cities.value = NetworkResponse.Success(it.data)
                    }
                } else {
                    _cities.value = NetworkResponse.Error(resp.errorBody().toString())
                }
            } catch (e: Exception) {
                _cities.value = NetworkResponse.Error(e.localizedMessage?.toString())
            }
        }
    }

}