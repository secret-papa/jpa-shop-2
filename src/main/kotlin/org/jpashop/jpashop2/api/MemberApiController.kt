package org.jpashop.jpashop2.api

import jakarta.validation.Valid
import jakarta.validation.constraints.NotEmpty
import org.jpashop.jpashop2.domain.Member
import org.jpashop.jpashop2.services.MemberService
import org.jpashop.jpashop2.services.command.CreateMemberCommand
import org.jpashop.jpashop2.services.dto.AddressDto
import org.springframework.http.converter.StringHttpMessageConverter
import org.springframework.web.bind.annotation.*

@RestController
class MemberApiController(
    private val memberService: MemberService,
    private val stringHttpMessageConverter: StringHttpMessageConverter
) {

    @GetMapping("/api/v1/members")
    fun membersV2(): Result<List<MemberDto>> {
        val findMembers = memberService.findAll()
        val collect = findMembers.map { m -> MemberDto(m.name) }

        return Result(collect)
    }

    @PostMapping("/api/v1/members")
    fun saveMemberV1(@RequestBody @Valid member: Member): CreateMemberResponse {
      val id: Long? = memberService.createMember(
          CreateMemberCommand(
            member.name,
            AddressDto(
                zipCode = member.address.zipCode,
                city = member.address.city,
                street = member.address.street
            )))

        return CreateMemberResponse(id)
    }

    @PostMapping("/api/v2/members")
    fun saveMemberV2(@RequestBody @Valid request: CreateMemberRequest): CreateMemberResponse {
        val id: Long? = memberService.createMember(CreateMemberCommand(request.name, request.address))

        return CreateMemberResponse(id)
    }

    @PutMapping("/api/v2/members/{id}")
    fun updateMemberV2(
        @PathVariable("id") id: Long,
        @RequestBody @Valid request: UpdateMemberRequest
    ): UpdateMemberResponse {
        memberService.update(id, request.name)
        val findMember = memberService.findMember(id)

        return UpdateMemberResponse(findMember.id, findMember.name)
    }

    data class Result<T>(
        val data: T,
    )

    data class MemberDto(
        val name: String,
    )

    data class CreateMemberRequest(
        @NotEmpty
        val name: String,
        val address: AddressDto
    )


    data class CreateMemberResponse(
        val id: Long?
    )

    data class UpdateMemberRequest(
        val name: String
    )

    data class UpdateMemberResponse(
        val id: Long?,
        val name: String
    )
}