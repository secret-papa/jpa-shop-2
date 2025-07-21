package org.jpashop.jpashop2.domain

import jakarta.persistence.*
import org.hibernate.annotations.BatchSize
import java.time.LocalDateTime

@Entity
@Table(name = "orders")
class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    val id: Long? = null,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    val member: Member,
    @BatchSize(size = 100)
    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL])
    var orderItems: List<OrderItem> = emptyList(),
    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "DELIVERY_ID")
    var delivery: Delivery? = null,
    val orderDate: LocalDateTime = LocalDateTime.now(),
    @Enumerated(EnumType.STRING)
    var status: OrderStatus
) {
    fun addOrderItems(orderItems: List<OrderItem>) {
        this. orderItems = orderItems
        orderItems.forEach { it.addOrder(this) }
    }

    fun addDelivery(delivery: Delivery) {
        this.delivery = delivery
        delivery.order = this
    }

    fun cancel() {
        if (status == OrderStatus.CANCEL)  {
            throw IllegalStateException("Order order canceled")
        }

        status = OrderStatus.CANCEL
        orderItems.forEach { it.resetItemStockQuantity() }
    }
}