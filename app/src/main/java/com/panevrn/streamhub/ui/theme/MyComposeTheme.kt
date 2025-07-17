package com.panevrn.streamhub.ui.theme


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable


private val LightColors = lightColorScheme(
    primary = Blue500,
    onPrimary = White,
    background = White,
    onBackground = Black,
    // другие цвета при необходимости
)

private val DarkColors = darkColorScheme(
    primary = Blue200,
    onPrimary = Black,
    background = Black,
    onBackground = White,
)

@Composable
fun MyComposeTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (useDarkTheme) {
        DarkColors
    }
    else {
        LightColors
    }

    MaterialTheme(
        colorScheme = colors,
        typography = AppTypography,
        shapes = AppShapes,
        content = content
    )
}
