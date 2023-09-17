package com.example.androidbase.data.remote.products

import com.example.androidbase.domain.entities.remote.products.ProductResponse


interface ProductsRepository {

    suspend fun getProducts(): ProductResponse
}