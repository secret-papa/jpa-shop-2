package org.jpashop.jpashop2.controller

import org.jpashop.jpashop2.controller.dto.CreateCategoryRequest
import org.jpashop.jpashop2.services.CategoryService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/categories")
class CategoryController(
    private val categoryService: CategoryService
) {
    @PostMapping("/new")
    fun createCategory(@RequestBody request: CreateCategoryRequest): ResponseEntity<Long> {
        val newCategory = categoryService.create(request.toCommand())

        return ResponseEntity.ok(newCategory)
    }
}