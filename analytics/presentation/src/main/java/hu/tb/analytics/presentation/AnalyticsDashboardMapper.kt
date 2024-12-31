package hu.tb.analytics.presentation

import hu.tb.core.presentation.ui.formatted
import hu.tb.core.presentation.ui.toFormattedKm
import hu.tb.core.presentation.ui.toFormattedKmh
import hu.tb.domain.AnalyticsValues
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds
import kotlin.time.DurationUnit

fun AnalyticsValues.toAnalyticsDashboardState(): AnalyticsDashboardState {
    return AnalyticsDashboardState(
        totalDistanceRun = (totalDistanceRun / 1000.0).toFormattedKm(),
        totalTimeRun = totalTimeRun.toFormattedTotalTime(),
        fastestEverRun = fastestEverRun.toFormattedKmh(),
        avgDistance = (avgDistance / 1000.0).toFormattedKm(),
        avgPace = avgPace.seconds.formatted()
    )
}

fun Duration.toFormattedTotalTime(): String {
    val days = toLong(DurationUnit.DAYS)
    val hours = toLong(DurationUnit.HOURS) % 24
    val minutes = toLong(DurationUnit.MINUTES) % 60

    return "${days}d ${hours}h ${minutes}m"
}