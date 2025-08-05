package com.panevrn.data.dto.request

data class RegisterRequestDto(
    val name: String,
    val password: String,
    val birthDate: String,
    val email: String,
    val phone: String
)