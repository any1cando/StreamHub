package com.panevrn.data.dto.response

data class RegisterResponseDto(
    val message: String,
    val error: String,  // error это какой тип?
    val accessToken: String,
    val refreshToken: String,
    val userInfo: UserInfoEnter  // TODO: Сущность UserInfo уже есть на доске, нужно придумать какую-то другую сущность
)
