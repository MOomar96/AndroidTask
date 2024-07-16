package com.example.domain.entity

data class ProductsItemDTO(
    val images: List<String>?,
    val thumbnail: String?,
    val minimumOrderQuantity: Int?,
    val rating: Any?,
    val returnPolicy: String?,
    val description: String?,
    val weight: Int?,
    val warrantyInformation: String?,
    val title: String?,
    val tags: List<String?>?,
    val discountPercentage: Any?,
    val price: Any?,
    val shippingInformation: String?,
    val id: Int?,
    val availabilityStatus: String?,
    val category: String?,
    val stock: Int?,
    val sku: String?,
    val brand: String?
)
