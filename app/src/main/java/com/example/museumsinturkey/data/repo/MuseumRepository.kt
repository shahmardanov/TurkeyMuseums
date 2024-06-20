package com.example.museumsinturkey.data.repo

import com.alijan.turkeymuseum.data.api.APIServices
import com.alijan.turkeymuseum.data.model.CityResponse
import com.alijan.turkeymuseum.data.model.DistrictResponse
import com.alijan.turkeymuseum.data.model.MuseumResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class MuseumRepository @Inject constructor(private val apiServices: APIServices) {

    suspend fun getAllCity(): Response<CityResponse> = withContext(Dispatchers.IO) {
        return@withContext apiServices.getAllCity()
    }

    suspend fun getAllDistrict(city: String): Response<DistrictResponse> =
        withContext(Dispatchers.IO) {
            return@withContext apiServices.getAllDistrict(city = city)
        }

    suspend fun getMuseumByCityAndDistrict(
        city: String,
        district: String
    ): Response<MuseumResponse> = withContext(Dispatchers.IO) {
        return@withContext apiServices.getMuseumByCityAndDistrict(city = city, district = district)
    }
}