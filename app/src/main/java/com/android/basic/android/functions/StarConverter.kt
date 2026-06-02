package com.android.basic.android.functions


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.android.basic.android.R

@Composable
fun RatingBar(rating: Double, maxStars: Int =5) {
    Row {
        repeat(maxStars) { index ->
            val starIndex = index + 1
            val icon = when {
                rating >= starIndex -> R.drawable.ic_star_filled // Create/use a filled star icon
                rating >= starIndex - 0.5 -> R.drawable.ic_star_half   // Optional: half star
                else -> R.drawable.ic_star_outline              // Create/use an empty star icon
            }

            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.size(16.dp),
                tint = Color(0xFFFFC107) // Amber/Gold color
            )
        }
    }
}