package org.jpashop.jpashop2.controller.dto

data class CreateProductRequest(
    val name: String,
    val price: Int,
    val stockQuantity: Int,
    val categories: List<Long>
)
