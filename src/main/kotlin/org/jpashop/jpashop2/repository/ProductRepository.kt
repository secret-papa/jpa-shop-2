package org.jpashop.jpashop2.repository

import org.jpashop.jpashop2.domain.item.Item

interface ProductRepository {
    fun create(product: Item): Long?
    fun findById(id: Long): Item?
}