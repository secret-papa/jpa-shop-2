package org.jpashop.jpashop2.controller.dto

import org.jpashop.jpashop2.domain.OrderItem

data class OrderItemDto(
    val id: Long?,
    val item: ItemDto,
    val orderPrice: Int,
    val count: Int
)

fun OrderItem.toDto() = OrderItemDto(
    id = this.id,
    item = this.item.toDto(),
    orderPrice = this.orderPrice,
    count =  this.count
)