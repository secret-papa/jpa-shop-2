package org.jpashop.jpashop2.controller.dto

import org.jpashop.jpashop2.domain.Member

data class MemberDto(
    val id: Long?,
    val name: String,
    val address: AddressDto
)

fun Member.toDto() = MemberDto(
    id = this.id,
    name = this.name,
    address = AddressDto(
        city = this.address.city,
        street = this.address.street,
        zipCode = this.address.zipCode
    ),
)