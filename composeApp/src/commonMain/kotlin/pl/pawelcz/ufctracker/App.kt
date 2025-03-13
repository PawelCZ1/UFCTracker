package pl.pawelcz.ufctracker

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App() {
    UFCTrackerTheme(true) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
        ) {
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = Modifier.height(48.dp))
                Text(
                    text = "UFC",
                    style = MaterialTheme.typography.h1,
                    color = MaterialTheme.colors.secondary,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }
    }
}

@Composable
fun UFCTrackerTheme(darkTheme: Boolean, content: @Composable () -> Unit) {
    MaterialTheme(
        colors = materialThemeColors,
        content = content
    )
}
