package com.example.cryptocurrencies.presentation.mainscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cryptocurrencies.R
import com.example.cryptocurrencies.data.storage.CryptoCurrencyDB
import com.example.cryptocurrencies.databinding.MainScreenFragmentBinding
import com.example.cryptocurrencies.model.CurrencyModel
import com.example.cryptocurrencies.presentation.base.BaseFragment
import com.example.cryptocurrencies.presentation.detailsscreen.DetailsScreenFragment
import com.example.cryptocurrencies.presentation.mainscreen.currencyrecycler.CurrencyAdapter
import com.example.cryptocurrencies.presentation.mainscreen.sortdialog.SortDialogFragment
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class MainScreenFragment :
    BaseFragment<MainScreenFragmentBinding>(MainScreenFragmentBinding::inflate) {

    private val listOfCurrenciesViewModel: ListOfCurrenciesViewModel by inject()
    private val sortDialogFragment: SortDialogFragment = SortDialogFragment()
    private val cryptoCurrencyDB: CryptoCurrencyDB by inject()
    private val currencyViewModel: CurrencyViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (requireActivity() as AppCompatActivity).supportActionBar
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    fun onItemClick(view: View, currencyModel: CurrencyModel) {
        currencyViewModel.changeCurrencyModel(currencyModel)
        val detailsScreenFragment = DetailsScreenFragment()
        parentFragmentManager.commit { replace(R.id.fragmentContainerView2, detailsScreenFragment) }
    }

    override fun initView() {

        binding.imageView.setOnClickListener {
            if (!sortDialogFragment.isResumed)
                sortDialogFragment.show(parentFragmentManager, DIALOG_TAG)
        }

        val layoutManager =
            LinearLayoutManager(requireActivity())

        binding.recyclerView.layoutManager = layoutManager

        val pagingAdapter = CurrencyAdapter(::onItemClick)
        binding.recyclerView.adapter = pagingAdapter

        lifecycleScope.launch {
            listOfCurrenciesViewModel.flow.collectLatest { pagingData ->
                pagingAdapter.submitData(pagingData)
            }
        }
    }
}

private const val DIALOG_TAG = "sort"