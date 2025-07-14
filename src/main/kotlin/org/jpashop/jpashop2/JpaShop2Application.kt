package org.jpashop.jpashop2

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module
import org.jpashop.jpashop2.domain.Member
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class JpaShop2Application

fun main(args: Array<String>) {
    runApplication<JpaShop2Application>(*args)
}

@Bean
fun hibernate5Module(): Hibernate5Module {
    val hibernate5Module = Hibernate5Module()
//    hibernate5Module.configure(Hibernate5Module.Feature.FORCE_LAZY_LOADING, true)
    return hibernate5Module
}