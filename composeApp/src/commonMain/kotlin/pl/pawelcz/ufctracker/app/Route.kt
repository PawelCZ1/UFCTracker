package pl.pawelcz.ufctracker.app

import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer

sealed interface Route {

    @Serializable
    data object FighterList : Route

    @Serializable
    data object FighterDetails : Route

}