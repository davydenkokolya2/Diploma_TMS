package com.example.cryptocurrencies.presentation.splashscreen

import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.cryptocurrencies.data.storage.CryptoCurrencyDB
import com.example.cryptocurrencies.databinding.SplashScreenFragmentBinding
import com.example.cryptocurrencies.presentation.base.BaseFragment
import com.example.cryptocurrencies.presentation.base.BaseViewModel
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class SplashScreenFragment :
    BaseFragment<SplashScreenFragmentBinding>(SplashScreenFragmentBinding::inflate) {

    private val listOfCurrenciesViewModel: BaseViewModel by inject()

    override fun initView() {
        binding.button.setOnClickListener {
            findNavController().navigate(SplashScreenFragmentDirections.actionSplashScreenFragmentToBottomNavigationFragment())

        }



    }
}