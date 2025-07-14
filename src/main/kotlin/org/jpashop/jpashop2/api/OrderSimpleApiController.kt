package org.jpashop.jpashop2.api

import org.jpashop.jpashop2.domain.Order
import org.jpashop.jpashop2.repository.OrderRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderSimpleApiController(
    private val orderRepository: OrderRepository
) {

    @GetMapping("/api/v1/simple-orders")
    fun ordersV1(): List<Order> {
        val all = orderRepository.findAll(1)

        for(order in all) {
            order.member.name  // Lazy 강제 초기화
            order.delivery.address  // Lazy 강제 초기화
        }

        return all
    }
}