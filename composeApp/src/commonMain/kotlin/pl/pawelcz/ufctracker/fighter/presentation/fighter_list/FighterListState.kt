package pl.pawelcz.ufctracker.fighter.presentation.fighter_list

import pl.pawelcz.ufctracker.core.presentation.UiText
import pl.pawelcz.ufctracker.fighter.domain.Fighter

data class FighterListState(
    val searchQuery: String = "",
    val fighters: List<Fighter> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: UiText? = null,
    val selectedTabIndex: Int = 0
)
