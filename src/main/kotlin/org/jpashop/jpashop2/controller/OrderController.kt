package org.jpashop.jpashop2.controller

import org.jpashop.jpashop2.controller.dto.CreateOrderRequest
import org.jpashop.jpashop2.services.OrderService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/orders")
class OrderController(
    private val orderService: OrderService
) {

    @PostMapping("/new")
    fun createOrder(@RequestBody request: CreateOrderRequest): ResponseEntity<Long?> {
        val order = orderService.create(request.toCommand())
        return ResponseEntity.ok(order)
    }
}