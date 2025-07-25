package com.panevrn.streamhub.ui.state

import java.time.LocalDate

data class RegisterUiState(
    val username: String = "",
    val password: String = "",
    val email: String = "",
    val phone: String = "",
    val birthDate: LocalDate? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val isRegistered: Boolean = false
)