package com.android.basic.android.apiInterface


import com.android.basic.android.dataModel.UserResponse
import com.android.basic.android.model.request.UserApiRequest
import com.android.basic.android.model.responses.UserApiResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path


interface UserApiService {
    @GET("/users")
    suspend fun getUsers(): Response<List<UserResponse>>

    @GET("/users/{id}")
    suspend fun getUserById(@Path("id") id: Int): UserResponse

    @POST("/users")
    suspend fun createUser(@Body user: UserApiRequest): Response<UserApiResponse>

    @DELETE("/users/{id}")
    suspend fun deleteUser(@Path("id") userId: Int): Response<Unit>

    @PUT("/users/{id}")
    suspend fun updateUser(@Path("id") id: Int, @Body user: UserApiRequest) : Response<UserResponse>
}