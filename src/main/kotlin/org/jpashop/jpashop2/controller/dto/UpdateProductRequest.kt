package org.jpashop.jpashop2.controller.dto

import org.jpashop.jpashop2.services.command.UpdateProductCommand

data class UpdateProductRequest(
    var name: String? = null,
    var price: Int? = null,
    var stockQuantity: Int? = null,
    var categories: List<Long>? = null,
) {
    fun toCommand(id: Long): UpdateProductCommand {
        return UpdateProductCommand(
            id,
            name,
            price,
            stockQuantity,
            categories,
        )
    }
}
