package org.jpashop.jpashop2.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
class Member(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    val id: Long? = null,
    var name: String,
    @Embedded
    val address: Address,
    @JsonIgnore
    @OneToMany(mappedBy = "member")
    val orders: List<Order> = emptyList(),
)