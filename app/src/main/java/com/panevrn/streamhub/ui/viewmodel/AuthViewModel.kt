package com.panevrn.streamhub.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.panevrn.streamhub.ui.state.AuthUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class AuthViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(AuthUiState())
    val uiState: StateFlow<AuthUiState> = _uiState.asStateFlow()

    fun onEmailChanged(newInput: String) {
        _uiState.update { it.copy(email = newInput, usernameError = false) }
    }

    fun onPasswordChanged(newInput: String) {
        _uiState.update { it.copy(password = newInput, passwordError = false) }
    }

    fun onSubmit() {
        val value = _uiState.value
        val usernameError = false  // TODO: Сделать валидацию на почту
        val passwordError = false  // TODO: Сделать валидацию на пароль

        if (usernameError || passwordError) {
            _uiState.update {
                it.copy(usernameError = usernameError, passwordError = passwordError)
                return
            }
        }

        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, errorMessage = null) }

            // TODO: Сделать обработку UseCase - LoginUseCase
        }

    }

}