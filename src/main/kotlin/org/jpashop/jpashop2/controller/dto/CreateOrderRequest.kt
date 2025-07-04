package org.jpashop.jpashop2.controller.dto

import org.jpashop.jpashop2.services.command.CreateOrderCommand
import org.jpashop.jpashop2.services.dto.DeliveryDto
import org.jpashop.jpashop2.services.dto.OrderItemDto

data class CreateOrderRequest(
    val memberId: Long,
    val orderItems: List<OrderItemDto>,
    val delivery: DeliveryDto
) {
    fun toCommand(): CreateOrderCommand {
       return CreateOrderCommand(
           memberId,
           orderItems,
           delivery
       )
    }
}
