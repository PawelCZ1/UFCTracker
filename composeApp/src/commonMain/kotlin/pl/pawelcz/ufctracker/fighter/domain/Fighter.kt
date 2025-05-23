package pl.pawelcz.ufctracker.fighter.domain

data class Fighter(
    val id: String,
    val firstName: String,
    val lastName: String,
    val nickname: String,
    val category: String,
    val placeOfBirth: String? = null,
    val age: Int,
    val height: Double,
    val weight: Double,
    val wins: Int,
    val losses: Int,
    val draws: Int,
    val imageUrl: String,
    val trainsAt: String? = null,
    val fightingStyle: String? = null,
    val octagonDebut: String,
    val status: String? = null
)