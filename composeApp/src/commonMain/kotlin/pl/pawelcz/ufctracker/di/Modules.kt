package pl.pawelcz.ufctracker.di


import io.ktor.client.HttpClient
import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import pl.pawelcz.ufctracker.core.data.HttpClientFactory
import pl.pawelcz.ufctracker.fighter.data.network.KtorRemoteFighterDataSource
import pl.pawelcz.ufctracker.fighter.data.network.RemoteFighterDataSource
import pl.pawelcz.ufctracker.fighter.data.repository.DefaultFighterRepository
import pl.pawelcz.ufctracker.fighter.domain.FighterRepository
import pl.pawelcz.ufctracker.fighter.presentation.fighter_list.FighterListViewModel
import pl.pawelcz.ufctracker.fighter.presentation.fighter_details.FighterDetailsViewModel

expect val platformModule: Module

val sharedModule = module {

}

val fighterModule = module {
    single<HttpClient> { HttpClientFactory.create(get()) }
    single<RemoteFighterDataSource> { KtorRemoteFighterDataSource(httpClient = get()) }
    single<FighterRepository> { DefaultFighterRepository(remoteFighterDataSource = get()) }
    viewModel { FighterListViewModel(fighterRepository = get()) }
    viewModel { FighterDetailsViewModel() }
}




