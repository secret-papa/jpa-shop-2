package org.jpashop.jpashop2.services.command

import org.jpashop.jpashop2.domain.Address

data class CreateMemberCommand(
    val name: String,
    val address: Address
)
