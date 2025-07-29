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
        _uiState.update { it.copy(email = newInput, emailError = false) }
    }

    fun onPasswordChanged(newInput: String) {
        _uiState.update { it.copy(password = newInput, passwordError = false) }
    }

    fun onSubmit() {

        // Проверяем на валидацию почту, пароль
        validateEmail(_uiState.value.email)
        validatePassword(_uiState.value.password)

        // Проверяем флаги от проверок
        if (_uiState.value.emailError || _uiState.value.passwordError) { return }

        // Запускаем корутину
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, errorEmailMessage = null, errorPasswordMessage = null) }

            // TODO: Сделать обработку UseCase - LoginUseCase

            // После того, как мы успешно получаем ответ от сервера, делаем кнопку снова активной
            _uiState.update { it.copy(isLoading = false) }
        }

    }

    private fun validateEmail(email: String) {
        when {
            email.isBlank() -> _uiState.update { it.copy(emailError = true, errorEmailMessage = "Email не может быть пустой") }
            !android.util.Patterns.EMAIL_ADDRESS.matcher(email)
                .matches() -> _uiState.update { it.copy(emailError = true, errorEmailMessage = "Email должен выглядеть как email!") }
            else -> _uiState.update { it.copy(emailError = false, errorEmailMessage = null) }
        }
    }

    private fun validatePassword(password: String) {
        when {
            password.length < 5 -> _uiState.update { it.copy(passwordError = true, errorPasswordMessage = "Пароль должен содержать минимум 5 символов") }
            else -> _uiState.update { it.copy(passwordError = false, errorPasswordMessage = null) }
        }
    }

}