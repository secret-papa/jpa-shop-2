package org.jpashop.jpashop2.api

import org.jpashop.jpashop2.domain.Order
import org.jpashop.jpashop2.repository.OrderRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderApiController(
    private val orderRepository: OrderRepository
) {
    @GetMapping("/api/v1/orders")
    fun ordersV1(): List<Order> {
        val all = orderRepository.findAll(1)
        for (order in all) {
            order.member.name
            order.delivery?.address

            val orderItems = order.orderItems
            orderItems.forEach { o -> o.item.name}
        }

        return all
    }
}