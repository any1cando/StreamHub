package com.panevrn.streamhub.ui.enter


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import com.panevrn.streamhub.ui.elements.ClickableText
import com.panevrn.streamhub.ui.elements.TitleInputField
import com.panevrn.streamhub.ui.elements.TitleText


@Composable
fun MainScreenAuth(modifier: Modifier = Modifier.fillMaxSize()) {

    var usernameAuth by remember { mutableStateOf("") }
    var passwordAuth by remember { mutableStateOf("") }

    var usernameErrorAuth by remember { mutableStateOf(false) }
    var passwordErrorAuth by remember { mutableStateOf(false) }

    Box(modifier = modifier) {

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
                value = usernameAuth,
                onValueChange = {
                    usernameAuth = it
                    usernameErrorAuth = false
                },
                isError = usernameErrorAuth,
                errorText = stringResource(R.string.auth_username_text_error)
            )

            Spacer(Modifier.height(48.dp))

            TitleInputField(
                modifier = Modifier.fillMaxWidth(),
                titleText = stringResource(R.string.reg_password_title),
                labelInputText = stringResource(R.string.reg_password_input),
                value = passwordAuth,
                onValueChange = {
                    passwordAuth = it
                    passwordErrorAuth = false
                },
                isError = passwordErrorAuth,
                errorText = stringResource(R.string.auth_password_text_error)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row() {
                ClickableText(
                    modifier = Modifier.padding(4.dp),
                    text = stringResource(R.string.auth_forgot_password)
                ) {
                    // TODO: Доделать клик на "Забыл пароль"
                }

                ClickableText(
                    modifier = Modifier.padding(4.dp),
                    text = stringResource(R.string.auth_go_to_reg)
                ) {
                    // TODO: Доделать клик на "Регистрация" (переход на экран Регистрации)
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            BlackButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                textButton = stringResource(R.string.auth_text_button),
                onClick = {
                    usernameErrorAuth = usernameAuth.isBlank()
                    passwordErrorAuth = passwordAuth.length < 6

                    if (!usernameErrorAuth && !passwordErrorAuth) {
                        // TODO: Доделать успешный вход
                    }
                }
            )
        }
    }
}

