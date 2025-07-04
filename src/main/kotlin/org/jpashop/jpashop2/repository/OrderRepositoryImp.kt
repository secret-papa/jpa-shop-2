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
}