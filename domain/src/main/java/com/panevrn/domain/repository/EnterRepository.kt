package com.panevrn.domain.repository

import com.panevrn.domain.model.LoginResult

interface EnterRepository {
    suspend fun login(email: String, password: String): Result<LoginResult>
}