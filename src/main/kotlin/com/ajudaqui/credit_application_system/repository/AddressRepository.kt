
package com.ajudaqui.credit_application_system.repository

import com.ajudaqui.credit_application_system.entity.Customer
import com.ajudaqui.credit_application_system.entity.Address
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.Optional

interface AddressRepository: JpaRepository< Address, Long>{
  fun findByZipCode(zipCode: String) : Optional<Address>
}

