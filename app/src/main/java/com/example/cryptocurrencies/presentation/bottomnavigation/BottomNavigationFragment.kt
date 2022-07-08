package com.example.cryptocurrencies.presentation.bottomnavigation

import androidx.fragment.app.commit
import com.example.cryptocurrencies.R
import com.example.cryptocurrencies.databinding.BottomNavigationFragmentBinding
import com.example.cryptocurrencies.presentation.base.BaseFragment
import com.example.cryptocurrencies.presentation.mainscreen.MainScreenFragment
import com.example.cryptocurrencies.presentation.settingsscreen.SettingsScreenFragment

class BottomNavigationFragment: BaseFragment<BottomNavigationFragmentBinding>(BottomNavigationFragmentBinding::inflate) {

    private val settingsScreenFragment = SettingsScreenFragment()
    private val mainScreenFragment = MainScreenFragment()

    override fun initView() {
        binding.bottomNavigationMain.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.ic_settings -> childFragmentManager.commit { replace(binding.fragmentContainerView2.id, settingsScreenFragment) }
                R.id.ic_home -> childFragmentManager.commit { replace(binding.fragmentContainerView2.id, mainScreenFragment) }
            }
            true
        }
    }
}