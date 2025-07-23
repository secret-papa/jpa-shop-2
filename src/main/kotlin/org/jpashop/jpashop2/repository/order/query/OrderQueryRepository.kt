package org.jpashop.jpashop2.repository.order.query

import jakarta.persistence.EntityManager
import org.springframework.stereotype.Repository

@Repository
class OrderQueryRepository(
    private val em: EntityManager
) {
    fun findOrderQueryDtos(): List<OrderQueryDto> {
        val result = findOrders()

        result.forEach {
            val orderItems: List<OrderItemQueryDto> = findOrderItems(it.orderId)
            it.orderItems = orderItems
        }

        return result
    }

    fun findAllByDto_optimization(): List<OrderQueryDto> {
        val orders = findOrders()
        val orderItemMap = findOrderItemMap(orders.map { it.orderId })

        orders.forEach { o -> o.orderItems = orderItemMap.get(o.orderId)!! }

        return orders
    }

    fun findAllByDto_flat(): List<OrderFlatDto> {
        return em.createQuery(
            "select new org.jpashop.jpashop2.repository.order.query.OrderFlatDto(o.id, m.name, o.orderDate, o.status, d.address, i.name, oi.orderPrice, oi.count) from Order o" +
            " join o.member m" +
            " join o.delivery d" +
            " join o.orderItems oi" +
            " join oi.item i",
            OrderFlatDto::class.java
        ).resultList
    }

    private fun findOrderItemMap(orderIds: List<Long>): Map<Long, List<OrderItemQueryDto>> {
        val orderItems = em.createQuery(
            "select new org.jpashop.jpashop2.repository.order.query.OrderItemQueryDto(oi.order.id, i.name, oi.orderPrice, oi.count) from OrderItem oi" +
                    " join oi.item i" +
                    " where oi.order.id in :orderIds",
            OrderItemQueryDto::class.java
        )
            .setParameter("orderIds", orderIds)
            .resultList
        return orderItems.groupBy { it.orderId }
    }

    private fun findOrderItems(orderId: Long): List<OrderItemQueryDto> {
        return em.createQuery(
            "select new org.jpashop.jpashop2.repository.order.query.OrderItemQueryDto(oi.order.id, i.name, oi.orderPrice, oi.count) from OrderItem oi" +
            " join oi.item i" +
            " where oi.order.id = :orderId",
            OrderItemQueryDto::class.java
        ).setParameter("orderId", orderId).resultList
    }

    private fun findOrders(): List<OrderQueryDto> {
        return em.createQuery(
            "select new org.jpashop.jpashop2.repository.order.query.OrderQueryDto(o.id, m.name, o.orderDate, o.status, d.address)  from Order o" +
            " join o.member m" +
            " join o.delivery d", OrderQueryDto::class.java
        ).resultList
    }
}