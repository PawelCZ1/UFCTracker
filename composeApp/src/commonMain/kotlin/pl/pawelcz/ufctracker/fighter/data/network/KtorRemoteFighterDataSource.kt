package pl.pawelcz.ufctracker.fighter.data.network

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import pl.pawelcz.ufctracker.core.data.safeCall
import pl.pawelcz.ufctracker.core.domain.DataError
import pl.pawelcz.ufctracker.core.domain.Result
import pl.pawelcz.ufctracker.fighter.data.dto.FighterDetailsDto

private const val BASE_URL = "https://api.octagon-api.com"

class KtorRemoteFighterDataSource(
    private val httpClient: HttpClient
): RemoteFighterDataSource {
    override suspend fun searchFighters(
        query: String,
        resultLimit: Int?
    ): Result<Map<String, FighterDetailsDto>, DataError.Remote> {
        return safeCall {
            httpClient.get(urlString = "$BASE_URL/fighters") {
                parameter("q", query)
                parameter("limit", resultLimit)
                parameter("fields", "key,name,nickname,category,placeOfBirth,age,height,weight,wins,losses,draws,imgUrl")
            }
        }

    }
}