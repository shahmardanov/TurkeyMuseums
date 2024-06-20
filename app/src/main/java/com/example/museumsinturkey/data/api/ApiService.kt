package com.example.museumsinturkey.data.api

import com.alijan.turkeymuseum.data.model.CityResponse
import com.alijan.turkeymuseum.data.model.MuseumResponse
import com.alijan.turkeymuseum.data.model.RegionResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("service/museum/cities")
    suspend fun getAllCity(@Query("apiKey") apiKey: String = "gvloSjuIbqB3u0EDg5OrFcIOG2ac74gAgi46NVEYweHnNfaEcF6yajYAxC8M")
            : Response<CityResponse>

    @GET("service/museum/cities")
    suspend fun getAllDistrict(
        @Query("apiKey") apiKey: String = "gvloSjuIbqB3u0EDg5OrFcIOG2ac74gAgi46NVEYweHnNfaEcF6yajYAxC8M",
        @Query("city") city: String
    ): Response<RegionResponse>

    @GET("service/museum")
    suspend fun getMuseumByCityAndDistrict(
        @Query("apiKey") apiKey: String = "gvloSjuIbqB3u0EDg5OrFcIOG2ac74gAgi46NVEYweHnNfaEcF6yajYAxC8M",
        @Query("city") city: String,
        @Query("region") district: String
    ): Response<MuseumResponse>
}