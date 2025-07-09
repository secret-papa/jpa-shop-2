package org.jpashop.jpashop2.repository

import org.jpashop.jpashop2.domain.Order

interface OrderRepository {
    fun create(order: Order): Long?
    fun findAll(memberId: Long): List<Order>
}