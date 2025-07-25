package com.panevrn.streamhub.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.panevrn.streamhub.ui.enter.MainScreenReg
import com.panevrn.streamhub.ui.enter.MainScreenAuth
import com.panevrn.streamhub.ui.viewmodel.AuthViewModel
import com.panevrn.streamhub.ui.viewmodel.RegViewModel
import dagger.hilt.android.AndroidEntryPoint


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val viewModelAuth: AuthViewModel by viewModels()
            val viewModelReg: RegViewModel by viewModels()

            val uiStateAuth by viewModelAuth.uiState.collectAsState()
            val uiStateReg by viewModelReg.uiState.collectAsState()

//            MainScreenAuth(
//                uiState = uiState,
//                onUsernameChange = viewModel::onUsernameChanged,
//                onPasswordChange = viewModel::onPasswordChanged,
//                onSubmit = viewModel::onSubmit,
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(WindowInsets.safeDrawing.asPaddingValues())  // Теперь ничего не вылезет за экран
//                    .padding(top = 32.dp, bottom = 32.dp, start = 16.dp, end = 16.dp)
//            )
            MainScreenReg(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(WindowInsets.safeDrawing.asPaddingValues())  // Теперь ничего не вылезет за экран
                    .padding(top = 32.dp, bottom = 32.dp, start = 16.dp, end = 16.dp),
                uiState = uiStateReg,
                onUsernameChanged = viewModelReg::onUsernameChanged,
                onPasswordChanged = viewModelReg::onPasswordChanged,
                onBirthdayChanged = viewModelReg::onBirthdayChanged,
                onEmailChanged = viewModelReg::onPasswordChanged,
                onPhoneChanged = viewModelReg::onPhoneChanged,
                onSubmit = viewModelReg::onSubmit
            )
        }
    }
}