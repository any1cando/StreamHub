package com.panevrn.streamhub.ui.elements

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.panevrn.streamhub.ui.theme.Black
import com.panevrn.streamhub.ui.theme.MyComposeTheme

@Composable
fun TitleText(text: String, modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = text,
        color = Black,
        fontSize = 28.sp,
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Center
    )
}