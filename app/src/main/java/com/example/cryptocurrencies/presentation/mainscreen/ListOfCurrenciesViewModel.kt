package com.example.cryptocurrencies.presentation.mainscreen

import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.cryptocurrencies.data.network.RemoteDataSourceRetrofit
import com.example.cryptocurrencies.data.repository.SamplePagingSource
import com.example.cryptocurrencies.data.storage.CryptoCurrencyDB
import com.example.cryptocurrencies.presentation.base.BaseViewModel

class ListOfCurrenciesViewModel(
    private val remoteDataSourceRetrofit: RemoteDataSourceRetrofit,
    private val cryptoCurrencyDB: CryptoCurrencyDB
) :
    BaseViewModel() {

    val flow = Pager(
        PagingConfig(pageSize = 20)
    ) {
        SamplePagingSource(remoteDataSourceRetrofit, cryptoCurrencyDB, query = "usd")
    }.flow
        .cachedIn(viewModelScope)
}