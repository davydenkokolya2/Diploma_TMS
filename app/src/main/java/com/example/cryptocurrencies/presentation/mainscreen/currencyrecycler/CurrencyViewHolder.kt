package com.example.cryptocurrencies.presentation.mainscreen.currencyrecycler

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptocurrencies.R

class CurrencyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val imageCurrency = view.findViewById<ImageView>(R.id.imageCurrency)
    val symbolCurrency = view.findViewById<TextView>(R.id.symbolCurrency)
    val nameCurrency = view.findViewById<TextView>(R.id.nameCurrency)
    val currentPriceCurrency = view.findViewById<TextView>(R.id.currentPriceCurrency)
    val marketCupCurrency = view.findViewById<TextView>(R.id.marketCupCurrency)
}