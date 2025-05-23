package pl.pawelcz.ufctracker.fighter.presentation.fighter_details

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import pl.pawelcz.ufctracker.fighter.domain.Fighter

class FighterDetailsViewModel : ViewModel() {
    private val _selectedFighter = MutableStateFlow<Fighter?>(null)
    val selectedFighter = _selectedFighter.asStateFlow()

    fun onSelectFighter(fighter: Fighter?) {
        _selectedFighter.value = fighter
    }

    fun onAction(action: FighterDetailsAction) {
        when (action) {
            is FighterDetailsAction.OnBackClick -> {
                _selectedFighter.value = null
            }
        }
    }
}