package hu.tb.run.data.di

import hu.tb.run.data.CreateRunWorker
import hu.tb.run.data.DeleteRunsWorker
import hu.tb.run.data.FetchRunsWorker
import org.koin.androidx.workmanager.dsl.workerOf
import org.koin.dsl.module

val runDataModule = module {
    workerOf(::CreateRunWorker)
    workerOf(::FetchRunsWorker)
    workerOf(::DeleteRunsWorker)
}