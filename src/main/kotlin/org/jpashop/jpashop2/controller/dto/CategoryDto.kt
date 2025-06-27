package org.jpashop.jpashop2.controller.dto

data class CategoryDto(
    val id: Long?,
    val name: String,
    val items: List<Long?>,
    val parent: Long?,
    val children: List<Long?>
)
