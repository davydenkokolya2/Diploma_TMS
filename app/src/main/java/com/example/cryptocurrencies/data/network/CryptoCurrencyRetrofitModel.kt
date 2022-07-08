package com.example.cryptocurrencies.data.network

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class CryptoCurrencyRetrofitModel(
    @SerializedName("id") var id: String? = null,
    @SerializedName("symbol") var symbol: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("image") var image: String? = null,
    @SerializedName("current_price") var currentPrice: Double? = null,
    @SerializedName("market_cap") var marketCap: BigDecimal? = null,
    @SerializedName("market_cap_rank") var marketCapRank: Int? = null,
    @SerializedName("fully_diluted_varuation") var fullyDilutedvaruation: BigDecimal? = null,
    @SerializedName("total_volume") var totalVolume: BigDecimal? = null,
    @SerializedName("high_24h") var low24h: Double? = null,
    @SerializedName("price_change_24h") var priceChange24h: Double? = null,
    @SerializedName("price_change_percentage_24h") var priceChangePercentage24h: Double? = null,
    @SerializedName("market_cap_change_24h") var marketCapChange24h: Double? = null,
    @SerializedName("market_cap_change_percentage_24h") var marketCapChangePercentage24h: Double? = null,
    @SerializedName("circulating_supply") var circulatingSupply: Double? = null,
    @SerializedName("total_supply") var totalSupply: Double? = null,
    @SerializedName("max_supply") var maxSupply: BigDecimal? = null,
    @SerializedName("ath") var ath: Double? = null,
    @SerializedName("ath_change_percentage") var athChangePercentage: Double? = null,
    @SerializedName("ath_date") var athDate: String? = null,
    @SerializedName("atl") var atl: Double? = null,
    @SerializedName("atl_change_percentage") var atlChangePercentage: Double? = null,
    @SerializedName("atl_date") var atlDate: String? = null,
    @SerializedName("roi") var roi: RoiModel? = null,
    @SerializedName("last_updated") var lastUpdated: String? = null
)
