package org.jpashop.jpashop2.services

import org.jpashop.jpashop2.domain.*
import org.jpashop.jpashop2.repository.MemberRepository
import org.jpashop.jpashop2.repository.OrderRepository
import org.jpashop.jpashop2.repository.ProductRepository
import org.jpashop.jpashop2.services.command.CreateOrderCommand
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class OrderService(
    private val productRepository: ProductRepository,
    private val memberRepository: MemberRepository,
    private val orderRepository: OrderRepository
) {
    fun findAll(memberId: Long): List<Order> {
        return orderRepository.findAll(memberId)
    }

    @Transactional
    fun create(command: CreateOrderCommand): Long? {
        val member = memberRepository.findMember(command.memberId)
        val orderItems = command.orderItems.map { orderItem ->
            OrderItem(
                item = productRepository.findById(orderItem.id),
                orderPrice = orderItem.orderPrice,
                count = orderItem.count
            )
        }
        val delivery = Delivery(
            address = Address(
                    city = command.delivery.address.city,
                    zipCode = command.delivery.address.zipCode,
                    street = command.delivery.address.street,
                ),
            deliveryStatus = DeliveryStatus.DOING
        )

        val order = Order(
            member = member,
            status = OrderStatus.DRAFT
        )

        order.addOrderItems(orderItems)
        order.addDelivery(delivery)

        return orderRepository.create(order)
    }
}