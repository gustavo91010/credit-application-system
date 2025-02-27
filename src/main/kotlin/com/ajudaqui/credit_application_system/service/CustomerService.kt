package com.ajudaqui.credit_application_system.service

import com.ajudaqui.credit_application_system.dto.CustomerDTO
import com.ajudaqui.credit_application_system.entity.Customer
import com.ajudaqui.credit_application_system.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(private val customerRepository: CustomerRepository) {

  fun create(customerDTO: CustomerDTO): Customer {
var alreadyregistered = customerRepository.alreadyregistered(customerDTO.cpf, customerDTO.email) as Boolean

if(alreadyregistered){
  // throw NotAut
}
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
  fun findAll(): List<Customer> = customerRepository.findAll()

  fun delete(id: Long) = customerRepository.delete(findById(id))

  fun update(id: Long, customerDTO: CustomerDTO): Customer {
    var customerUpdated =
            findById(id)
                    .copy(
                            firstName = customerDTO.firstName,
                            lastName = customerDTO.lastName,
                            cpf = customerDTO.cpf,
                            email = customerDTO.email,
                            address = customerDTO.address,
                            income = customerDTO.income
                    )
    return customerRepository.save(customerUpdated)
  }
}
