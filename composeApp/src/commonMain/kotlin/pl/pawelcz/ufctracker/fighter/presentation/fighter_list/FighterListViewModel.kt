package pl.pawelcz.ufctracker.fighter.presentation.fighter_list

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class FighterListViewModel : ViewModel() {
    private val _state = MutableStateFlow(FighterListState())
    val state = _state.asStateFlow()

    fun onAction(action: FighterListAction) {
        when (action) {
            is FighterListAction.OnFighterClick -> {

            }
            is FighterListAction.OnSearchQueryChange -> {

            }
            is FighterListAction.OnTabSelected -> {
                
            }
        }
    }
}