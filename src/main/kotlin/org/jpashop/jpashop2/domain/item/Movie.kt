package org.jpashop.jpashop2.domain.item

import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import org.jpashop.jpashop2.domain.Category

@Entity
@DiscriminatorValue("MOVIE")
class Movie(
    id: Long,
    name: String,
    price: Int,
    stockQuantity: Int,
    categories: List<Category>,
    val director: String,
    val actor: String,
): Item(
    id = id,
    name = name,
    price= price,
    stockQuantity = stockQuantity,
    categories =  categories
) {
}