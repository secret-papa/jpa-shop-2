package org.jpashop.jpashop2.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
class Delivery(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DELIVERY_ID")
    val id: Long? = null,
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "delivery")
    var order: Order? = null,
    @Embedded
    val address: Address,
    @Enumerated(EnumType.STRING)
    val deliveryStatus: DeliveryStatus
)