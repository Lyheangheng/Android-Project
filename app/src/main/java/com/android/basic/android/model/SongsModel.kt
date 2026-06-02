package com.android.basic.android.model

import androidx.annotation.DrawableRes
import com.android.basic.android.R

data class SongsModel(
    val title: String,
    val description: String,
    @DrawableRes val image: Int,
)

val songList = listOf(
    SongsModel(
        title = "About You",
        description = "A song about blah blah",
        image = R.drawable.about_you_cover
    ),
    SongsModel(
        title = "Secret Door",
        description = "A mysterious track with hidden meanings",
        image = R.drawable.secret_door_cover
    ),
    SongsModel(
        title = "I thought I saw your face today",
        description = "A duet exploring love and connection",
        image = R.drawable.she_and_him_cover
    ),
    SongsModel(
        title = "Undressed",
        description = "A light and breezy summer vibe song",
        image = R.drawable.sombr_cover
    ),
    SongsModel(
        title = "Sad",
        description = "A deep and moody atmosphere track",
        image = R.drawable.xxxtentacion_cover
    ),
    SongsModel(
        title = "Touch",
        description = "A playful and colorful tune",
        image = R.drawable.cas_cover
    ),
    SongsModel(
        title = "Sienna",
        description = "A dreamy indie-inspired sound",
        image = R.drawable.the_marias_cover
    ),
    SongsModel(
        title = "No.1 Party Anthem",
        description = "A fun and quirky song with flavor",
        image = R.drawable.arctic_monkey_cover
    ),
    SongsModel(
        title = "We fell in love in October",
        description = "A chill track with relaxed vibes",
        image = R.drawable.girl_in_red_cover
    ),
    SongsModel(
        title = "Let the light in",
        description = "A clean and minimal aesthetic track",
        image = R.drawable.lana_cover
    ),
    SongsModel(
        title = "The Night we met",
        description = "A smooth and classic sounding piece",
        image = R.drawable.lord_huron_cover
    ),
    SongsModel(
        title = "Lover Rocks",
        description = "A continuation with a modern twist",
        image = R.drawable.lover_rock_cover
    ),
    SongsModel(
        title = "Dangerous",
        description = "Simple yet elegant composition",
        image = R.drawable.mj_cover
    ),
    SongsModel(
        title = "happier",
        description = "An emotional and expressive track",
        image = R.drawable.olivia_cover
    ),
    SongsModel(
        title = "I wanna be yours",
        description = "Bonus experimental sound",
        image = R.drawable.arctic_monkey_cover
    ),
    SongsModel(
        title = "She and Him",
        description = "Another bonus creative piece",
        image = R.drawable.she_and_him_cover
    ),
    SongsModel(
        title = "Lover Rocks",
        description = "A hidden gem in the collection",
        image = R.drawable.lover_rock_cover
    )
)