package com.panevrn.domain.model

data class RegisterResult(
    val message: String,
    val error: String,  // error это какой тип?
    val accessToken: String,
    val refreshToken: String,
    val userName: String,
    val userAvatar: String // TODO: Uri/Url ?? Или просто String>?
)