package hu.tb.run.data.di

import hu.tb.core.domain.run.SyncRunScheduler
import hu.tb.run.data.CreateRunWorker
import hu.tb.run.data.DeleteRunWorker
import hu.tb.run.data.FetchRunsWorker
import hu.tb.run.data.SyncRunWorkerScheduler
import org.koin.androidx.workmanager.dsl.workerOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val runDataModule = module {
    workerOf(::CreateRunWorker)
    workerOf(::FetchRunsWorker)
    workerOf(::DeleteRunWorker)

    singleOf(::SyncRunWorkerScheduler).bind<SyncRunScheduler>()
}