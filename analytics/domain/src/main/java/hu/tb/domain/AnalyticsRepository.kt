package hu.tb.domain

interface AnalyticsRepository {

    suspend fun getAnalyticsValues(): AnalyticsValues
}