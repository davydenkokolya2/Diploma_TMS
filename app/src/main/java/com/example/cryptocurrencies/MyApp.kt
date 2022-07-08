package com.example.cryptocurrencies

import android.app.Application
import androidx.room.Room
import com.example.cryptocurrencies.data.network.RemoteDataSourceRetrofit
import com.example.cryptocurrencies.data.network.RemoteDataSourceRetrofitImpl
import com.example.cryptocurrencies.data.repository.SamplePagingSource
import com.example.cryptocurrencies.data.storage.CryptoCurrencyDB
import com.example.cryptocurrencies.data.storage.CryptoCurrencyDBImpl
import com.example.cryptocurrencies.data.storage.room.AppDatabase
import com.example.cryptocurrencies.presentation.mainscreen.ListOfCurrenciesViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApp : Application() {

    private val dbModule: Module
        get() = module {
            single<CryptoCurrencyDB>{CryptoCurrencyDBImpl(get())}

            single {

                Room.databaseBuilder(
                    get(),
                    AppDatabase::class.java, "app-database"
                ).build()
            }
        }

    private val remoteModule: Module
        get() = module {
            single<RemoteDataSourceRetrofit> { RemoteDataSourceRetrofitImpl(get()) }

            single {
                Retrofit.Builder()
                    .baseUrl("https://api.coingecko.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
        }

    private val repositoryModule: Module
        get() = module {
            singleOf(::SamplePagingSource)
        }

    private val viewModelModule: Module
        get() = module {
            viewModelOf(::ListOfCurrenciesViewModel)
        }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(viewModelModule, remoteModule, dbModule, repositoryModule)
        }
    }
}