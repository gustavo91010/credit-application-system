package com.ajudaqui.credit_application_system.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
// @Table(name = "client")
data class Customer(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
        @Column(nullable = false) var firstName: String = "",
        @Column(nullable = false) var lastName: String = "",
        @Column(nullable = false, unique = true) var cpf: String = "",
        @Column(nullable = false, unique = true) var email: String = "",
        @Column(nullable = false) var passwore: String = "",
        @Column(nullable = false) var income: String = "", // rendiemnto, media salarial
        @Column(nullable = false) var address: String = "",
        var credits: List<String> = mutableListOf(),
)
