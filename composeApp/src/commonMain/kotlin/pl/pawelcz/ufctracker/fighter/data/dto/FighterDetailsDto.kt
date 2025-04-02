package pl.pawelcz.ufctracker.fighter.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FighterDetailsDto(
    val name: String,
    val nickname: String,
    val category: String,
    val placeOfBirth: String? = null,
    val age: Int,
    val height: Double,
    val weight: Double,
    val wins: Int,
    val losses: Int,
    val draws: Int,
    @SerialName("imgUrl") val imageUrl: String
)