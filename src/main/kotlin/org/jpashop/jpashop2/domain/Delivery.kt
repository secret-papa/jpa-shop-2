package org.jpashop.jpashop2.domain

import jakarta.persistence.*

@Entity
class Delivery(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DELIVERY_ID")
    val id: Long,
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "delivery")
    val order: Order,
    @Embedded
    val address: Address,
    @Enumerated(EnumType.STRING)
    val deliveryStatus: DeliveryStatus
) {
}