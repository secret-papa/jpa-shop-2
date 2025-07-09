package org.jpashop.jpashop2.controller.dto

import org.jpashop.jpashop2.domain.Order
import org.jpashop.jpashop2.domain.OrderStatus
import java.time.LocalDateTime

data class OrderDto(
    val id: Long?,
    val member: MemberDto,
    val delivery: DeliveryDto?,
    val orderDate: LocalDateTime,
    val status: OrderStatus,
    val orderItems: List<OrderItemDto>
)

fun Order.toDto() = OrderDto(
    id = this.id,
    member = this.member.toDto(),
    delivery = this.delivery?.toDto(),
    orderDate = this.orderDate,
    status = this.status,
    orderItems = this.orderItems.map { it.toDto() }
)
