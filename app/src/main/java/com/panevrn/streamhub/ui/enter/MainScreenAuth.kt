package com.panevrn.streamhub.ui.enter


import android.widget.Toast
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.panevrn.streamhub.ui.elements.BlackButton
import com.panevrn.streamhub.ui.elements.ClickableText
import com.panevrn.streamhub.ui.elements.TitleInputField
import com.panevrn.streamhub.ui.elements.TitleText
import com.panevrn.streamhub.ui.state.AuthUiState


@Composable
fun MainScreenAuth(
    modifier: Modifier = Modifier.fillMaxSize(),
    uiState: AuthUiState,
    onUsernameChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onSubmit: () -> Unit
) {

    val context = LocalContext.current

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
                value = uiState.email,
                onValueChange = onUsernameChange,
                isError = uiState.emailError,
                errorText = uiState.errorEmailMessage
            )

            Spacer(Modifier.height(48.dp))

            TitleInputField(
                modifier = Modifier.fillMaxWidth(),
                titleText = stringResource(R.string.reg_password_title),
                labelInputText = stringResource(R.string.reg_password_input),
                value = uiState.password,
                onValueChange = onPasswordChange,
                isError = uiState.passwordError,
                errorText = uiState.errorPasswordMessage
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row() {
                ClickableText(
                    modifier = Modifier.padding(4.dp),
                    text = stringResource(R.string.auth_forgot_password)
                ) {
                    // TODO: Доделать клик на "Забыл пароль"
                    Toast.makeText(context, "Клик на 'Забыл пароль'", Toast.LENGTH_LONG).show()
                }

                ClickableText(
                    modifier = Modifier.padding(4.dp),
                    text = stringResource(R.string.auth_go_to_reg)
                ) {
                    // TODO: Доделать клик на "Регистрация" (переход на экран Регистрации)
                    Toast.makeText(context, "Клик на 'Регистрация'", Toast.LENGTH_LONG).show()
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            BlackButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                textButton = stringResource(R.string.auth_text_button),
                onClick = onSubmit,
                enabled = !uiState.isLoading
            )
        }
    }
}

