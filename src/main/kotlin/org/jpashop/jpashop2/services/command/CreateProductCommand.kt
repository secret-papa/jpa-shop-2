package org.jpashop.jpashop2.services.command

data class CreateProductCommand(
    val dType: DType,
    val name: String,
    val price: Int,
    val stockQuantity: Int,
    val categories: List<Long> = emptyList(),
    val artist: String? = null,
    val etc: String? = null,
    val author: String? = null,
    val isbn: String?  = null,
    val director: String? = null,
    val actor: String? = null,
)