package com.android.basic.android.feature.profile

import com.android.basic.android.model.UserModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class UserProfileRepository{
    private val users = listOf(
        UserModel(
            id = 1,
            name = "Alice Johnson",
            age = 24,
            email = "alice.johnson@example.com"
        ),
        UserModel(
            id = 2,
            name = "Bob Smith",
            age = 28,
            email = "bob.smith@example.com"
        ),
        UserModel(
            id = 3,
            name = "Charlie Brown",
            age = 21,
            email = "charlie.brown@example.com"
        ),
        UserModel(
            id = 4,
            name = "Diana Wilson",
            age = 30,
            email = "diana.wilson@example.com"
        ),
        UserModel(
            id = 5,
            name = "Ethan Davis",
            age = 26,
            email = "ethan.davis@example.com"
        ),
        UserModel(
            id = 6,
            name = "Fiona Clark",
            age = 23,
            email = "fiona.clark@example.com"
        ),
        UserModel(
            id = 7,
            name = "George Miller",
            age = 35,
            email = "george.miller@example.com"
        ),
        UserModel(
            id = 8,
            name = "Hannah Taylor",
            age = 27,
            email = "hannah.taylor@example.com"
        ),
        UserModel(
            id = 9,
            name = "Ian Anderson",
            age = 22,
            email = "ian.anderson@example.com"
        ),
        UserModel(
            id = 10,
            name = "Julia Thomas",
            age = 29,
            email = "julia.thomas@example.com"
        )
    )

    suspend fun getUserProfile(id: Int): Flow<UserModel?>
    {
        delay(2000)
        return flow{
            if(users.isNotEmpty()){
                emit(users.find { it.id == id })
            }else {
                emit(null)
            }
        }
    }

}

