package org.jpashop.jpashop2.repository.order.query

import org.jpashop.jpashop2.domain.Address
import org.jpashop.jpashop2.domain.OrderStatus
import java.time.LocalDateTime

data class OrderQueryDto(
    val orderId: Long,
    val name: String,
    val orderDate: LocalDateTime,
    val status: OrderStatus,
    val address: Address,
) {
   lateinit var orderItems:List<OrderItemQueryDto>
}
