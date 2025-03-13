package pl.pawelcz.ufctracker

import androidx.compose.ui.window.ComposeUIViewController
import pl.pawelcz.ufctracker.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }