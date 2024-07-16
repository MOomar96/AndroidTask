package com.example.domain.contracts


import com.example.domain.entity.ProductsItemDTO


interface ProductRepositoryContract {
    suspend fun getProducts(): List<ProductsItemDTO>
}

interface ProductOnlineData {
    suspend fun  fetch() : List<ProductsItemDTO>
}