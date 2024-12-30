package hu.tb.analytics.presentation

sealed interface AnalyticsAction {
    data object OnBackClick: AnalyticsAction
}