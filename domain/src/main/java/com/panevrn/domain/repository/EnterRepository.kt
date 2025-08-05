package com.panevrn.domain.repository

import com.panevrn.domain.model.LoginResult
import com.panevrn.domain.model.RegisterResult

interface EnterRepository {
    suspend fun login(email: String, password: String): Result<LoginResult>

    suspend fun register(name: String, password: String, birthDate: String, email: String, phone: String): Result<RegisterResult>
}