package org.jpashop.jpashop2.repository

import jakarta.persistence.EntityManager
import org.jpashop.jpashop2.domain.Order
import org.springframework.stereotype.Repository

@Repository
class OrderRepositoryImp(
    private val em: EntityManager
): OrderRepository {
    override fun create(order: Order): Long? {
        em.persist(order)

        return order.id
    }

    override fun findAll(memberId: Long): List<Order> {
        return em.createQuery(
            "select o from Order o where member.id = :memberId",
            Order::class.java
        )
            .setParameter("memberId", memberId)
            .resultList
    }

    override fun findById(orderId: Long): Order {
        return em.find(Order::class.java, orderId)
    }

    override fun findAllWithMemberDelivery(): List<Order> {
        return em.createQuery(
            "select o from Order o" +
            " join fetch o.member m" +
            " join fetch o.delivery",
            Order::class.java
        ).resultList
    }

    override fun findAllWithItem(): List<Order> {
        return em.createQuery(
            "select distinct o from Order o" +
            " join fetch o.member m" +
            " join fetch o.delivery d" +
            " join fetch o.orderItems oi" +
            " join fetch oi.item i",
            Order::class.java
        ).resultList
    }

}