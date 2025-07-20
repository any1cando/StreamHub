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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.panevrn.streamhub.R
import com.panevrn.streamhub.ui.theme.Black
import com.panevrn.streamhub.ui.theme.BlackButton
import com.panevrn.streamhub.ui.theme.BlackText
import com.panevrn.streamhub.ui.theme.RedError


@Composable
fun PhoneInputField(modifier: Modifier = Modifier) {

    var phoneNumber by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

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
            value = phoneNumber,
            onValueChange = { inputValue ->
                val digitsOnly = inputValue.filter { it.isDigit() }
                // Проверка: если есть нецифровые символы
                isError = inputValue.any { !it.isDigit() }

                errorMessage = when {
                    digitsOnly.isEmpty() -> "Поле не может быть пустым"
                    digitsOnly.length > 11 -> "Номер не может быть больше 11 цифр"
                    else -> null
                }
                phoneNumber = digitsOnly.take(11)
            },
            isError = errorMessage != null,
            label = { Text("Номер телефона") },
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
        if (!errorMessage.isNullOrBlank()) {
            Text(
                text = errorMessage!!,
                color = RedError,
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth()
            )
        }
    }
}

