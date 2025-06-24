package org.jpashop.jpashop2.domain

import jakarta.persistence.*
import org.jpashop.jpashop2.domain.item.Item

@Entity
class OrderItem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ITEM_ID")
    val id: Long,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID")
    val item: Item,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    val order: Order,
    val orderPrice: Int,
    val count: Int,
) {
}