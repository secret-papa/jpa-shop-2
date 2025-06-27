package org.jpashop.jpashop2.domain.item

import jakarta.persistence.*
import org.jpashop.jpashop2.domain.Category

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
open class Item(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID")
    val id: Long? = null,
    var name: String,
    var price: Int,
    var stockQuantity: Int,
    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL], mappedBy = "items")
    var categories: List<Category> = emptyList(),
) {

    fun update(
        name: String? = null,
        price: Int? = null,
        stockQuantity: Int? = null,
        categories: List<Category>? = null,
    ) {
        name?.let { this.name = it }
        price?.let { this.price = it }
        stockQuantity?.let { this.stockQuantity = it }
        categories?.let { this.categories = it }
    }
}