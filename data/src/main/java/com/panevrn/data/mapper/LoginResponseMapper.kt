package com.panevrn.data.mapper

import com.panevrn.data.dto.LoginResponseDto
import com.panevrn.domain.model.LoginResult
import javax.inject.Inject

class LoginResponseMapper @Inject constructor() {

    fun map(dto: LoginResponseDto): LoginResult = LoginResult(token = dto.token)

}