package com.example.cryptocurrencies.model

import java.math.BigDecimal

data class CurrencyModel(
    val image: String,
    val name: String,
    val symbol: String,
    val currentPrice: Double,
    val marketCup: BigDecimal,
) {
}