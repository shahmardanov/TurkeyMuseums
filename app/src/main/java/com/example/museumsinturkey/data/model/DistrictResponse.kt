package com.alijan.turkeymuseum.data.model


import com.google.gson.annotations.SerializedName

data class DistrictResponse(
    @SerializedName("creditUsed")
    val creditUsed: Int?,
    @SerializedName("data")
    val `data`: List<District>,
    @SerializedName("endpoint")
    val endpoint: String?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("messageTR")
    val messageTR: String?,
    @SerializedName("rowCount")
    val rowCount: Int?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("systemTime")
    val systemTime: Int?
)