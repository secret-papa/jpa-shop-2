package org.jpashop.jpashop2.controller

import org.jpashop.jpashop2.controller.dto.CreateOrderRequest
import org.jpashop.jpashop2.controller.dto.OrderDto
import org.jpashop.jpashop2.controller.dto.toDto
import org.jpashop.jpashop2.services.OrderService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/orders")
class OrderController(
    private val orderService: OrderService
) {
    @GetMapping
    fun listOrder(@RequestHeader("X-MEMBER-ID") memberId: Long): ResponseEntity<List<OrderDto>> {
        val orders = orderService.findAll(memberId)
        return ResponseEntity.ok(orders.map { it.toDto() })
    }

    @PostMapping("/new")
    fun createOrder(@RequestBody request: CreateOrderRequest): ResponseEntity<Long?> {
        val order = orderService.create(request.toCommand())
        return ResponseEntity.ok(order)
    }
}