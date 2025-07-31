package com.panevrn.streamhub.viewmodel

import androidx.lifecycle.ViewModel
import com.panevrn.streamhub.ui.state.RegisterUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.time.LocalDate

class RegViewModel(): ViewModel() {

    private val _uiState: MutableStateFlow<RegisterUiState> = MutableStateFlow(RegisterUiState())
    val uiState: StateFlow<RegisterUiState> = _uiState.asStateFlow()

    fun onUsernameChanged(newInput: String) {
        _uiState.update { it.copy(username = newInput) }
    }

    fun onPasswordChanged(newInput: String) {
        _uiState.update { it.copy(password = newInput) }
    }

    fun onBirthdayChanged(newInput: LocalDate?) {
        _uiState.update { it.copy(birthDate = newInput) }
    }

    fun onEmailChanged(newInput: String) {
        _uiState.update { it.copy(email = newInput) }
    }

    fun onPhoneChanged(newInput: String) {
        _uiState.update { it.copy(phone = newInput) }
    }

    fun onSubmit() {

    }




}