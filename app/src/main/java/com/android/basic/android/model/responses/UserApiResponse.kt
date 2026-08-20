package com.android.basic.android.model.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class UserApiResponse(
    @SerialName("user_id") var id: String,
    @SerialName("user_name") val name: String? = null,
    @SerialName("user_email") val email: String? = null
)