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
    val id: Long,
    val name: String,
    val price: Int,
    val stockQuantity: Int,
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "items")
    val categories: List<Category> = emptyList(),
) {
}