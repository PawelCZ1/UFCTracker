package pl.pawelcz.ufctracker.fighter.data.repository

import pl.pawelcz.ufctracker.core.domain.DataError
import pl.pawelcz.ufctracker.core.domain.Result
import pl.pawelcz.ufctracker.core.domain.map
import pl.pawelcz.ufctracker.fighter.data.mappers.toFighterList
import pl.pawelcz.ufctracker.fighter.data.network.RemoteFighterDataSource
import pl.pawelcz.ufctracker.fighter.domain.Fighter
import pl.pawelcz.ufctracker.fighter.domain.FighterRepository

class DefaultFighterRepository(
    private val remoteFighterDataSource: RemoteFighterDataSource
): FighterRepository {
    override suspend fun searchFighters(query: String): Result<List<Fighter>, DataError.Remote> {
        return remoteFighterDataSource
            .searchFighters()
            .map { results ->
                results.toFighterList()
            }
    }
}