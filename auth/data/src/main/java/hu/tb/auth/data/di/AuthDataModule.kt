package hu.tb.auth.data.di

import hu.tb.auth.data.AuthRepositoryImpl
import hu.tb.auth.data.EmailPatternValidator
import hu.tb.auth.domain.AuthRepository
import hu.tb.auth.domain.PatternValidator
import hu.tb.auth.domain.UserDataValidator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val authDataModule = module {
    single<PatternValidator> {
        EmailPatternValidator
    }

    singleOf(::UserDataValidator)
    singleOf(::AuthRepositoryImpl).bind<AuthRepository>()
}