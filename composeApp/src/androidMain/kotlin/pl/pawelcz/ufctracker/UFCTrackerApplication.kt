package pl.pawelcz.ufctracker

import android.app.Application
import org.koin.android.ext.koin.androidContext
import pl.pawelcz.ufctracker.di.initKoin

class UFCTrackerApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@UFCTrackerApplication)
        }
    }
}