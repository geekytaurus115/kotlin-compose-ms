package com.geekytaurus.rojems.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    primary = LightPrimary,
    onPrimary = LightOnPrimary,
    background = LightBackground,
    onBackground = LightOnBackground,
    surface = LightPrimary,
    onSurface = LightOnPrimary,
    secondary = LightButtonColor
)

private val DarkColors = darkColorScheme(
    primary = DarkPrimary,
    onPrimary = DarkOnPrimary,
    background = DarkBackground,
    onBackground = DarkOnBackground,
    surface = DarkPrimary,
    onSurface = DarkOnPrimary,
    secondary = DarkButtonColor
)

@Composable
fun RojeMSTheme(
    darkTheme: Boolean = isSystemInDarkTheme(), // Use system theme by default
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}
