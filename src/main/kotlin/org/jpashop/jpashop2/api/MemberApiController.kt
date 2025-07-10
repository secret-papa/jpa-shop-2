package org.jpashop.jpashop2.api

import jakarta.validation.Valid
import org.jpashop.jpashop2.domain.Member
import org.jpashop.jpashop2.services.MemberService
import org.jpashop.jpashop2.services.command.CreateMemberCommand
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MemberApiController(
    private val memberService: MemberService
) {

    @PostMapping("/api/v1/members")
    fun saveMemberV1(@RequestBody @Valid member: Member): CreateMemberResponse {
      val id: Long? = memberService.createMember(CreateMemberCommand(member.name, member.address))

        return CreateMemberResponse(id)
    }


    data class CreateMemberResponse(
        val id: Long?
    )
}