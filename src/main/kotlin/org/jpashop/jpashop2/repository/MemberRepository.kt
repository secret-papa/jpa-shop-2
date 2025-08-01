package org.jpashop.jpashop2.repository

import org.jpashop.jpashop2.domain.Member
import java.util.*

interface MemberRepository {
    fun findAll() : List<Member>
    fun findMember(id: Long): Member
    fun createMember(member: Member): Long?
}