package pl.pawelcz.ufctracker.fighter.presentation.fighter_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pl.pawelcz.ufctracker.core.domain.onError
import pl.pawelcz.ufctracker.core.domain.onSuccess
import pl.pawelcz.ufctracker.core.presentation.toUiText
import pl.pawelcz.ufctracker.fighter.domain.Fighter
import pl.pawelcz.ufctracker.fighter.domain.FighterRepository

class FighterListViewModel(
    private val fighterRepository: FighterRepository
) : ViewModel() {

    private var cachedFighters = emptyList<Fighter>()

    private val _state = MutableStateFlow(FighterListState())
    val state = _state.asStateFlow()

    init {
        fetchAllFighters()
    }

    fun onAction(action: FighterListAction) {
        when (action) {
            is FighterListAction.OnFighterClick -> { }
            is FighterListAction.OnSearchQueryChange -> {
                _state.update {
                    it.copy(searchQuery = action.query)
                }
                filterAndUpdateFighters(action.query)
            }
            is FighterListAction.OnTabSelected -> {
                _state.update {
                    it.copy(selectedTabIndex = action.index)
                }
            }
            is FighterListAction.OnReloadClick -> {
                fetchAllFighters()
            }
        }
    }

    private fun fetchAllFighters() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            fighterRepository
                .searchFighters("")
                .onSuccess { fighters ->
                    cachedFighters = fighters
                    _state.update {
                        it.copy(
                            isLoading = false,
                            fighters = fighters,
                            errorMessage = null
                        )
                    }
                }
                .onError { error ->
                    _state.update {
                        it.copy(
                            isLoading = false,
                            errorMessage = error.toUiText()
                        )
                    }
                }
        }
    }

    private fun filterAndUpdateFighters(query: String) {
        val filtered = if (query.isBlank()) {
            cachedFighters
        } else {
            filterFightersLocally(query)
        }
        _state.update {
            it.copy(
                fighters = filtered,
                errorMessage = null
            )
        }
    }

    private fun filterFightersLocally(query: String): List<Fighter> {
        val q = query.trim().lowercase()
        return cachedFighters.filter { fighter ->
            (fighter.firstName.lowercase() + " " + fighter.lastName.lowercase()).contains(q) || fighter.nickname.lowercase().contains(q)
        }
    }
}