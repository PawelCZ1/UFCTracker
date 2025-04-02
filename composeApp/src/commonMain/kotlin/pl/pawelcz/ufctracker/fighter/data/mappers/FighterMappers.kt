package pl.pawelcz.ufctracker.fighter.data.mappers

import pl.pawelcz.ufctracker.fighter.data.dto.FighterDetailsDto
import pl.pawelcz.ufctracker.fighter.domain.Fighter

fun Map<String, FighterDetailsDto>.toFighterList(): List<Fighter> {
    return this.map { (id, details) ->
        Fighter(
            id = id,
            firstName = details.name.split(" ")[0],
            lastName = details.name.split(" ")[1],
            nickname = details.nickname,
            category = details.category,
            placeOfBirth = details.placeOfBirth,
            age = details.age,
            height = details.height,
            weight = details.weight,
            wins = details.wins,
            losses = details.losses,
            draws = details.draws,
            imageUrl = details.imageUrl
        )
    }
}