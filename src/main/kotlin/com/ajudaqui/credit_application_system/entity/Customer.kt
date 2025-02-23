package com.ajudaqui.credit_application_system.entity

import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id


@Entity
// @Table(name = "client")
data class Customer(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Long? =null,
  var firstName: String="",
  var lastName: String="",
  var cpf: String="",
  var email: String="",
  var income: String="",
  var address: String="",
  var credits: List<String> = mutableListOf(),

)

