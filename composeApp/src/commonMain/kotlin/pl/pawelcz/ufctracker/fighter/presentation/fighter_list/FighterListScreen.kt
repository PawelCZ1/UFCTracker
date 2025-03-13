package pl.pawelcz.ufctracker.fighter.presentation.fighter_list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI


@OptIn(KoinExperimentalAPI::class)
@Composable
fun FighterListScreenRoot(
    viewModel: FighterListViewModel = koinViewModel(),
    onFighterClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    FighterListScreen(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun FighterListScreen(
    state: FighterListState,
    onAction: (FighterListAction) -> Unit
) {

}
