package pl.pawelcz.ufctracker

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val colorPrimary = Color(0xFF0C090A)
private val colorSecondary = Color(0xFFC1121F)
private val colorSurface = Color(0xFFC1121F)
private val colorOnSurface = Color(0xFF0C090A)

//val materialThemeColors = ColorScheme(
//    primary = colorPrimary,
//    primaryVariant = colorPrimary,
//    secondary = colorSecondary,
//    secondaryVariant = colorPrimary,
//    background = colorPrimary,
//    surface = colorSurface,
//    error = colorPrimary,
//    onPrimary = colorSecondary,
//    onSecondary = colorPrimary,
//    onBackground = colorPrimary,
//    onSurface = colorPrimary,
//    onError = colorPrimary,
//    isLight = true
//)

private val LightColorScheme = lightColorScheme(
    primary = colorPrimary,
    onPrimary = colorSecondary,
    secondary = colorSecondary,
    onSecondary = colorPrimary,
    background = colorPrimary,
    surface = colorSurface,
    onSurface = colorOnSurface
)

private val DarkColorScheme = darkColorScheme(
    primary = colorPrimary,
    onPrimary = colorSecondary,
    secondary = colorSecondary,
    onSecondary = colorPrimary,
    background = colorPrimary,
    surface = colorSurface,
    onSurface = colorOnSurface
)

@Composable
fun UFCTrackerTheme(darkTheme: Boolean, content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        content = content
    )
}
