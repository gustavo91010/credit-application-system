
package com.ajudaqui.credit_application_system.exception
import org.springframework.web.bind.annotation.ControllerAdvice
import org.slf4j.LoggerFactory

@ControllerAdvice
class GlobalHandleException {

  private val logger = LoggerFactory.getLogger(GlobalHandleException::class.java)

fun handleException(
  ex: Exception,
  request: WebRequest
)

}
