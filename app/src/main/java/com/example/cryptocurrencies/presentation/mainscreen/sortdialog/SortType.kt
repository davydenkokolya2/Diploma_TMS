package com.example.cryptocurrencies.presentation.mainscreen.sortdialog

sealed class SortType {
    object ByPrice : SortType()
    object Alphabetically : SortType()
    val name: String
        get() = when (this) {
            is ByPrice -> "By price"
            is Alphabetically -> "Alphabetically"
        }

}
