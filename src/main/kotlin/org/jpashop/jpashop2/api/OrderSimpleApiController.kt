package org.jpashop.jpashop2.api

import org.jpashop.jpashop2.domain.Address
import org.jpashop.jpashop2.domain.Order
import org.jpashop.jpashop2.domain.OrderStatus
import org.jpashop.jpashop2.repository.OrderRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
class OrderSimpleApiController(
    private val orderRepository: OrderRepository
) {

    @GetMapping("/api/v1/simple-orders")
    fun ordersV1(): List<Order> {
        val all = orderRepository.findAll(1)

        for(order in all) {
            order.member.name  // Lazy 강제 초기화
            order.delivery?.address  // Lazy 강제 초기화
        }

        return all
    }

    @GetMapping("/api/v2/simple-orders")
    fun ordersV2(): List<SimpleOrderDto> {
        val all = orderRepository.findAll(1)
        return all.map { o -> SimpleOrderDto(
            orderId = o.id,
            name = o.member.name,
            orderDate = o.orderDate,
            orderStatus = o.status,
            address = o.delivery?.address
        ) }
    }

    @GetMapping("/api/v3/simple-orders")
    fun ordersV3(): List<SimpleOrderDto> {
        val all = orderRepository.findAllWithMemberDelivery()

        val results = all.map { o -> SimpleOrderDto(
            orderId = o.id,
            name = o.member.name,
            orderDate = o.orderDate,
            orderStatus = o.status,
            address = o.delivery?.address
        )}

        return results
    }

    data class SimpleOrderDto(
      val orderId: Long?,
        val name: String,
        val orderDate: LocalDateTime,
        val orderStatus: OrderStatus,
        val address: Address?
    )
}