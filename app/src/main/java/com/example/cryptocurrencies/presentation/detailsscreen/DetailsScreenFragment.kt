package com.example.cryptocurrencies.presentation.detailsscreen

import androidx.fragment.app.commit
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import coil.load
import coil.request.Parameters
import com.example.cryptocurrencies.R
import com.example.cryptocurrencies.databinding.DetailsScreenFragmentBinding
import com.example.cryptocurrencies.presentation.base.BaseFragment
import com.example.cryptocurrencies.presentation.base.BaseViewModel
import com.example.cryptocurrencies.presentation.mainscreen.CurrencyViewModel
import com.example.cryptocurrencies.presentation.mainscreen.MainScreenFragment
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class DetailsScreenFragment :
    BaseFragment<DetailsScreenFragmentBinding>(DetailsScreenFragmentBinding::inflate) {

    private val listOfCurrenciesViewModel: BaseViewModel by inject()
    private val currencyViewModel: CurrencyViewModel by sharedViewModel()


    override fun initView() {

        binding.buttonBack.setOnClickListener {
            val mainScreenFragment = MainScreenFragment()
            parentFragmentManager.commit { replace(R.id.fragmentContainerView2, mainScreenFragment) }
        }

        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                currencyViewModel.state.collect {
                    if (it != null) {
                        binding.imageCrypto.load(it.image)
                        binding.name.text = it.name
                        binding.marketCap.text = "$ " + it.marketCup.toString()
                        binding.cost.text = it.currentPrice.toString() + " $"
                    }
                }
            }
        }
        val anyChartView = binding.anyChartView

        val lineList: ArrayList<Entry> = ArrayList()

        lineList.add(Entry(10f, 100f))
        lineList.add(Entry(20f, 300f))
        lineList.add(Entry(30f, 200f))
        lineList.add(Entry(40f, 600f))
        lineList.add(Entry(50f, 500f))
        lineList.add(Entry(60f, 900f))
        lineList.add(Entry(70f, 100f))

        val lineDataSet = LineDataSet(lineList, "")
        val lineData = LineData(lineDataSet)
        anyChartView.data = lineData
        /*lineDataSet.setColors(*ColorTemplate.JOYFUL_COLORS)
        lineDataSet!!.valueTextColor = Color.BLUE
        lineDataSet.valueTextSize = 20f*/
    }
}