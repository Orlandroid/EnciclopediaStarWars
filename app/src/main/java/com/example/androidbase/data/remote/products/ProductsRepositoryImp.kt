package com.example.androidbase.data.remote.products

import com.example.androidbase.data.remote.api.DummyJsonApi
import com.example.androidbase.domain.entities.remote.products.ProductResponse
import com.example.androidbase.presentation.ui.example.FeaturedContent

class ProductsRepositoryImp(private val api: DummyJsonApi) : ProductsRepository {

    override suspend fun getProducts(): ProductResponse = api.getProducts()
    override suspend fun getHomeContent(): FeaturedContent = api.getHomeContent()


}