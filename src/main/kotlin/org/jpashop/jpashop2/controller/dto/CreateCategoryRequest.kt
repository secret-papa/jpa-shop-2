package org.jpashop.jpashop2.controller.dto

import org.jpashop.jpashop2.services.command.CreateCategoryCommand

data class CreateCategoryRequest(
    val name: String
) {
    fun toCommand(): CreateCategoryCommand {
        return CreateCategoryCommand(name)
    }
}
