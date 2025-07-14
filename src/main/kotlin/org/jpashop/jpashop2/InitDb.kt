package org.jpashop.jpashop2

import jakarta.annotation.PostConstruct
import jakarta.persistence.EntityManager
import org.jpashop.jpashop2.domain.*
import org.jpashop.jpashop2.domain.item.Book
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class InitDb(
    private val initService: InitService
) {

    @PostConstruct
    fun init() {
        initService.dbInit1()
        initService.dbInit2()
    }

    @Component
    @Transactional
    class InitService(
        val em: EntityManager
    ) {
        fun dbInit1() {
           val member = Member(
               name = "userA",
               address = Address(
                   "서울", "1", "111"
               )
           )
           em.persist(member)

            val book1 = Book(name = "JPA1 BOOK", price = 10000, stockQuantity = 100)
            em.persist(book1)
            val book2 = Book(name = "JPA2 BOOK", price = 20000, stockQuantity = 100)
            em.persist(book2)

            val orderItem1 = OrderItem(item = book1, orderPrice = 10000, count = 1)
            val orderItem2 = OrderItem(item = book2, orderPrice = 20000, count = 2)
            val delivery = Delivery(address = member.address, deliveryStatus = DeliveryStatus.DOING)
            val order = Order(member = member, delivery = delivery, orderItems = listOf(orderItem1, orderItem2), status = OrderStatus.DRAFT)
            em.persist(order)
        }

        fun dbInit2() {
            val member = Member(
                name = "userB",
                address = Address(
                    "부산", "2", "2222"
                )
            )
            em.persist(member)

            val book1 = Book(name = "SPRING1 BOOK", price = 10000, stockQuantity = 100)
            em.persist(book1)
            val book2 = Book(name = "SPRING2 BOOK", price = 20000, stockQuantity = 100)
            em.persist(book2)

            val orderItem1 = OrderItem(item = book1, orderPrice = 10000, count = 1)
            val orderItem2 = OrderItem(item = book2, orderPrice = 20000, count = 2)
            val delivery = Delivery(address = member.address, deliveryStatus = DeliveryStatus.DOING)
            val order = Order(member = member, delivery = delivery, orderItems = listOf(orderItem1, orderItem2), status = OrderStatus.DRAFT)
            em.persist(order)
        }
    }
}
