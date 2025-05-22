package pl.pawelcz.ufctracker.fighter.presentation.selected_fighter

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import pl.pawelcz.ufctracker.fighter.domain.Fighter

class SelectedFighterViewModel : ViewModel() {
    private val _selectedFighter = MutableStateFlow<Fighter?>(null)
    val selectedFighter = _selectedFighter.asStateFlow()

    fun onSelectFighter(fighter: Fighter?) {
        _selectedFighter.value = fighter
    }
}