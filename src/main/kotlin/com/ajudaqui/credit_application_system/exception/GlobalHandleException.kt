package com.ajudaqui.credit_application_system.exception

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.BeanCreationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class GlobalHandleException {

  private val logger = LoggerFactory.getLogger(GlobalHandleException::class.java)

  fun handleException(ex: Exception, request: WebRequest): ResponseEntity<ErrorResponse> {

    val status = exceptionStatus[ex::class.java] ?: HttpStatus.INTERNAL_SERVER_ERROR
    val message = "deu pau boy..."

    logger.error(message)

    val errorResponse =
            ex.message?.let { ErrorResponse(message = it, details = request.getDescription(false)) }

    return ResponseEntity(errorResponse, status)
  }

  private val exceptionStatus = mapOf(BeanCreationException::class.java to HttpStatus.BAD_REQUEST)

  data class ErrorResponse(
          val message: String,
          val timestamp: String = java.time.LocalDateTime.now().toString(),
          val details: String? = null,
          val errors: List<FieldErrorResponse>? = null
  )
  data class FieldErrorResponse(val field: String, val message: String)
}
