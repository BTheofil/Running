package hu.tb.running

import android.app.Application
import hu.tb.auth.data.di.authDataModule
import hu.tb.auth.presentation.di.authViewModelModule
import hu.tb.core.data.di.coreDataModule
import hu.tb.core.database.di.databaseModule
import hu.tb.run.data.di.runDataModule
import hu.tb.run.location.di.locationModule
import hu.tb.run.network.di.networkModule
import hu.tb.run.presentation.di.runPresentationModule
import hu.tb.running.di.appModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.workmanager.koin.workManagerFactory
import org.koin.core.context.startKoin
import timber.log.Timber

class RunningApp : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@RunningApp)
            workManagerFactory()
            modules(
                appModule,
                authDataModule,
                authViewModelModule,
                coreDataModule,
                runPresentationModule,
                locationModule,
                databaseModule,
                networkModule,
                runDataModule
            )
        }
    }
}