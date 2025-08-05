package com.panevrn.data.mapper

import com.panevrn.data.dto.response.LoginResponseDto
import com.panevrn.data.dto.response.RegisterResponseDto
import com.panevrn.domain.model.LoginResult
import com.panevrn.domain.model.RegisterResult
import javax.inject.Inject

class EnterResponseMapper @Inject constructor() {

    fun mapToLoginResult(dto: LoginResponseDto): LoginResult = LoginResult(accessToken = dto.accessToken, refreshToken = dto.refreshToken)

    fun mapToRegisterResult(dto: RegisterResponseDto): RegisterResult = RegisterResult(
        message = dto.message,
        error = dto.error,
        accessToken = dto.accessToken,
        refreshToken = dto.refreshToken,
        userName = dto.userInfo.name,
        userAvatar = dto.userInfo.avatar
    )

}