package pl.pawelcz.ufctracker.fighter.data.network

import pl.pawelcz.ufctracker.core.domain.DataError
import pl.pawelcz.ufctracker.core.domain.Result
import pl.pawelcz.ufctracker.fighter.data.dto.FighterDetailsDto

interface RemoteFighterDataSource {
    suspend fun searchFighters(
        resultLimit: Int? = null
    ): Result<Map<String, FighterDetailsDto>, DataError.Remote>
}