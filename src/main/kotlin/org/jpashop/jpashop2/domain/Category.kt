package org.jpashop.jpashop2.domain

import jakarta.persistence.*
import org.jpashop.jpashop2.domain.item.Item

@Entity
class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID")
    val id: Long? = null,
    val name: String,
    @ManyToMany
    @JoinTable(
        name = "CATEGORY_ITEM",
        joinColumns = [JoinColumn(name = "CATEGORY_ID")],
        inverseJoinColumns = [JoinColumn(name = "ITEM_ID")],
    )
    var items: MutableList<Item> = mutableListOf(),
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    val parent: Category? = null,
    @OneToMany(mappedBy = "parent")
    val children: List<Category> = emptyList()
) {
    fun addItem(item: Item) {
        items.add(item)
        if (!item.categories.contains(this)) {
            item.categories = item.categories + this
        }
    }
}