package id.shaderboi.instagramui.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = Color(red = 38, green = 38, blue = 38),
    primaryVariant = Purple700,
    secondary = Teal200,
    background = Color.Black,
    onBackground = Color.White
)

private val LightColorPalette = lightColors(
    primary = Color.White,
    onPrimary = Color(0.149F, 0.149F, 0.149F),
    background = Color.White
)

@Composable
fun InstagramUITheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val systemUiController = rememberSystemUiController()
    val colors = if (isDarkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = colors.background
        )
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}