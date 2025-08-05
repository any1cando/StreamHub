package com.panevrn.domain.usecase

import com.panevrn.domain.repository.EnterRepository

class RegisterUseCase(private val repository: EnterRepository) {

    suspend operator fun invoke(name: String, password: String, birthDate: String, email: String, phone: String) {
        repository.register(
            name = name,
            password = password,
            birthDate = birthDate,
            email = email,
            phone = phone
        )
    }


}