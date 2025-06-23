package org.jpashop.jpashop2

import org.jpashop.jpashop2.domain.Member
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JpaShop2Application

fun main(args: Array<String>) {
    runApplication<JpaShop2Application>(*args)

    val member: Member = Member(name = "lee");
}
