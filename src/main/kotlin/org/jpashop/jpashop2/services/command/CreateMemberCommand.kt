package org.jpashop.jpashop2.services.command

import org.jpashop.jpashop2.domain.Address
import org.jpashop.jpashop2.services.dto.AddressDto

data class CreateMemberCommand(
    val name: String,
    val address: AddressDto
)
