package com.example.cryptocurrencies.data.repository

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.cryptocurrencies.data.network.RemoteDataSourceRetrofit
import com.example.cryptocurrencies.data.storage.CryptoCurrencyDB
import com.example.cryptocurrencies.data.storage.room.CryptoCurrencyDBModel
import com.example.cryptocurrencies.model.CurrencyModel

class SamplePagingSource(
    private val remoteDataSourceRetrofit: RemoteDataSourceRetrofit,
    private val cryptoCurrencyDB: CryptoCurrencyDB,
    private val query: String
) : PagingSource<Int, CurrencyModel>() {

    var indexFrom = 0

    override fun getRefreshKey(state: PagingState<Int, CurrencyModel>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CurrencyModel> {
        if (query.isEmpty()) {
            return LoadResult.Page(emptyList(), null, null)
        }

        val page: Int = params.key ?: 1
        val pageSize: Int = params.loadSize.coerceAtMost(20)

        val response =
            remoteDataSourceRetrofit.getData(vs_currency = query, per_page = pageSize, page = page)

        try {
            cryptoCurrencyDB.saveData(response.map {
                CryptoCurrencyDBModel(
                    null,
                    it.id?:ERROR,
                    it.symbol?:ERROR,
                    it.name?:ERROR,
                    it.image?:ERROR,
                    it.currentPrice?:0.0,
                    it.marketCap.toString()
                )
            })
        } catch (e: Exception) {
            Log.i("test", e.toString())
        }

        val responseDB = cryptoCurrencyDB.getData(indexFrom)
        indexFrom += 20

        val articles = responseDB.map {
            CurrencyModel(
                it.image,
                it.name,
                it.symbol,
                it.currentPrice,
                it.marketCap.toBigDecimal()
            )
        }

        val nextKey = if (articles.size < pageSize) null else page + 1
        val prevKey = if (page == 1) null else page - 1
        return LoadResult.Page(articles, prevKey, nextKey)
    }

    companion object {
        const val ERROR = "Error"
    }
}


