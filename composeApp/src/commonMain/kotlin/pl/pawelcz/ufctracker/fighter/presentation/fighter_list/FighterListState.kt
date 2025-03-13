package pl.pawelcz.ufctracker.fighter.presentation.fighter_list

import pl.pawelcz.ufctracker.fighter.domain.Fighter

data class FighterListState(
    val searchQuery: String = "",
    val fighters: List<Fighter> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val selectedTabIndex: Int = 0
)
