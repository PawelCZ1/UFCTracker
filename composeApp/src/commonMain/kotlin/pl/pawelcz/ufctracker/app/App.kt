package pl.pawelcz.ufctracker.app

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import pl.pawelcz.ufctracker.core.presentation.UFCTrackerTheme
import pl.pawelcz.ufctracker.fighter.presentation.fighter_list.FighterListScreenRoot
import pl.pawelcz.ufctracker.fighter.presentation.fighter_list.FighterListViewModel
import pl.pawelcz.ufctracker.fighter.presentation.fighter_details.FighterDetailsScreenRoot
import pl.pawelcz.ufctracker.fighter.presentation.fighter_details.FighterDetailsViewModel


@OptIn(KoinExperimentalAPI::class)
@Composable
@Preview
fun App() {
    UFCTrackerTheme(true) {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Route.FighterList.route
        ) {

            composable(Route.FighterList.route) {
                val viewModel: FighterListViewModel = koinViewModel()
                val fighterDetailsViewModel =
                    it.sharedKoinViewModel<FighterDetailsViewModel>(navController)


                FighterListScreenRoot(
                    viewModel = viewModel,
                    onFighterClick = { fighter ->
                        fighterDetailsViewModel.onSelectFighter(fighter)
                        navController.navigate(Route.FighterDetails.route)
                    }
                )
            }
            composable(Route.FighterDetails.route) {
                val fighterDetailsViewModel =
                    it.sharedKoinViewModel<FighterDetailsViewModel>(navController)
                FighterDetailsScreenRoot(
                    viewModel = fighterDetailsViewModel,
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}

@OptIn(KoinExperimentalAPI::class)
@Composable
private inline fun <reified T: ViewModel> NavBackStackEntry.sharedKoinViewModel(
    navController: NavController
): T {
    val parentEntry = remember {
        navController.getBackStackEntry(navController.graph.route ?: Route.FighterList.route)
    }
    return koinViewModel(viewModelStoreOwner = parentEntry)
}
