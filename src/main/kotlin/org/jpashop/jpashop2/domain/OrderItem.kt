package org.jpashop.jpashop2.domain

import jakarta.persistence.*
import org.jpashop.jpashop2.domain.item.Item

@Entity
class OrderItem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ITEM_ID")
    val id: Long? = null,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID")
    val item: Item,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    var order: Order? = null,
    val orderPrice: Int,
    val count: Int,
) {
    fun addOrder(order: Order) {
        this.order = order
        val restStockQuantity = item.stockQuantity - count
        if (restStockQuantity < 0) {
            throw IllegalArgumentException("item sold out")
        }

        item.stockQuantity = restStockQuantity
    }
}