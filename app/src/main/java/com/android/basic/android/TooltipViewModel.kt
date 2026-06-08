package com.android.basic.android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.basic.android.model.ReceiverAccountModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TooltipViewModel: ViewModel()  {

    private val accountInfo = ReceiverAccountModel(
        accountName = "Account Name",
        accountNumber = "Account Number",
        receiverBankName = "Receiver Bank Name"
    )

    private val _receiverAccount = MutableStateFlow<ReceiverAccountModel?>(null)
    val receiverAccount = _receiverAccount.asStateFlow()

    fun getAccountInfo(){
        viewModelScope.launch {
            _receiverAccount.emit(accountInfo)
        }
    }

}