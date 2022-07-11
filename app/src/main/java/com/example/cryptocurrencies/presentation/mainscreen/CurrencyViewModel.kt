package com.example.cryptocurrencies.presentation.mainscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocurrencies.model.CurrencyModel
import com.example.cryptocurrencies.presentation.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CurrencyViewModel : ViewModel() {

    private var _state = MutableStateFlow<CurrencyModel?>(null)
    val state: StateFlow<CurrencyModel?> = _state

    fun changeCurrencyModel(currencyModel: CurrencyModel) {
        viewModelScope.launch(Dispatchers.IO) {
            Log.i("test", currencyModel.toString())
            _state.emit(currencyModel)

            //Log.i("test", state.value.toString())
        }
    }

}