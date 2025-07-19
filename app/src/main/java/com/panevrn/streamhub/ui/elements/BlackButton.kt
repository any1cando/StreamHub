package com.panevrn.streamhub.ui.elements

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.panevrn.streamhub.ui.theme.BlackButton
import com.panevrn.streamhub.ui.theme.White


@Composable
fun BlackButton(
    modifier: Modifier = Modifier.fillMaxWidth().height(48.dp),
    textButton: String,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        onClick = onClick,  // TODO: Обработка клика
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = BlackButton,
            contentColor = White
        )
    ) {
        Text(text = textButton, fontSize = 18.sp)
    }

}