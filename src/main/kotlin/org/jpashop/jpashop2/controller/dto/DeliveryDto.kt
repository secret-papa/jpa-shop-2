package org.jpashop.jpashop2.controller.dto

import org.jpashop.jpashop2.domain.Delivery

data class DeliveryDto(
    val address: AddressDto
)

fun Delivery.toDto() = DeliveryDto(
    address = this.address.toDto()
)
