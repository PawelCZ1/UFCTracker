package pl.pawelcz.ufctracker.fighter.presentation.fighter_details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.IconButton
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.compose.viewmodel.koinViewModel
import pl.pawelcz.ufctracker.fighter.domain.Fighter
import pl.pawelcz.ufctracker.fighter.presentation.fighter_details.components.FighterDetailsBioSection
import pl.pawelcz.ufctracker.fighter.presentation.fighter_details.components.FighterDetailsFighterProfileSection
import pl.pawelcz.ufctracker.fighter.presentation.fighter_details.components.FighterDetailsHeader

@Composable
fun FighterDetailsScreenRoot(
    viewModel: FighterDetailsViewModel = koinViewModel(),
    onBackClick: () -> Unit
) {
    val selectedFighter = viewModel.selectedFighter.collectAsStateWithLifecycle()
    FighterDetailsScreen(
        fighter = selectedFighter.value,
        onAction = { action ->
            when (action) {
                is FighterDetailsAction.OnBackClick -> onBackClick()
                else -> Unit
            }
            viewModel.onAction(action)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FighterDetailsScreen(
    fighter: Fighter?,
    onAction: (FighterDetailsAction) -> Unit
) {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())
    val listState = rememberLazyListState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Fighter Details") },
                navigationIcon = {
                    IconButton(onClick = { onAction(FighterDetailsAction.OnBackClick) }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarColors(
                    containerColor = Color.Black.copy(alpha = 0.5f),
                    scrolledContainerColor = MaterialTheme.colorScheme.background,
                    navigationIconContentColor = Color.White,
                    titleContentColor = Color.White,
                    actionIconContentColor = Color.White
                ),
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            LazyColumn(
                state = listState,
                modifier = Modifier
                    .nestedScroll(scrollBehavior.nestedScrollConnection)
            ) {
                item {
                    FighterDetailsHeader(fighter)
                }
                item {
                    FighterDetailsBioSection(fighter)
                }
                item {
                    FighterDetailsFighterProfileSection(fighter)
                }
            }
        }
    }
}