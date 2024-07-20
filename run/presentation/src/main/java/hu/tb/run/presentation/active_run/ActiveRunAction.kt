package hu.tb.run.presentation.active_run

sealed interface ActiveRunAction {
    data object OnToggleRunClick: ActiveRunAction
    data object OnFinishRunClick: ActiveRunAction
    data object OnResumeClick: ActiveRunAction
    data object OnBackClick: ActiveRunAction
}