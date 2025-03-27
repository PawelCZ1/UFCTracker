package pl.pawelcz.ufctracker.app

import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview
import pl.pawelcz.ufctracker.MainScreen
import pl.pawelcz.ufctracker.UFCTrackerTheme


@Composable
@Preview
fun App() {
    UFCTrackerTheme(true) {
        val navController = rememberNavController()
//        NavHost(
//            navController = navController,
//            startDestination = "main"
//        )
        MainScreen()
//        FighterListScreenRoot(
//            viewModel = remember { FighterListViewModel() },
//            onFighterClick = {}
//        )
    }
}
