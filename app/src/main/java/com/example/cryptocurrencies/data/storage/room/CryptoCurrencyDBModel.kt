package com.example.cryptocurrencies.data.storage.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.cryptocurrencies.data.network.RoiModel
import java.math.BigDecimal

@Entity(indices = [Index(value = ["id"], unique = true)])
data class CryptoCurrencyDBModel(
    @PrimaryKey val uid: Int?,
    @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "symbol") val symbol: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "image") val image: String,
    @ColumnInfo(name = "current_price") val currentPrice: Double,
    @ColumnInfo(name = "market_cap") val marketCap: String,

)
