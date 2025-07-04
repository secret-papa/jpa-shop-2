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

    override fun findById(id: Long): Item {
        return em.find(Item::class.java, id)
    }

    override fun findAll(): List<Item> {
        return em.createQuery("from Item", Item::class.java).resultList
    }

}