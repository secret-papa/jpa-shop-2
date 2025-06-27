package org.jpashop.jpashop2.controller.dto

import org.jpashop.jpashop2.services.command.CreateProductCommand
import org.jpashop.jpashop2.services.command.DType

data class CreateProductRequest(
    val dType: DType,
    val name: String,
    val price: Int,
    val stockQuantity: Int,
    val categories: List<Long>,
    val artist: String? = null,
    val etc: String? = null,
    val author: String? = null,
    val isbn: String?  = null,
    val director: String? = null,
    val actor: String? = null,
) {
    fun toCommand(): CreateProductCommand {
        return CreateProductCommand(
           dType,
            name,
            price,
            stockQuantity,
            categories,
            artist,
        etc,
        author,
        isbn,
        director,
        actor,
        )
    }
}
