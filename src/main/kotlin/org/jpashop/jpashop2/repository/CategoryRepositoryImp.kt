package org.jpashop.jpashop2.repository

import jakarta.persistence.EntityManager
import org.jpashop.jpashop2.domain.Category
import org.springframework.stereotype.Repository

@Repository
class CategoryRepositoryImp(
    private val em: EntityManager
): CategoryRepository {
    override fun createCategory(category: Category): Long? {
        em.persist(category)
        return category.id
    }
}