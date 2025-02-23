package com.ajudaqui.credit_application_system.entity

import jakarta.persistence.Entity
import jakarta.persistence.Table


@Entity
@Table(name = "client")
data class Customer(
  var id: Long? =null,
  var firstName: String="",
  var lastName: String="",
  var cpf: String="",
  var email: String="",
  var income: String="",
  var address: String="",
  var credits: List<String> = mutableListOf(),

)

