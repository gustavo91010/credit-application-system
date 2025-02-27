package com.ajudaqui.credit_application_system.dto

data class CustomerDTO(
        var firstName: String = "",
        var lastName: String = "",
        var cpf: String = "",
        var email: String = "",
        var income: String = "",
        var zipCode: String = "",
        var street: String = "",
        var number: String = ""
)
