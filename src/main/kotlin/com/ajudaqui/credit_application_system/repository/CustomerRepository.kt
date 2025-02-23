
package com.ajudaqui.credit_application_system.repository

import com.ajudaqui.credit_application_system.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository: JpaRepository< Customer, Long>
