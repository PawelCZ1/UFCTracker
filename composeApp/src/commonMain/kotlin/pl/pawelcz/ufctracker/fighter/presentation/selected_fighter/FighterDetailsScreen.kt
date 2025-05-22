package pl.pawelcz.ufctracker.fighter.presentation.selected_fighter

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.compose.viewmodel.koinViewModel
import pl.pawelcz.ufctracker.fighter.domain.Fighter
import pl.pawelcz.ufctracker.fighter.presentation.selected_fighter.components.FighterDetailsHeader

@Composable
fun FighterDetailsScreenRoot(viewModel: SelectedFighterViewModel = koinViewModel()) {
    val selectedFighter = viewModel.selectedFighter.collectAsStateWithLifecycle()

    FighterDetailsScreen(
        fighter = selectedFighter.value
    )
}

@Composable
fun FighterDetailsScreen(fighter: Fighter?) {
    LazyColumn {
        item {
            FighterDetailsHeader(fighter)
        }
    }
}