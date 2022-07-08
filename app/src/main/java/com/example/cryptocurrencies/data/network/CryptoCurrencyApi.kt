package com.example.cryptocurrencies.data.network

import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoCurrencyApi {
    @GET("api/v3/coins/markets?")
    suspend fun getData(
        @Query("vs_currency") vs_currency: String,
        @Query("order") order: String? = null,
        @Query("per_page") per_page: Int,
        @Query("page") page: Int,
        @Query("sparkline") sparkline: Boolean? = null
    ): List<CryptoCurrencyRetrofitModel>
}