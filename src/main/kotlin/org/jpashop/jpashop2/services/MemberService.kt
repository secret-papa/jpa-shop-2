package org.jpashop.jpashop2.services

import org.jpashop.jpashop2.domain.Member
import org.jpashop.jpashop2.repository.MemberRepository
import org.jpashop.jpashop2.services.command.CreateMemberCommand
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class MemberService(
    private val memberRepository: MemberRepository
) {
    fun findMember(memberId: Long): Member {
        return memberRepository.findMember(memberId)
    }

    @Transactional
    fun createMember(command: CreateMemberCommand): Long? {
        val member = Member(name = command.name, address = command.address)
        return memberRepository.createMember(member)
    }
}