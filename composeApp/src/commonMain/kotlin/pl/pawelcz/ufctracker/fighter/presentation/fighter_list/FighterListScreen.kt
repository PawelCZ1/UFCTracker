package pl.pawelcz.ufctracker.fighter.presentation.fighter_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import pl.pawelcz.ufctracker.fighter.presentation.fighter_list.components.FighterList
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

    val lazyListState = rememberLazyListState()

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
        Surface(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            color = Color.White,
            shape = RoundedCornerShape(
                topStart = 32.dp,
                topEnd = 32.dp
            )
        ) {
            if (state.isLoading) {
                CircularProgressIndicator()
            } else {
                when {
                    state.error != null -> {
                        Text(
                            state.error,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.headlineSmall,
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                    state.fighters.isEmpty() -> {
                        Text(
                            "No fighters found",
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.headlineSmall,
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                    else -> {
                        FighterList(
                            fighters = state.fighters,
                            onFighterClick = {
                                onAction(FighterListAction.OnFighterClick(it))
                            },
                            scrollState = lazyListState
                        )
                    }
                }
            }
//            Column(
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
////                TabRow(
////                    selectedTabIndex = state.selectedTabIndex,
////                    modifier = Modifier
////                        .padding(vertical = 12.dp)
////                        .widthIn(max = 700.dp)
////                        .fillMaxWidth()
////                ) {
////                    Tab(
////                        selected = state.selectedTabIndex == 0,
////                        onClick = {
////                            onAction(FighterListAction.OnTabSelected(0))
////                        },
////                        modifier = Modifier.weight(1f),
////                        selectedContentColor = MaterialTheme.colorScheme.primary,
////                    ) {
////                        Text("Light weight")
////                    }
////                }
//
//            }
        }
    }
}
