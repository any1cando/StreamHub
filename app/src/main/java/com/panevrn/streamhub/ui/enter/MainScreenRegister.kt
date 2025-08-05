package com.panevrn.streamhub.ui.enter

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.panevrn.streamhub.ui.elements.BirthdayPicker
import com.panevrn.streamhub.ui.elements.TitleInputField
import com.panevrn.streamhub.ui.elements.TitleText
import com.panevrn.streamhub.ui.theme.Black
import java.time.LocalDate
import com.panevrn.streamhub.R
import com.panevrn.streamhub.ui.elements.BlackButton
import com.panevrn.streamhub.ui.elements.ClickableText
import com.panevrn.streamhub.ui.elements.PhoneInputField
import com.panevrn.streamhub.ui.state.RegisterUiState


@Composable
fun MainScreenRegister(
    modifier: Modifier = Modifier,
    uiState: RegisterUiState,
    onUsernameChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onEmailChanged: (String) -> Unit,
    onBirthdayChanged: (LocalDate?) -> Unit,
    onPhoneChanged: (String) -> Unit,
    onSubmit: () -> Unit
) {

    Box(modifier = modifier) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TitleText(text = stringResource(R.string.reg_title))

            Spacer(Modifier.height(24.dp))

            TitleInputField(
                titleText = stringResource(R.string.auth_username_title),
                labelInputText = stringResource(R.string.auth_username_input),
                value = uiState.username,
                onValueChange = onUsernameChanged
            )

            Spacer(Modifier.height(24.dp))

            TitleInputField(
                titleText = stringResource(R.string.reg_password_title),
                labelInputText = stringResource(R.string.reg_password_input),
                value = uiState.password,
                onValueChange = onPasswordChanged
            )

            Spacer(Modifier.height(24.dp))

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.reg_birthday_input),
                color = Black,
                fontSize = 18.sp,
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.height(12.dp))

            BirthdayPicker(
                selectedDate = uiState.birthDate,
                onDateSelected = onBirthdayChanged
            )

            Spacer(Modifier.height(24.dp))

            TitleInputField(
                titleText = stringResource(R.string.reg_email_title),
                labelInputText = stringResource(R.string.reg_email_input),
                value = uiState.email,
                onValueChange = onEmailChanged
            )

            Spacer(Modifier.height(24.dp))

            PhoneInputField(
                value = uiState.phone,
                onPhoneChanged = onPhoneChanged
            )

            Spacer(Modifier.height(20.dp))

            Row() {
                Text(text = stringResource(R.string.reg_go_to_auth), modifier = Modifier.padding(4.dp), fontSize = 16.sp)

                ClickableText(
                    modifier = Modifier.padding(4.dp),
                    text = stringResource(R.string.auth_text_button)
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
                onClick = onSubmit,
                enabled = !uiState.isLoading
            )

        }
    }
}