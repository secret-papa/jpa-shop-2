package org.jpashop.jpashop2.domain.item

import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import org.jpashop.jpashop2.domain.Category

@Entity
@DiscriminatorValue("ALBUM")
class Album(
    id: Long? = null,
    name: String,
    price: Int,
    stockQuantity: Int,
    categories: List<Category> = emptyList(),
    val artist: String? = null,
    val etc: String? = null,
): Item(
    id = id,
    name = name,
    price= price,
    stockQuantity = stockQuantity,
    categories =  categories
) {
}