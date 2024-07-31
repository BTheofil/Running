package hu.tb.run.presentation.di

import hu.tb.run.domain.RunningTracker
import hu.tb.run.presentation.active_run.ActiveRunViewModel
import hu.tb.run.presentation.run_overview.RunOverviewViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val runPresentationModule = module {
    singleOf(::RunningTracker)

    viewModelOf(::RunOverviewViewModel)
    viewModelOf(::ActiveRunViewModel)
}