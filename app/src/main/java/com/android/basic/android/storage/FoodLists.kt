package com.android.basic.android.storage

import com.android.basic.android.R
import com.android.basic.android.model.BreakfastModel
import com.android.basic.android.model.FoodModel
import com.android.basic.android.model.LunchModel
import com.android.basic.android.model.SnacksModel

val snackLists: List<SnacksModel> = listOf(
    SnacksModel(
        id = 1,
        description = "Some fruits aren't that bad",
        time = "15 min",
        image = R.drawable.fruit_food_1
    ),
    SnacksModel(
        id = 2,
        description = "More fruits?",
        time = "14 min",
        image = R.drawable.fruit_food_2
    ),
    SnacksModel(
        id = 3,
        description = "Ever try korean one?",
        time = "13 min",
        image = R.drawable.bimbap
    ),
    SnacksModel(
        id = 4,
        description = "Unhealthy, but goood",
        time = "12 min",
        image = R.drawable.cheese_ball_food
    ),
    SnacksModel(
        id = 5,
        description = "Another one?",
        time = "11 min",
        image = R.drawable.bimbap_bowl
    ),
)

val breakfastLists: List<BreakfastModel> = listOf(
    BreakfastModel(
        id = 1,
        description = "Halal Halal",
        time = "15 min",
        image = R.drawable.img_bacon_toast_food
    ),
    BreakfastModel(
        id = 2,
        description = "Too cute too eat?",
        time = "14 min",
        image = R.drawable.img_breakfast_food
    ),
    BreakfastModel(
        id = 3,
        description = "Like some eggs?",
        time = "13 min",
        image = R.drawable.img_omelete_food
    ),
    BreakfastModel(
        id = 4,
        description = "Breakfast Bon Apetito",
        time = "12 min",
        image = R.drawable.img_pancake_food
    ),
    BreakfastModel(
        id = 5,
        description = "Salad for beautiful people",
        time = "11 min",
        image = R.drawable.img_salad_food
    ),
)

val lunchLists: List<LunchModel> = listOf(
    LunchModel(
        id = 1,
        description = "Fresh from Japan",
        time = "15 min",
        image = R.drawable.udon_lunch
    ),
    LunchModel(
        id = 2,
        description = "Try Korean?",
        time = "14 min",
        image = R.drawable.noodle_soup_lunch
    ),

    LunchModel(
        id = 3,
        description = "Everything in protein is good",
        time = "13 min",
        image = R.drawable.chicken_breast_lunch
    ),
    LunchModel(
        id = 4,
        description = "Look indian, huh?",
        time = "12 min",
        image = R.drawable.chicken_curry_lunch
    ),
    LunchModel(
        id = 5,
        description = "What about italian?",
        time = "11 min",
        image = R.drawable.burrito_wrap_lunch
    ),
)

