package pl.pawelcz.ufctracker.di

import org.koin.core.context.startKoin

typealias KoinAppDeclaration = org.koin.core.KoinApplication.() -> Unit

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(sharedModule, platformModule)
    }
}