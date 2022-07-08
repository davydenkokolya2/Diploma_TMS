package com.example.cryptocurrencies.data.storage

import com.example.cryptocurrencies.data.storage.room.CryptoCurrencyDBModel


interface CryptoCurrencyDB {
    suspend fun saveData(CryptoCurrencyDBModel: List<CryptoCurrencyDBModel>)
    suspend fun getData(indexFrom: Int) : List<CryptoCurrencyDBModel>
    fun dropTable()
}