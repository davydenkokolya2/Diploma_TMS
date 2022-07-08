package com.example.cryptocurrencies.presentation.detailsscreen

import com.example.cryptocurrencies.databinding.DetailsScreenFragmentBinding
import com.example.cryptocurrencies.presentation.base.BaseFragment
import com.example.cryptocurrencies.presentation.base.BaseViewModel
import org.koin.android.ext.android.inject

class DetailsScreenFragment :
    BaseFragment<DetailsScreenFragmentBinding>(DetailsScreenFragmentBinding::inflate) {

    private val listOfCurrenciesViewModel: BaseViewModel by inject()


    override fun initView() {

    }
}