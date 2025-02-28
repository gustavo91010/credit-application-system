package com.ajudaqui.credit_application_system.service

import com.ajudaqui.credit_application_system.dto.AddressDTO
import com.ajudaqui.credit_application_system.dto.CustomerDTO
import com.ajudaqui.credit_application_system.entity.Customer
import com.ajudaqui.credit_application_system.exception.NoAutorizationException
import com.ajudaqui.credit_application_system.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
        private val customerRepository: CustomerRepository,
        private val addressService: AddressService
) {

  fun create(customerDTO: CustomerDTO): Customer {
    var alreadyregistered = customerRepository.alreadyregistered(customerDTO.cpf, customerDTO.email)
    if (alreadyregistered) {
      throw NoAutorizationException("Email / CPF já cadastrado")
    }

    var adrress =
            addressService.create(
                    AddressDTO(customerDTO.zipCode, customerDTO.street, customerDTO.number)
            )
    return customerDTO.let {
      save(
              Customer(
                              firstName = it.firstName,
                              lastName = it.lastName,
                              cpf = it.cpf,
                              email = it.email,
                              income = it.income,
                      )
                      .apply { this.address.add(adrress)}
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
  fun findByCpf(cpf: String): Customer =
          customerRepository.findByCpf(cpf).orElseThrow {
            ClassNotFoundException("CPF de numeero $cpf não registrado")
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
                            income = customerDTO.income
                    )
    customerUpdated.address.add(
            addressService.create(
                    AddressDTO(customerDTO.zipCode, customerDTO.street, customerDTO.number)
            )
    )

    return customerRepository.save(customerUpdated)
  }
}
