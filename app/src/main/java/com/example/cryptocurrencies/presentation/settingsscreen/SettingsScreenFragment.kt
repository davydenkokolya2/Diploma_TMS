package com.example.cryptocurrencies.presentation.settingsscreen

import com.example.cryptocurrencies.databinding.SettingsScreenFragmentBinding
import com.example.cryptocurrencies.presentation.base.BaseFragment
import com.example.cryptocurrencies.presentation.base.BaseViewModel
import org.koin.android.ext.android.inject

class SettingsScreenFragment :
    BaseFragment<SettingsScreenFragmentBinding>(SettingsScreenFragmentBinding::inflate) {

    private val listOfCurrenciesViewModel: BaseViewModel by inject()

    override fun initView() {

    }
}