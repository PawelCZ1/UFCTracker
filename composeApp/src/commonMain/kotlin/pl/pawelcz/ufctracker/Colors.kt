package pl.pawelcz.ufctracker

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.graphics.Color

private val colorPrimary = Color(0xFFC1121F)
private val colorSecondary = Color.White

val materialThemeColors = Colors(
    primary = colorPrimary,
    primaryVariant = colorPrimary,
    secondary = colorSecondary,
    secondaryVariant = colorPrimary,
    background = colorPrimary,
    surface = colorPrimary,
    error = colorPrimary,
    onPrimary = colorSecondary,
    onSecondary = colorPrimary,
    onBackground = colorPrimary,
    onSurface = colorPrimary,
    onError = colorPrimary,
    isLight = true
)