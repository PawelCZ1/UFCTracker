package pl.pawelcz.ufctracker

import android.app.Application
import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.binds
import org.koin.dsl.module
import pl.pawelcz.ufctracker.di.initKoin

class UFCTrackerApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            module {
                single { this@UFCTrackerApplication } binds arrayOf(Context::class, Application::class)
            }
            //androidContext(this@UFCTrackerApplication)
        }
    }
}