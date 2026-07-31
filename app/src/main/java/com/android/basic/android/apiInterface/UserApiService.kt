package com.android.basic.android.apiInterface

import com.android.basic.android.dataModel.UserResponse
import retrofit2.Response
import retrofit2.http.*


interface UserApiService {
    @GET("users")
    suspend fun getUsers(): Response<List<UserResponse>>

    @GET("users/{id}")
    suspend fun getUserById(@Path("id") id: Int): UserResponse
}