package com.shashinthalk.driver_charging_session_authenticator.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ValidationExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationExceptions(ex: MethodArgumentNotValidException): ResponseEntity<Map<String, List<String>>> {
        fun camelToSnake(name: String): String =
            name.replace(Regex("([a-z])([A-Z]+)"), "$1_$2").lowercase()
        val errors = ex.bindingResult.fieldErrors
            .groupBy { camelToSnake(it.field) }
            .mapValues { entry -> entry.value.map { it.defaultMessage ?: "Bad Request" } }
        return ResponseEntity(errors, HttpStatus.BAD_REQUEST)
    }
}