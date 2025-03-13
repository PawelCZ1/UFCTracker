package pl.pawelcz.ufctracker.fighter.domain

data class Fighter(
    val id: String,
    val firstName: String,
    val lastName: String,
    val category: String,
    val placeOfBirth: String,
    val age: Int,
    val height: Double,
    val weight: Double,
    val wins: Int,
    val losses: Int,
    val draws: Int
)