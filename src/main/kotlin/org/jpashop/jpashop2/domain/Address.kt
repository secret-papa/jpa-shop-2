package org.jpashop.jpashop2.domain

import jakarta.persistence.Embeddable

@Embeddable
data class Address(
    val city: String,
    val street: String,
    val zipCode: String,
) {}
