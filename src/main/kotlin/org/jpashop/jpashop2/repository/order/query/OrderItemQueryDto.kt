package org.jpashop.jpashop2.repository.order.query

data class OrderItemQueryDto(
    val orderId: Long,
    val itemName: String,
    val orderPrice: Int,
    val count: Int,
)
