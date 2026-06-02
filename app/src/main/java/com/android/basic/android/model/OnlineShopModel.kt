package com.android.basic.android.model

import androidx.annotation.DrawableRes
import com.android.basic.android.screen.CurrencyCode

data class ProductModel(
    val id: Int,
    @DrawableRes val image: Int,
    val price: Double,
    val currencyCodeSymbol: CurrencyCodeSymbol,
    val description: String,
    val rating: Double,
    val category: String
)
enum class CurrencyCodeSymbol(val symbol: String){
    USD("$"),
    KHR("៛"),
    EURO("€"),
    POUND("£")
}