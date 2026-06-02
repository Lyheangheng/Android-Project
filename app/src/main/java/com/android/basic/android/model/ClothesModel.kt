package com.android.basic.android.model

import androidx.annotation.DrawableRes
import com.android.basic.android.R
import com.android.basic.android.screen.CurrencyCode

data class ClothesCardModel(
        val price: Double,
        val clothesCurrencyCode: ClothesCurrencyCode,
        val description: String,
        @DrawableRes val image: Int
        )

enum class ClothesCurrencyCode(val code: String) {
    KHD("៛"),
    USD("$"),
    BAHT("฿ ")
}

val clothesList = listOf(
    ClothesCardModel(19.99, ClothesCurrencyCode.USD, "A comfortable cotton t-shirt designed for everyday wear with breathable fabric and a relaxed fit.", R.drawable.sky_blue_tshirt),
    ClothesCardModel(45.50, ClothesCurrencyCode.USD, "A stylish denim jacket with durable stitching and a classic look suitable for all seasons.",R.drawable.blue_shirt ),
    ClothesCardModel(25.00, ClothesCurrencyCode.BAHT, "Lightweight casual shorts perfect for hot weather and outdoor activities.", R.drawable.green_shirt),
    ClothesCardModel(60.00, ClothesCurrencyCode.USD, "A warm hoodie with soft inner lining, ideal for cooler temperatures.", R.drawable.white_shirt),
    ClothesCardModel(35.20, ClothesCurrencyCode.USD, "Premium polo shirt with a clean design, suitable for both casual and semi-formal use.", R.drawable.dark_blue_shirt),
    ClothesCardModel(18.40, ClothesCurrencyCode.KHD, "Elegant blouse made with soft fabric, offering comfort and a modern look.", R.drawable.trouser),
    ClothesCardModel(80.00, ClothesCurrencyCode.USD, "High-quality leather jacket with a sleek finish and durable material.", R.drawable.strip_white_green_shirt),
    ClothesCardModel(27.30, ClothesCurrencyCode.USD, "Slim fit chinos pants designed for versatility and everyday comfort.", R.drawable.white_coat_shirt),
    ClothesCardModel(14.99, ClothesCurrencyCode.BAHT, "Graphic t-shirt featuring unique prints and breathable cotton fabric.", R.drawable.white_polo),
    ClothesCardModel(90.00, ClothesCurrencyCode.USD, "Elegant dress with a flattering cut, perfect for formal occasions.", R.drawable.white_polo_2),

    ClothesCardModel(19.99, ClothesCurrencyCode.USD, "A comfortable cotton t-shirt designed for everyday wear with breathable fabric and a relaxed fit.", R.drawable.sky_blue_tshirt),
    ClothesCardModel(45.50, ClothesCurrencyCode.USD, "A stylish denim jacket with durable stitching and a classic look suitable for all seasons.",R.drawable.blue_shirt ),
    ClothesCardModel(25.00, ClothesCurrencyCode.BAHT, "Lightweight casual shorts perfect for hot weather and outdoor activities.", R.drawable.green_shirt),
    ClothesCardModel(60.00, ClothesCurrencyCode.USD, "A warm hoodie with soft inner lining, ideal for cooler temperatures.", R.drawable.white_shirt),
    ClothesCardModel(35.20, ClothesCurrencyCode.USD, "Premium polo shirt with a clean design, suitable for both casual and semi-formal use.", R.drawable.dark_blue_shirt),
    ClothesCardModel(18.40, ClothesCurrencyCode.KHD, "Elegant blouse made with soft fabric, offering comfort and a modern look.", R.drawable.trouser),
    ClothesCardModel(80.00, ClothesCurrencyCode.USD, "High-quality leather jacket with a sleek finish and durable material.", R.drawable.strip_white_green_shirt),
    ClothesCardModel(27.30, ClothesCurrencyCode.USD, "Slim fit chinos pants designed for versatility and everyday comfort.", R.drawable.white_coat_shirt),
    ClothesCardModel(14.99, ClothesCurrencyCode.BAHT, "Graphic t-shirt featuring unique prints and breathable cotton fabric.", R.drawable.white_polo),
    ClothesCardModel(90.00, ClothesCurrencyCode.USD, "Elegant dress with a flattering cut, perfect for formal occasions.", R.drawable.white_polo_2)
)