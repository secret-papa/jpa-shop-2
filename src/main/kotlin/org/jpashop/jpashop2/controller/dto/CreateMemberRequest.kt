package org.jpashop.jpashop2.controller.dto

import org.jpashop.jpashop2.domain.Address
import org.jpashop.jpashop2.services.command.CreateMemberCommand

data class CreateMemberRequest(
    val name: String,
    val address: AddressDto,
) {
    fun toCommand(): CreateMemberCommand = CreateMemberCommand(
        name = name,
        address = org.jpashop.jpashop2.services.dto.AddressDto(
            city = address.city,
            street = address.street,
            zipCode = address.zipCode
        ),
    )
}
