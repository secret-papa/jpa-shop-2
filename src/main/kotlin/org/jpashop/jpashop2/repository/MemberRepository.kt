package org.jpashop.jpashop2.repository

import org.jpashop.jpashop2.domain.Member

interface MemberRepository {
    fun createMember(member: Member): Long?
}