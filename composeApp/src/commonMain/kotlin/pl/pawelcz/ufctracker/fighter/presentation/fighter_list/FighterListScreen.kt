package pl.pawelcz.ufctracker.fighter.presentation.fighter_list

import androidx.compose.runtime.Composable
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun FighterListScreen(
    viewModel: FighterListViewModel = koinViewModel(),
    onFighterClick: (Fighter) -> Unit
)
