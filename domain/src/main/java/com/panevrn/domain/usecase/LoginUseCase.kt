package com.panevrn.domain.usecase

import com.panevrn.domain.model.LoginResult
import com.panevrn.domain.repository.EnterRepository

class LoginUseCase(private val repository: EnterRepository) {
    suspend operator fun invoke(email: String, password: String): Result<LoginResult> {
        return repository.login(email, password)
    }
}