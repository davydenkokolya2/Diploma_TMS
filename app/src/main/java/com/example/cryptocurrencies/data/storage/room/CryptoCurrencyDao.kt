package com.example.cryptocurrencies.data.storage.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CryptoCurrencyDao {
    @Insert
    suspend fun saveData(CryptoCurrencyDBModel: List<CryptoCurrencyDBModel>)

    @Query("SELECT * FROM CryptoCurrencyDBModel WHERE uid > 0 LIMIT :indexFrom, 20")
    suspend fun getData(indexFrom: Int) : List<CryptoCurrencyDBModel>

    @Query("DELETE FROM CryptoCurrencyDBModel")
    fun dropTable()

}