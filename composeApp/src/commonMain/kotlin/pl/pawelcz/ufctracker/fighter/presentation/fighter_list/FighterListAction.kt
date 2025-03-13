package pl.pawelcz.ufctracker.fighter.presentation.fighter_list

import pl.pawelcz.ufctracker.fighter.domain.Fighter

sealed interface FighterListAction {
    data class OnSearchQueryChange(val query: String): FighterListAction
    data class OnFighterClick(val fighter: Fighter): FighterListAction
    data class OnTabSelected(val index: Int): FighterListAction
}