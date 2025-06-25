package org.jpashop.jpashop2.controller

import org.jpashop.jpashop2.controller.dto.CreateMemberRequest
import org.jpashop.jpashop2.services.MemberService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/members")
class MemberController(
    private val memberService: MemberService,
) {
    @PostMapping("/new")
    fun addMember(@RequestBody request: CreateMemberRequest): ResponseEntity<Long?> {
        val newMemberId = memberService.createMember(request.toCommand())

        return ResponseEntity.ok(newMemberId)
    }
}