package com.example.data.dataSource

import com.example.data.api.ProductServices
import com.example.data.api.SourceResponse
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class ProductOnlineDataImplTest{
    private lateinit var productServices: ProductServices
    private lateinit var productOnlineDataImpl: ProductOnlineDataImpl

    @Before
    fun setUp() {
        productServices = mockk()
        productOnlineDataImpl = ProductOnlineDataImpl(productServices)
    }

    @Test
    fun `fetch should return an empty list when products are null`() = runTest {
        // Arrange
        val productsResponse = SourceResponse(null)

        // Act
        coEvery { productServices.getProducts() } returns productsResponse

        val result = productOnlineDataImpl.fetch()

        // Assert
        assertEquals(0, result.size)
    }
}