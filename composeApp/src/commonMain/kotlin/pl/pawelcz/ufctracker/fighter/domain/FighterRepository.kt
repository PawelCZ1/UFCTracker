package pl.pawelcz.ufctracker.fighter.domain

import pl.pawelcz.ufctracker.core.domain.DataError
import pl.pawelcz.ufctracker.core.domain.Result

interface FighterRepository {
    suspend fun searchFighters(query: String): Result<List<Fighter>, DataError.Remote>
}