package com.panevrn.streamhub.ui.elements

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.panevrn.streamhub.ui.theme.BlackText
import com.panevrn.streamhub.ui.theme.Blue500

@Composable
fun ClickableText(modifier: Modifier = Modifier, text: String, onClick: () -> Unit) {

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed = interactionSource.collectIsPressedAsState()

    Text(
        text = text,
        modifier = modifier.clickable(interactionSource, indication = null) { onClick() },
        color = if (isPressed.value) Blue500 else BlackText,
        fontSize = 16.sp,
        textDecoration = TextDecoration.Underline
    )
}