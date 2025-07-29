package com.panevrn.streamhub.ui.state

data class AuthUiState(
    val email: String = "",
    val password: String = "",
    val emailError: Boolean = false,
    val passwordError: Boolean = false,
    val isLoading: Boolean = false,
    val errorEmailMessage: String? = null,
    val errorPasswordMessage: String? = null
)