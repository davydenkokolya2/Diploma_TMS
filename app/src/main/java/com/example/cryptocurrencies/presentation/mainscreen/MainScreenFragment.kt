package com.example.cryptocurrencies.presentation.mainscreen

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cryptocurrencies.data.storage.CryptoCurrencyDB

import com.example.cryptocurrencies.databinding.MainScreenFragmentBinding
import com.example.cryptocurrencies.model.CurrencyModel
import com.example.cryptocurrencies.presentation.base.BaseFragment
import com.example.cryptocurrencies.presentation.base.BaseViewModel
import com.example.cryptocurrencies.presentation.mainscreen.currencyrecycler.CurrencyAdapter
import com.example.cryptocurrencies.presentation.mainscreen.sortdialog.SortDialogFragment
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainScreenFragment :
    BaseFragment<MainScreenFragmentBinding>(MainScreenFragmentBinding::inflate) {

    private val listOfCurrenciesViewModel: ListOfCurrenciesViewModel by inject()
    private val sortDialogFragment: SortDialogFragment = SortDialogFragment()
    private val cryptoCurrencyDB: CryptoCurrencyDB by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (requireActivity() as AppCompatActivity).supportActionBar
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun initView() {

        binding.imageView.setOnClickListener {
            if (!sortDialogFragment.isResumed)
                sortDialogFragment.show(parentFragmentManager, DIALOG_TAG)
        }

        val layoutManager =
            LinearLayoutManager(requireActivity())

        binding.recyclerView.layoutManager = layoutManager

        val pagingAdapter = CurrencyAdapter()
        binding.recyclerView.adapter = pagingAdapter

        lifecycleScope.launch {
            listOfCurrenciesViewModel.flow.collectLatest { pagingData ->
                pagingAdapter.submitData(pagingData)
            }
        }
    }
}

private const val DIALOG_TAG = "sort"