package org.jpashop.jpashop2.repository

import jakarta.persistence.EntityManager
import org.jpashop.jpashop2.domain.Member
import org.springframework.stereotype.Repository

@Repository
class MemberRepositoryImp (
    val em: EntityManager
): MemberRepository {
    override fun createMember(member: Member): Long? {
        em.persist(member)
        return member.id
    }
}