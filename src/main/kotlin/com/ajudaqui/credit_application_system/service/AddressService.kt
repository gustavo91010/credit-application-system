package com.ajudaqui.credit_application_system.service

import com.ajudaqui.credit_application_system.dto.AddressDTO
import com.ajudaqui.credit_application_system.entity.Address
import com.ajudaqui.credit_application_system.repository.AddressRepository
import org.springframework.stereotype.Service

@Service
class AddressService(private val addressRepository: AddressRepository) {

  fun create(addressDTO: AddressDTO): Address {
    return addressDTO.let {
      save(Address(zipCode = it.zipCode, street = it.street, number = it.number))
    }
  }

  private fun save(address: Address): Address = addressRepository.save(address)

  fun findByZipCode(zipCode: String): Address =
          addressRepository.findByZipCode(zipCode).orElseThrow {
            ClassNotFoundException("Caixa postal numero $zipCode não localizado")
          }
}
