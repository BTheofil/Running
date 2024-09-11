package hu.tb.core.data.di

import hu.tb.core.data.auth.EncryptedSessionStorage
import hu.tb.core.data.network.HttpClientFactory
import hu.tb.core.data.run.OfflineFirstRunRepository
import hu.tb.core.domain.SessionStorage
import hu.tb.core.domain.run.RunRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreDataModule = module {
    single {
        HttpClientFactory(get()).build()
    }
    singleOf(::EncryptedSessionStorage).bind<SessionStorage>()

    singleOf(::OfflineFirstRunRepository).bind<RunRepository>()
}