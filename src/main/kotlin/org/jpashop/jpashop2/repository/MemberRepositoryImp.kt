package org.jpashop.jpashop2.repository

import jakarta.persistence.EntityManager
import org.jpashop.jpashop2.domain.Member
import org.springframework.stereotype.Repository

@Repository
class MemberRepositoryImp (
    private val em: EntityManager
): MemberRepository {
    override fun findAll(): List<Member> {
        return em.createQuery("select m from Member m", Member::class.java).resultList
    }

    override fun findMember(id: Long): Member {
        return em.find(Member::class.java, id)
    }

    override fun createMember(member: Member): Long? {
        em.persist(member)
        return member.id
    }
}