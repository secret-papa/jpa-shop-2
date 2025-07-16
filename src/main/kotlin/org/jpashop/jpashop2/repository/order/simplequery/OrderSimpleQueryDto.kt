package org.jpashop.jpashop2.repository.order.simplequery

import org.jpashop.jpashop2.domain.Address
import org.jpashop.jpashop2.domain.OrderStatus
import java.time.LocalDateTime

data class OrderSimpleQueryDto(
    val orderId: Long?,
    val name: String,
    val orderDate: LocalDateTime,
    val orderStatus: OrderStatus,
    val address: Address?
)
