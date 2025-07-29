package com.panevrn.streamhub.ui.elements

import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.panevrn.streamhub.ui.theme.Black
import com.panevrn.streamhub.ui.theme.BlackButton
import com.panevrn.streamhub.ui.theme.BlackText
import com.panevrn.streamhub.ui.theme.RedError


@Composable
fun PhoneInputField(
    modifier: Modifier = Modifier,
    value: String,
    onPhoneChanged: (String) -> Unit,
    isError: Boolean = false,
    errorText: String = "Ошибка"){

    Column(modifier = modifier) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Введите номер телефона пользователя",
            color = Black,
            fontSize = 18.sp,
            textAlign = TextAlign.Start
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = value,
            onValueChange = onPhoneChanged,
            label = { Text("Номер телефона") },
            isError = isError,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = Modifier
                .fillMaxWidth()
                .focusable(true),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Black,
                focusedBorderColor = BlackButton,
                focusedLabelColor = BlackText
            ),
            shape = RoundedCornerShape(8.dp)
        )
        if (isError && errorText != null) {
            Text(modifier = Modifier.padding(top = 8.dp), text = errorText, color = RedError, fontSize = 14.sp)
        }
    }
}

