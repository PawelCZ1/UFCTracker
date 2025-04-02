package pl.pawelcz.ufctracker.fighter.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class SearchedFightersDto(
    val fighters: Map<String, FighterDetailsDto>
)