package com.example.data.Repository

import com.example.data.api.ProductServices
import com.example.domain.contracts.ProductOnlineData
import com.example.domain.contracts.ProductRepositoryContract
import io.mockk.mockk
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class ProductRepositoryTest {
    lateinit var repositoryContract: ProductRepositoryContract
    val onlineData = mockk<ProductOnlineData>()

    @Before
    fun setUp() {
        repositoryContract = ProductRepository(onlineData)
    }


}