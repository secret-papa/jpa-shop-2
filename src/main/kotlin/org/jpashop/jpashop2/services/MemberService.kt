package org.jpashop.jpashop2.services

import org.jpashop.jpashop2.domain.Member
import org.jpashop.jpashop2.repository.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class MemberService(
    val memberRepository: MemberRepository
) {
    @Transactional
    fun createMember(): Long? {
        val member = Member(name = "lee")
        return memberRepository.createMember(member)
    }
}