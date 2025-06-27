package org.jpashop.jpashop2.controller.dto

import org.jpashop.jpashop2.domain.item.Item

data class ItemDto(
    val id: Long?,
    val name: String,
    val price: Int,
    val stockQuantity: Int,
    val categories: List<CategoryDto>
)

fun Item.toDto() = ItemDto(
    id = this.id,
    name = this.name,
    price = this.price,
    stockQuantity = this.stockQuantity,
    categories = this.categories.map { category -> CategoryDto(
        id = category.id,
        name = category.name,
        items = category.items.map { it.id },
        parent = category.parent?.id,
        children = category.children.map { it.id }
    ) },
)
