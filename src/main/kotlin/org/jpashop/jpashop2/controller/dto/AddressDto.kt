package org.jpashop.jpashop2.controller.dto

import org.jpashop.jpashop2.domain.Address

data class AddressDto (
    val city: String,
    val street: String,
    val zipCode: String,
)

fun Address.toDto() = AddressDto(
    city = this.city,
    street = this.street,
    zipCode = this.zipCode
)