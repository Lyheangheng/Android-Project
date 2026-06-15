package com.android.basic.android.repository.test

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

data class Product(
    val id: Int,
    val name: String,
    val price: Double,
    val imageUrl: String,
    val description: String
)

sealed class Result<out T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Error(val message: String) : Result<Nothing>()
    object Loading : Result<Nothing>()
}

interface ProductRepository {
    fun getProducts(): Flow<Result<List<Product>>>
    suspend fun getProductById(id: Int): Result<Product>
}

class ProductRepositoryImpl : ProductRepository {

    // Replace with your actual data source (Retrofit, Room, etc.)
    private val fakeProducts = listOf(
        Product(1, "Wireless Headphones", 59.99, "https://picsum.photos/200", "High quality sound."),
        Product(2, "Mechanical Keyboard", 89.99, "https://picsum.photos/201", "Tactile and fast."),
        Product(3, "USB-C Hub", 34.99, "https://picsum.photos/202", "7-in-1 connectivity."),
        Product(4, "Webcam HD", 49.99, "https://picsum.photos/203", "1080p clarity."),
        Product(5, "Mouse Pad XL", 19.99, "https://picsum.photos/204", "Extra large desk mat.")
    )

    override fun getProducts(): Flow<Result<List<Product>>> = flow {
        emit(Result.Loading)
        try {
            // Simulate network delay
            kotlinx.coroutines.delay(1000)
            emit(Result.Success(fakeProducts))
        } catch (e: Exception) {
            emit(Result.Error(e.message ?: "Unknown error"))
        }
    }

    override suspend fun getProductById(id: Int): Result<Product> {
        return fakeProducts.find { it.id == id }
            ?.let { Result.Success(it) }
            ?: Result.Error("Product not found")
    }
}