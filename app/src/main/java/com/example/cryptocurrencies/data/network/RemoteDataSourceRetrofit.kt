package com.example.cryptocurrencies.data.network

interface RemoteDataSourceRetrofit {
    suspend fun getData(vs_currency: String, per_page: Int, page: Int) : List<CryptoCurrencyRetrofitModel>
}