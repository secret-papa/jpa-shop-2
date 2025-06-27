package org.jpashop.jpashop2.controller.exception

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgumentException(error: IllegalArgumentException): ResponseEntity<String> {
        return ResponseEntity.badRequest().body(error.message)
    }
}