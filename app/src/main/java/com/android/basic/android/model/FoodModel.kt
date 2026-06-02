package com.android.basic.android.model

import androidx.annotation.DrawableRes
import com.android.basic.android.R

data class FoodModel(
    val id: Int,
    @DrawableRes val image: Int,
    val label: String
)

val foodList = listOf<FoodModel>(
    FoodModel(
        id = 1,
        image = R.drawable.fruit_food_2,
        label = "Fruit"
    ),
    FoodModel(
        id = 2,
        image = R.drawable.bimbap,
        label = "Bimbap"
    ),
    FoodModel(
        id = 3,
        image = R.drawable.cheese_ball_food,
        label = "Cheese Ball"
    ),
    FoodModel(
        id = 4,
        image = R.drawable.bimbap_bowl,
        label = "Bimbab"
    ),
    FoodModel(
        id = 5,
        image = R.drawable.cheese_stick_food,
        label = "Cheese Stick"
    ),
    FoodModel(
        id = 6,
        image = R.drawable.fries_food,
        label = "Fries"
    ),
    FoodModel(
        id = 7,
        image = R.drawable.fruit_food_1,
        label = "Fruit"
    ),
    FoodModel(
        id = 8,
        image = R.drawable.kimbab,
        label = "Kimbab"
    ),
    FoodModel(
        id = 9,
        image = R.drawable.toeboki_food,
        label = "Toeboki"
    ),
    FoodModel(
        id = 10,
        image = R.drawable.prawns_food,
        label = "Prawns"
    ),
    FoodModel(
        id = 11,
        image = R.drawable.rice_ball_food,
        label = "Rice Ball"
    )
)