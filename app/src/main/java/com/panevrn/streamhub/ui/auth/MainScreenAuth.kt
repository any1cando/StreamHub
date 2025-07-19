package com.panevrn.streamhub.ui.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import com.panevrn.streamhub.R
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.panevrn.streamhub.ui.elements.BlackButton
import com.panevrn.streamhub.ui.elements.TitleInputField
import com.panevrn.streamhub.ui.elements.TitleText


@Composable
fun MainScreenAuth(modifier: Modifier = Modifier.fillMaxSize()) {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var usernameError by remember { mutableStateOf(false) }
    var passwordError by remember { mutableStateOf(false) }

    Box(modifier = modifier) {

//        TitleText(
//            modifier = Modifier.fillMaxWidth(),
//            text = stringResource(R.string.auth_title)
//        )
//
//        Spacer(Modifier.height(144.dp))

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            TitleText(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.auth_title)
            )

            Spacer(Modifier.height(48.dp))

            TitleInputField(
                modifier = Modifier.fillMaxWidth(),
                titleText = stringResource(R.string.auth_username_title),
                labelInputText = stringResource(R.string.auth_username_input),
                value = username,
                onValueChange = {
                    username = it
                    usernameError = false
                },
                isError = usernameError,
                errorText = stringResource(R.string.auth_username_text_error)
            )

            Spacer(Modifier.height(48.dp))

            TitleInputField(
                modifier = Modifier.fillMaxWidth(),
                titleText = stringResource(R.string.reg_password_title),
                labelInputText = stringResource(R.string.reg_password_input),
                value = password,
                onValueChange = {
                    password = it
                    passwordError = false
                },
                isError = passwordError,
                errorText = stringResource(R.string.auth_password_text_error)
            )

            // TODO: Доделать две тексто-кнопки "Забыл пароль" + "Регистрация"

            Spacer(modifier = Modifier.weight(1f))

            BlackButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                textButton = stringResource(R.string.auth_text_button),
                onClick = {
                    usernameError = username.isBlank()
                    passwordError = password.length < 6

                    if (!usernameError && !passwordError) {
                        // TODO: Доделать успешный вход
                    }
                }
            )
        }
    }
}

