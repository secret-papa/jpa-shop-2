package org.jpashop.jpashop2.controller

import org.jpashop.jpashop2.controller.dto.CreateProductRequest
import org.jpashop.jpashop2.services.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductController(
    private val productService: ProductService
) {
    @PostMapping("/new")
    fun createProduct(@RequestBody request: CreateProductRequest): ResponseEntity<Long?> {
        val product = productService.create(request.toCommand())

        return ResponseEntity.ok(product)
    }
}