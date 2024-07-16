package com.example.data.Repository

import com.example.domain.contracts.ProductOnlineData
import com.example.domain.contracts.ProductRepositoryContract
import com.example.domain.entity.ProductsItemDTO
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val onlineData: ProductOnlineData
) : ProductRepositoryContract {
    override suspend fun getProducts(): List<ProductsItemDTO> {
        try {
            return onlineData.fetch()
        }catch (e : Exception){
            throw e
        }
    }
}
