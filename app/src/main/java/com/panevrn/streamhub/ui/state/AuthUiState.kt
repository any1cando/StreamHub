package com.panevrn.streamhub.ui.state

data class AuthUiState(
    val email: String = "",
    val password: String = "",
    val usernameError: Boolean = false,
    val passwordError: Boolean = false,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)