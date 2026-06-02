package com.android.basic.android.storage

import com.android.basic.android.model.AccountModel
import com.android.basic.android.screen.AccountType
import com.android.basic.android.screen.CurrencyCode

val accountList = listOf(
    AccountModel(
        rawAccountNo = "4587123412345678",
        accountName = "John Smith",
        accountType = AccountType.SAVINGS_ACCOUNT,
        currencyCode = CurrencyCode.USD,
        balance = 5420.75,
        availableBalance = 5000.00,
        rawExpiredDate = "12 September 2026",
        cvv = "123"
    ),

    AccountModel(
        rawAccountNo = "5278456789123456",
        accountName = "Emma Johnson",
        accountType = AccountType.LOAN_ACCOUNT,
        currencyCode = CurrencyCode.KHD,
        balance = 12000.00,
        availableBalance = 11500.00,
        rawExpiredDate = "03 January 2027",
        cvv = "456"
    ),

    AccountModel(
        rawAccountNo = "6011987654321234",
        accountName = "Michael Brown",
        accountType = AccountType.DEPOSIT_ACCOUNT,
        currencyCode = CurrencyCode.USD,
        balance = 950.25,
        availableBalance = 900.00,
        rawExpiredDate = "18 June 2028",
        cvv = "789"
    ),

    AccountModel(
        rawAccountNo = "4923456789012345",
        accountName = "Sophia Davis",
        accountType = AccountType.GOLD_SAVING,
        currencyCode = CurrencyCode.KHD,
        balance = 7800.00,
        availableBalance = 7600.00,
        rawExpiredDate = "22 November 2029",
        cvv = "321"
    ),

    AccountModel(
        rawAccountNo = "5432765498761234",
        accountName = "William Wilson",
        accountType = AccountType.SAVINGS_ACCOUNT,
        currencyCode = CurrencyCode.USD,
        balance = 14500.90,
        availableBalance = 14000.90,
        rawExpiredDate = "15 February 2027",
        cvv = "654"
    ),

    AccountModel(
        rawAccountNo = "3789456123456789",
        accountName = "Olivia Martinez",
        accountType = AccountType.LOAN_ACCOUNT,
        currencyCode = CurrencyCode.KHD,
        balance = 3000.00,
        availableBalance = 2500.00,
        rawExpiredDate = "07 August 2028",
        cvv = "987"
    ),

    AccountModel(
        rawAccountNo = "4111222233334444",
        accountName = "James Anderson",
        accountType = AccountType.DEPOSIT_ACCOUNT,
        currencyCode = CurrencyCode.USD,
        balance = 22000.00,
        availableBalance = 21500.00,
        rawExpiredDate = "30 December 2030",
        cvv = "159"
    ),

    AccountModel(
        rawAccountNo = "5555666677778888",
        accountName = "Isabella Thomas",
        accountType = AccountType.GOLD_SAVING,
        currencyCode = CurrencyCode.KHD,
        balance = 8700.45,
        availableBalance = 8500.45,
        rawExpiredDate = "14 April 2029",
        cvv = "753"
    ),

    AccountModel(
        rawAccountNo = "4899123411112222",
        accountName = "Benjamin Taylor",
        accountType = AccountType.SAVINGS_ACCOUNT,
        currencyCode = CurrencyCode.USD,
        balance = 6400.10,
        availableBalance = 6200.10,
        rawExpiredDate = "09 October 2027",
        cvv = "852"
    ),

    AccountModel(
        rawAccountNo = "5105105105105100",
        accountName = "Mia White",
        accountType = AccountType.LOAN_ACCOUNT,
        currencyCode = CurrencyCode.KHD,
        balance = 4100.80,
        availableBalance = 3900.80,
        rawExpiredDate = "25 May 2028",
        cvv = "951"
    )
)