package pl.pawelcz.ufctracker

import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview
import pl.pawelcz.ufctracker.fighter.presentation.fighter_list.FighterListScreenRoot
import pl.pawelcz.ufctracker.fighter.presentation.fighter_list.FighterListViewModel


@Composable
@Preview
fun App() {
    UFCTrackerTheme(true) {
        //val navController = rememberNavController()
        MainScreen()
//        FighterListScreenRoot(
//            viewModel = remember { FighterListViewModel() },
//            onFighterClick = {}
//        )
    }
}
