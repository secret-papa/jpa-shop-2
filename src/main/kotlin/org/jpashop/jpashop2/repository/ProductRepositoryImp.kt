package org.jpashop.jpashop2.repository

import jakarta.persistence.EntityManager
import org.jpashop.jpashop2.domain.item.Item
import org.springframework.stereotype.Repository

@Repository
class ProductRepositoryImp(
    private val em: EntityManager
): ProductRepository {
    override fun create(product: Item): Long? {
        em.persist(product)
        return product.id
    }
}