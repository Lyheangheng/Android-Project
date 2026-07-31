package com.android.basic.android.dataModel

import kotlinx.serialization.Serializable


@Serializable
data class UserRequest(
    val name: String,
    val age: Int,
    val email: String,
)
