package pl.pawelcz.ufctracker

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform