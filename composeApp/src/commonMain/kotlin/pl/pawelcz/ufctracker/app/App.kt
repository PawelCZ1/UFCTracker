package pl.pawelcz.ufctracker.app

import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import io.ktor.client.engine.HttpClientEngine
import org.jetbrains.compose.ui.tooling.preview.Preview
import pl.pawelcz.ufctracker.core.data.HttpClientFactory
import pl.pawelcz.ufctracker.core.presentation.MainScreen
import pl.pawelcz.ufctracker.core.presentation.UFCTrackerTheme
import pl.pawelcz.ufctracker.fighter.data.network.KtorRemoteFighterDataSource
import pl.pawelcz.ufctracker.fighter.data.repository.DefaultFighterRepository
import pl.pawelcz.ufctracker.fighter.presentation.fighter_list.FighterListScreenRoot
import pl.pawelcz.ufctracker.fighter.presentation.fighter_list.FighterListViewModel


@Composable
@Preview
fun App(engine: HttpClientEngine) {
    UFCTrackerTheme(true) {
        val navController = rememberNavController()
//        NavHost(
//            navController = navController,
//            startDestination = "main"
//        )
//        MainScreen()
        FighterListScreenRoot(
            viewModel = remember { FighterListViewModel(
                fighterRepository = DefaultFighterRepository(
                    remoteFighterDataSource = KtorRemoteFighterDataSource(
                        httpClient = HttpClientFactory.create(
                            engine
                        )
                    )
                )
            ) },
            onFighterClick = {}
        )
    }
}
