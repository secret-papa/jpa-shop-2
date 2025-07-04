package org.jpashop.jpashop2.services.command

import org.jpashop.jpashop2.services.dto.DeliveryDto
import org.jpashop.jpashop2.services.dto.OrderItemDto

data class CreateOrderCommand(
    val memberId: Long,
    val orderItems: List<OrderItemDto>,
    val delivery: DeliveryDto,
)
