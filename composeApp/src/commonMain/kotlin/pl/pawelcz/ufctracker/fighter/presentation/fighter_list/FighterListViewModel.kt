@file:OptIn(FlowPreview::class)

package pl.pawelcz.ufctracker.fighter.presentation.fighter_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
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
    private var searchJob: Job? = null

    private val _state = MutableStateFlow(FighterListState())
    val state = _state
        .onStart {
            if (cachedFighters.isEmpty()) {
                observeSearchQuery()
            }
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            _state.value
        )

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

    private fun observeSearchQuery() {
        state
            .map { it.searchQuery }
            .distinctUntilChanged()
            .debounce(500L)
            .onEach { query ->
                searchJob?.cancel()
                searchJob = searchFighters(query)
                when {
                    query.isBlank() -> {
                        _state.update {
                            it.copy(
                                errorMessage = null,
                                fighters = cachedFighters
                            )
                        }
                    }
                }
            }
            .launchIn(viewModelScope)
    }

    private fun searchFighters(query: String) = viewModelScope.launch {
        _state.update {
            it.copy(isLoading = true)
        }
        fighterRepository
            .searchFighters(query)
            .onSuccess { fighters ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = null,
                        fighters = fighters
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