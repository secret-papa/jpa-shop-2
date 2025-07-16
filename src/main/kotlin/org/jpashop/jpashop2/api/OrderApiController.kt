package org.jpashop.jpashop2.api

import org.jpashop.jpashop2.domain.Address
import org.jpashop.jpashop2.domain.Order
import org.jpashop.jpashop2.domain.OrderItem
import org.jpashop.jpashop2.domain.OrderStatus
import org.jpashop.jpashop2.repository.OrderRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

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

    @GetMapping("/api/v2/orders")
    fun ordersV2(): List<OrderDto> {
        val orders = orderRepository.findAll(1)
        val collect = orders.map { o -> OrderDto(o)}
        return collect
    }

    @GetMapping("/api/v3/orders")
    fun ordersV3(): List<OrderDto> {
        val orders = orderRepository.findAllWithItem()
        val collect = orders.map { o -> OrderDto(o)}
        return collect
    }

    data class OrderDto(
        val orderId: Long?,
        val name: String,
        val orderDate: LocalDateTime,
        val orderStatus: OrderStatus,
        val address: Address?,
        val orderItems: List<OrderItemDto>,
    ) {
        constructor(o: Order) : this(
            orderId = o.id,
            name = o.member.name,
            orderDate = o.orderDate,
            orderStatus = o.status ,
            address = o.delivery?.address,
            orderItems = o.orderItems.map { OrderItemDto(it) }
        )
    }

    data class OrderItemDto(
        val itemName: String,
        val orderPrice: Int,
        val count: Int,
    ) {
        constructor(orderItem: OrderItem) : this(
                itemName = orderItem.item.name,
                orderPrice = orderItem.orderPrice,
                count = orderItem.count
            )
    }
}