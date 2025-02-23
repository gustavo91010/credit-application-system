package com.ajudaqui.credit_application_system.service

import com.ajudaqui.credit_application_system.dto.CustomerDTO
import com.ajudaqui.credit_application_system.entity.Customer
import com.ajudaqui.credit_application_system.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(private val customerRepository: CustomerRepository) {

  fun create(customerDTO: CustomerDTO): Customer {

    return customerDTO.let {
      save(
              Customer(
                      firstName = it.firstName,
                      lastName = it.lastName,
                      cpf = it.cpf,
                      email = it.email,
                      income = it.income,
                      address = it.address,
              )
      )
    }
  }

  private fun save(customer: Customer): Customer = customerRepository.save(customer)

  fun findById(id: Long): Customer =
          customerRepository.findById(id).orElseThrow {
            ClassNotFoundException("Cleinte id $id não localizado")
          }

  fun findByEmail(email: String): Customer =
          customerRepository.findByEmail(email).orElseThrow {
            ClassNotFoundException("Email $email não registrado")
          }
}
