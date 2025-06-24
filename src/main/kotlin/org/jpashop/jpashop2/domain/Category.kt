package org.jpashop.jpashop2.domain

import jakarta.persistence.*
import org.jpashop.jpashop2.domain.item.Item

@Entity
class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID")
    val id: Long,
    val name: String,
    @ManyToMany
    @JoinTable(
        name = "CATEGORY_ITEM",
        joinColumns = [JoinColumn(name = "CATEGORY_ID")],
        inverseJoinColumns = [JoinColumn(name = "ITEM_ID")],
    )
    val items: List<Item> = emptyList(),
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    val parent: Category? = null,
    @OneToMany(mappedBy = "parent")
    val children: List<Category> = emptyList()
) {
}