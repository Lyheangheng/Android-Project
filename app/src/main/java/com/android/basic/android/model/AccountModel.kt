package com.android.basic.android.model

import com.android.basic.android.screen.AccountType
import com.android.basic.android.screen.CurrencyCode
import java.text.SimpleDateFormat
import java.util.Locale

data class AccountModel(
    private val rawAccountNo: String,
    val accountName: String,
    val accountType: AccountType,
    val currencyCode: CurrencyCode,
    val balance: Double,
    val availableBalance: Double,
    private val rawExpiredDate: String,
    val cvv: String
) {
    val accountNo = maskCardNo(rawAccountNo)
    val expiredDate: String
        get() = formatCardExpiryDate(rawExpiredDate)
}

fun formatCardExpiryDate(date: String): String {
    val inputFormat = SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH)
    val outputFormat = SimpleDateFormat("MM/yy", Locale.ENGLISH)

    val parsedDate = inputFormat.parse(date)

    return outputFormat.format(parsedDate!!)
}

fun maskCardNo(cardNumber: String): String{
    return "**** **** **** ${cardNumber.takeLast(4)}"
}