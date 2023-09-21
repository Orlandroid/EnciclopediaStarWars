package com.example.androidbase.data.remote.products

import com.example.androidbase.domain.entities.remote.products.ProductResponse
import com.example.androidbase.presentation.ui.example.FeaturedContent


interface ProductsRepository {

    suspend fun getProducts(): ProductResponse

    suspend fun getHomeContent(): FeaturedContent
}