package com.ajudaqui.credit_application_system.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Enumerated
import jakarta.persistence.EnumType
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID
import com.ajudaqui.credit_application_system.utils.enum.EStatus

@Entity
data class Credit( //credito liberado 
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
        var creditCode: UUID,
        var creditValue: BigDecimal = BigDecimal.ZERO,
        var dayFirstOfInstallment: LocalDate, // dia da primeira Prestação
        var numberOfInstallments: Int, // numero de Prestação
        var customerId: Long,

        @Enumerated(value = EnumType.STRING)
        var status: EStatus
)
