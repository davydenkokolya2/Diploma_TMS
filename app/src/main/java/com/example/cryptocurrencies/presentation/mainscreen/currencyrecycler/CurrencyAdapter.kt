package com.example.cryptocurrencies.presentation.mainscreen.currencyrecycler

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.cryptocurrencies.R
import com.example.cryptocurrencies.model.CurrencyModel

class CurrencyAdapter : PagingDataAdapter<CurrencyModel, CurrencyViewHolder>(CurrencyModelComparator) {


    /*var data: List<CurrencyModel> = data*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_currency, parent, false)

        return CurrencyViewHolder(view)
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {

        val item = getItem(position)

        holder.imageCurrency.load(item?.image)
        holder.nameCurrency.text = item?.name
        holder.symbolCurrency.text = item?.symbol
        holder.currentPriceCurrency.text = item?.currentPrice.toString()
        holder.marketCupCurrency.text = item?.marketCup.toString()
    }

    object CurrencyModelComparator : DiffUtil.ItemCallback<CurrencyModel>() {
        override fun areItemsTheSame(oldItem: CurrencyModel, newItem: CurrencyModel): Boolean {
            // Id is unique.
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: CurrencyModel, newItem: CurrencyModel): Boolean {
            return oldItem == newItem
        }
    }
    /*override fun getItemCount(): Int {
        return data.size
    }*/
}