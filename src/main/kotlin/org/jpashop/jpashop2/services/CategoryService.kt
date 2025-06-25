package org.jpashop.jpashop2.services

import org.jpashop.jpashop2.domain.Category
import org.jpashop.jpashop2.repository.CategoryRepository
import org.jpashop.jpashop2.services.command.CreateCategoryCommand
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class CategoryService(
    private val categoryRepository: CategoryRepository
) {
    @Transactional
    fun create(command: CreateCategoryCommand): Long? {
        val category = Category(name = command.name)
        return categoryRepository.createCategory(category)
    }
}