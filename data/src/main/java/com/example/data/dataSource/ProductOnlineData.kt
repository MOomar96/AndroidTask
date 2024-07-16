package com.example.data.dataSource

import com.example.domain.contracts.ProductOnlineData
import com.example.data.api.ProductServices
import com.example.domain.entity.ProductsItemDTO
import javax.inject.Inject

class ProductOnlineDataImpl @Inject constructor(private val productServices: ProductServices) :
    ProductOnlineData {
    override suspend fun fetch(): List<ProductsItemDTO> {
        return try {
            productServices.getProducts().products?.map {
                it.toDTO()
            } ?: listOf()
        }catch (e : Exception){
            throw e
        }
    }
}