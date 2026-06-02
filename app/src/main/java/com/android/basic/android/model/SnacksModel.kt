package com.android.basic.android.model

import androidx.annotation.DrawableRes

data class SnacksModel(
    val id : Int,
    val description : String,
    val time: String,
    @DrawableRes val image: Int
)

data class BreakfastModel(
    val id: Int,
    val description: String,
    val time: String,
    @DrawableRes val image: Int
)

data class LunchModel(
    val id: Int,
    val description: String,
    val time: String,
    @DrawableRes val image: Int
)