package com.android.basic.android.dataModel

import kotlinx.serialization.Serializable


@Serializable
data class UserResponse(
    val id: Int,
    val name: String,
    val email: String,
)
