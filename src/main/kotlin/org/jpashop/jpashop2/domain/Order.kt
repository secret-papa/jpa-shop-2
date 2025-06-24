package org.jpashop.jpashop2.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "orders")
class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    val id: Long,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    val member: Member,
    @OneToMany(mappedBy = "order")
    val orderItems: List<OrderItem> = emptyList(),
    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "DELIVERY_ID")
    val delivery: Delivery,
    val orderDate: LocalDateTime,
    @Enumerated(EnumType.STRING)
    val status: OrderStatus
) {
}