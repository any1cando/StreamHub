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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
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


@Composable
fun MainRegistrationScreen(modifier: Modifier = Modifier) {

    var usernameReg by remember { mutableStateOf("") }
    var passwordReg by remember { mutableStateOf("") }
    var emailReg by remember { mutableStateOf("") }

    var birthDate by remember { mutableStateOf<LocalDate?>(null) }

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
                value = usernameReg,
                onValueChange = {}
            )

            Spacer(Modifier.height(24.dp))

            TitleInputField(
                titleText = stringResource(R.string.reg_password_title),
                labelInputText = stringResource(R.string.reg_password_input),
                value = passwordReg,
                onValueChange = {}
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
                selectedDate = birthDate,
                onDateSelected = { birthDate = it }
            )

            Spacer(Modifier.height(24.dp))

            TitleInputField(
                titleText = stringResource(R.string.reg_email_title),
                labelInputText = stringResource(R.string.reg_email_input),
                value = emailReg,
                onValueChange = {}
            )

            Spacer(Modifier.height(24.dp))

            PhoneInputField()

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
                onClick = {
//                    usernameErrorAuth = usernameAuth.isBlank()
//                    passwordErrorAuth = passwordAuth.length < 6
//
//                    if (!usernameErrorAuth && !passwordErrorAuth) {
//                        // TODO: Доделать успешный вход
//                    }
                }
            )

        }
    }
}