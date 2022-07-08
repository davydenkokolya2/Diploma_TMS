package com.example.cryptocurrencies.data.storage.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CryptoCurrencyDBModel::class] , version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun provideDao(): CryptoCurrencyDao
}