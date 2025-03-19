package pl.pawelcz.ufctracker.fighter.presentation.fighter_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import pl.pawelcz.ufctracker.fighter.presentation.fighter_list.components.FighterSearchBar


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
        onAction = { action ->
            when (action) {
                is FighterListAction.OnFighterClick -> onFighterClick()
                else -> Unit
            }
            viewModel.onAction(action)
        }
    )
}

@Composable
fun FighterListScreen(
    state: FighterListState,
    onAction: (FighterListAction) -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FighterSearchBar(
            searchQuery = state.searchQuery,
            onSearchQueryChange = {
                onAction(FighterListAction.OnSearchQueryChange(it))
            },
            onImeSearch = {
                keyboardController?.hide()
            },
            modifier = Modifier
                .widthIn(max = 400.dp)
                .fillMaxWidth()
                .padding(16.dp)
        )
    }
}
