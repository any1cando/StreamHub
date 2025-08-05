package com.panevrn.data.dto.response

data class LoginResponseDto(
    val accessToken: String,
    val refreshToken: String
)