package com.example.cryptocurrencies.data.network

import retrofit2.Retrofit
import retrofit2.create

class RemoteDataSourceRetrofitImpl(val retrofit: Retrofit) : RemoteDataSourceRetrofit {
    override suspend fun getData(
        vs_currency: String,
        per_page: Int,
        page: Int
    ): List<CryptoCurrencyRetrofitModel> {

        return (retrofit.create() as CryptoCurrencyApi).getData(
            vs_currency,
            "market_cap_desc",
            per_page,
            page,
            false
        )
    }
}