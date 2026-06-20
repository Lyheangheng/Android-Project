package com.android.basic.android.model

import android.icu.text.CaseMap
import androidx.lifecycle.LifecycleDestroyedException

data class ComponentModel(
    val id: Int,
    val title: String,
    val description: String,
    val route: Any,
)