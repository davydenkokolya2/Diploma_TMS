package com.example.cryptocurrencies.presentation.mainscreen.sortdialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment
import com.example.cryptocurrencies.R

class SortDialogFragment : DialogFragment() {

    private val sortType = arrayOf(SortType.ByPrice.name, SortType.Alphabetically.name)

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val selectedItems = ArrayList<Int>() // Where we track the selected items
            val builder = AlertDialog.Builder(it)
            builder.setTitle(getString(R.string.nameSortDialog))
                .setSingleChoiceItems(
                    sortType, 0
                ) { dialog, item ->
                    Log.i("test", item.toString())
                }
                .setPositiveButton(
                    getString(R.string.positiveText)
                ) { dialog, id ->
                    // User clicked OK, so save the selectedItems results somewhere
                    // or return them to the component that opened the dialog
                }
                .setNegativeButton(getString(R.string.negativeText)) { dialog, id ->
                }

            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

}