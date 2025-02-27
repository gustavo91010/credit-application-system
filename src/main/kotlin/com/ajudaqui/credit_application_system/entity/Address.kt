package com.ajudaqui.credit_application_system.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.Table
import jakarta.persistence.ManyToOne

@Entity
@Table(name = "address")
data class Address(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
        @Column(nullable = false) var zipCode: String = "",
        @Column(nullable = false) var street: String = "",
        @Column(nullable = false) var number: String = "",
        @ManyToOne @JoinColumn(name = "customer_id") @JsonIgnore var customer: Customer? = null,
)
