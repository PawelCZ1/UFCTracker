package pl.pawelcz.ufctracker.fighter.presentation.fighter_list

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FighterListViewModel : ViewModel() {
    private val _state = MutableStateFlow(FighterListState())
    val state = _state.asStateFlow()

    fun onAction(action: FighterListAction) {
        when (action) {
            is FighterListAction.OnFighterClick -> {

            }
            is FighterListAction.OnSearchQueryChange -> {
                _state.update {
                    it.copy(searchQuery = action.query)
                }
            }
            is FighterListAction.OnTabSelected -> {
                _state.update {
                    it.copy(selectedTabIndex = action.index)
                }
            }
        }
    }
}