package pl.pawelcz.ufctracker.app

import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer

sealed interface Route {
    val route: String
    @Serializable
    data object FighterList : Route {
        override val route = "fighter_list"
    }

    @Serializable
    data object FighterDetails : Route {
        override val route = "fighter_details"
    }

}