package org.jpashop.jpashop2.domain

import jakarta.persistence.*
import jakarta.validation.constraints.NotEmpty

@Entity
class Member(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    val id: Long? = null,
    val name: String,
    @Embedded
    val address: Address,
    @OneToMany(mappedBy = "member")
    val orders: List<Order> = emptyList(),
)