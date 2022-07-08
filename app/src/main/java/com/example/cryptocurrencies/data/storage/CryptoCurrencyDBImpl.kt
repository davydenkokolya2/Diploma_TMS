package com.example.cryptocurrencies.data.storage

import com.example.cryptocurrencies.data.storage.room.AppDatabase
import com.example.cryptocurrencies.data.storage.room.CryptoCurrencyDBModel

class CryptoCurrencyDBImpl(database: AppDatabase) : CryptoCurrencyDB {

    private val dao = database.provideDao()

    override suspend fun saveData(CryptoCurrencyDBModel: List<CryptoCurrencyDBModel>) {
        dao.saveData(CryptoCurrencyDBModel)
    }

    override suspend fun getData(indexFrom: Int): List<CryptoCurrencyDBModel> {
        return dao.getData(indexFrom)
    }

    override fun dropTable() {
    }

}