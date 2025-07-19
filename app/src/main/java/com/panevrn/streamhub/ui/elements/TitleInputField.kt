package com.panevrn.streamhub.ui.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.panevrn.streamhub.ui.theme.Black
import com.panevrn.streamhub.ui.theme.BlackButton
import com.panevrn.streamhub.ui.theme.BlackText
import com.panevrn.streamhub.ui.theme.RedError

@Composable
fun TitleInputField(
    modifier: Modifier = Modifier,
    titleText: String,
    labelInputText: String,
    value: String,
    onValueChange: (String) -> Unit,
    isError: Boolean = false,
    errorText: String? = "Ошибка"
) {

    Column(modifier = modifier) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = titleText,
            color = Black,
            fontSize = 18.sp,
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            shape = RoundedCornerShape(8.dp),
            label = { Text(text = labelInputText, fontSize = 14.sp) },
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Black,
                focusedBorderColor = BlackButton,
                focusedLabelColor = BlackText
            ),
            isError = isError
        )
        if (isError && errorText != null) {
            Text(modifier = Modifier.padding(top = 8.dp), text = errorText, color = RedError, fontSize = 14.sp)
        }

    }
}