package com.android.basic.android.model.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class UserApiRequest(
    @SerialName("name") val name: String,
    @SerialName("email") val email: String
)