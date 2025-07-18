package org.jpashop.jpashop2.controller

import org.jpashop.jpashop2.controller.dto.CreateProductRequest
import org.jpashop.jpashop2.controller.dto.ItemDto
import org.jpashop.jpashop2.controller.dto.UpdateProductRequest
import org.jpashop.jpashop2.controller.dto.toDto
import org.jpashop.jpashop2.services.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

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

    @PatchMapping("/{productId}")
    fun updateProduct(@PathVariable productId: Long, @RequestBody request: UpdateProductRequest): ResponseEntity<ItemDto> {
        val item = productService.update(request.toCommand(productId))

        return ResponseEntity.ok(item.toDto())
    }

    @GetMapping
    fun findAll(): ResponseEntity<List<ItemDto>> {
        return ResponseEntity.ok(productService.findAll().map { it.toDto() })
    }
}