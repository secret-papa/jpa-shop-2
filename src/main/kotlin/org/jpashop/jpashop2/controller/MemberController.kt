package org.jpashop.jpashop2.controller

import org.jpashop.jpashop2.controller.dto.CreateMemberRequest
import org.jpashop.jpashop2.controller.dto.MemberDto
import org.jpashop.jpashop2.controller.dto.toDto
import org.jpashop.jpashop2.services.MemberService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/members")
class MemberController(
    private val memberService: MemberService,
) {
    @GetMapping("/{id}")
    fun findMember(@PathVariable id: Long): ResponseEntity<MemberDto> {
        val findMember = memberService.findMember(id)
        return ResponseEntity.ok(findMember.toDto())
    }

    @PostMapping("/new")
    fun addMember(@RequestBody request: CreateMemberRequest): ResponseEntity<Long?> {
        val newMemberId = memberService.createMember(request.toCommand())

        return ResponseEntity.ok(newMemberId)
    }
}