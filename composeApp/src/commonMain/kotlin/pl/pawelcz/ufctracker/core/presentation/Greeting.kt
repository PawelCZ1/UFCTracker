package pl.pawelcz.ufctracker.core.presentation

import pl.pawelcz.ufctracker.getPlatform

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}