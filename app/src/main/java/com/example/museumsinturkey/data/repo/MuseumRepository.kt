package com.example.museumsinturkey.data.repo

import com.alijan.turkeymuseum.data.model.CityResponse
import com.alijan.turkeymuseum.data.model.DistrictResponse
import com.alijan.turkeymuseum.data.model.MuseumResponse
import com.example.museumsinturkey.data.api.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class MuseumRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getAllCity(): Response<CityResponse> = withContext(Dispatchers.IO) {
        return@withContext apiService.getAllCity()
    }

    suspend fun getAllDistrict(city: String): Response<DistrictResponse> =
        withContext(Dispatchers.IO) {
            return@withContext apiService.getAllDistrict(city = city)
        }

    suspend fun getMuseumByCityAndDistrict(
        city: String,
        district: String
    ): Response<MuseumResponse> = withContext(Dispatchers.IO) {
        return@withContext apiService.getMuseumByCityAndDistrict(city = city, district = district)
    }
}