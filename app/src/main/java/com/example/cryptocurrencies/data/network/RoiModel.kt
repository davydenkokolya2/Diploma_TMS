package com.example.cryptocurrencies.data.network

import com.google.gson.annotations.SerializedName

data class RoiModel(
    @SerializedName("times") val times: Double,
    @SerializedName("currency") val currency: String,
    @SerializedName("percentage") val percentage: Double
)
