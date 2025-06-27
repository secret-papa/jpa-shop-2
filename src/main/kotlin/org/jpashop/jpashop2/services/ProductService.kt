package org.jpashop.jpashop2.services

import org.jpashop.jpashop2.domain.item.Album
import org.jpashop.jpashop2.domain.item.Book
import org.jpashop.jpashop2.domain.item.Item
import org.jpashop.jpashop2.domain.item.Movie
import org.jpashop.jpashop2.repository.CategoryRepository
import org.jpashop.jpashop2.repository.ProductRepository
import org.jpashop.jpashop2.services.command.CreateProductCommand
import org.jpashop.jpashop2.services.command.DType
import org.jpashop.jpashop2.services.command.UpdateProductCommand
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class ProductService(
    private val categoryRepository: CategoryRepository,
    private val productRepository: ProductRepository
) {
    @Transactional
    fun create(command: CreateProductCommand): Long? {
        val categories = command.categories.map { id ->
            categoryRepository.findById(id) ?: throw IllegalArgumentException("No category with id $id")
        }

        var item: Item
        if (command.dType == DType.ALBUM) {
            item = Album(
                name = command.name,
                price = command.price,
                stockQuantity = command.stockQuantity,
                categories = categories,
                artist = command.artist,
                etc = command.etc
            )
        } else if (command.dType == DType.BOOK) {
            item = Book(
                name = command.name,
                price = command.price,
                stockQuantity = command.stockQuantity,
                categories = categories,
                author = command.author,
                isBn = command.isbn,
            )
        } else {
            item = Movie(
                name = command.name,
                price = command.price,
                stockQuantity = command.stockQuantity,
                categories = categories,
                director = command.director,
                actor = command.actor
            )
        }

        return productRepository.create(item)
    }

    @Transactional
    fun update(command: UpdateProductCommand): Item {
        val product = productRepository.findById(command.id) ?: throw IllegalArgumentException("No product with id ${command.id}")

        val categories = command.categories?.map { id ->
            categoryRepository.findById(id) ?: throw IllegalArgumentException("No category with id $id")
        }

        product.update(
            name = command.name,
            price = command.price,
            stockQuantity = command.stockQuantity,
            categories = categories
        )

        return product
    }
}