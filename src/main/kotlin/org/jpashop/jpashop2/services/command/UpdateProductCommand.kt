package org.jpashop.jpashop2.services.command

data class UpdateProductCommand(
    val id: Long,
    val name: String? = null,
    val price: Int?= null,
    val stockQuantity: Int? = null,
    val categories: List<Long>? = null,
)