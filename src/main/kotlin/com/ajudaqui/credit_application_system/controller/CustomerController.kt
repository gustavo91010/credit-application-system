package com.ajudaqui.credit_application_system.controller

import com.ajudaqui.credit_application_system.dto.CustomerDTO
import com.ajudaqui.credit_application_system.entity.Customer
import com.ajudaqui.credit_application_system.service.CustomerService
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/customer")
class CustomerController(private val customerService: CustomerService) {

  @PostMapping()
  fun register(@RequestBody customerDTO: CustomerDTO): Customer {

    return customerService.create(customerDTO)
  }

@GetMapping("/id/{id}")
  fun findById(@PathVariable id: Long):Customer{
    return customerService.findById(id)
  }
}
