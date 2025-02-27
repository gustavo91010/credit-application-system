
package com.ajudaqui.credit_application_system.repository

import com.ajudaqui.credit_application_system.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.Optional

interface CustomerRepository: JpaRepository< Customer, Long>{

  fun findByEmail(email: String): Optional<Customer>

  fun findByCpf(cpf: String): Optional<Customer>

  @Query(value = "SELECT COUNT(*) > 0 FROM customer where cpf= :cpf OR email= :email", nativeQuery= true) 
  fun alreadyregistered(cpf: String, email: String): Boolean
}

