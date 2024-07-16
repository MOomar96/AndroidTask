package com.example.data.api

import retrofit2.http.GET

interface ProductServices {

    @GET("products")
    suspend fun getProducts(): SourceResponse
}