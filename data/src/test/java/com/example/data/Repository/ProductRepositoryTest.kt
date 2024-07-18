package com.example.data.Repository

import com.example.domain.contracts.ProductOnlineData
import com.example.domain.entity.ProductsItemDTO
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class ProductRepositoryTest {

    private lateinit var productRepository: ProductRepository
    private val onlineData = mockk<ProductOnlineData>()

    @Before
    fun setUp() {
        productRepository = ProductRepository(onlineData)
    }

    @Test
    fun `should return list of products when fetch is successful`() = runTest {
        // Arrange
        val expectedProducts = listOf(
            ProductsItemDTO(
                images = listOf("image1.jpg", "image2.jpg"),
                thumbnail = "thumbnail.jpg",
                minimumOrderQuantity = 1,
                rating = 4.5,
                returnPolicy = "30 days return",
                description = "Product 1 description",
                weight = 200,
                warrantyInformation = "1 year warranty",
                title = "Product 1",
                tags = listOf("tag1", "tag2"),
                discountPercentage = 10.0,
                price = 19.99,
                shippingInformation = "Free shipping",
                id = 1,
                availabilityStatus = "In Stock",
                category = "Category 1",
                stock = 50,
                sku = "SKU12345",
                brand = "Brand 1"
            ),
            ProductsItemDTO(
                images = listOf("image3.jpg", "image4.jpg"),
                thumbnail = "thumbnail2.jpg",
                minimumOrderQuantity = 2,
                rating = 4.0,
                returnPolicy = "No return",
                description = "Product 2 description",
                weight = 150,
                warrantyInformation = "6 months warranty",
                title = "Product 2",
                tags = listOf("tag3", "tag4"),
                discountPercentage = 5.0,
                price = 29.99,
                shippingInformation = "Paid shipping",
                id = 2,
                availabilityStatus = "Out of Stock",
                category = "Category 2",
                stock = 0,
                sku = "SKU54321",
                brand = "Brand 2"
            )
        )
        // Act
        coEvery { onlineData.fetch() } returns expectedProducts

        val actualProducts = productRepository.getProducts()

        // Assert
        assertEquals(expectedProducts, actualProducts)
    }
}