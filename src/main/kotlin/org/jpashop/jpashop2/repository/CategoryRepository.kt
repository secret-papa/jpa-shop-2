package org.jpashop.jpashop2.repository

import org.jpashop.jpashop2.domain.Category

interface CategoryRepository {
    fun createCategory(category: Category): Long?
}