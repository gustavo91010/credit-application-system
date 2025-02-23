
package com.ajudaqui.credit_application_system.repository

import com.ajudaqui.credit_application_system.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface CustomerRepository: JpaRepository< Customer, Long>{
  fun findByEmail(email: String): Optional<Customer>
}

