package hu.tb.analytics.data

import hu.tb.core.database.dao.AnalyticsDao
import hu.tb.domain.AnalyticsRepository
import hu.tb.domain.AnalyticsValues
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import kotlin.time.Duration.Companion.milliseconds

class RoomAnalyticsRepository(
    private val analyticsDao: AnalyticsDao
): AnalyticsRepository {

    override suspend fun getAnalyticsValues(): AnalyticsValues {
        return withContext(Dispatchers.IO){
            val totalDistance = async { analyticsDao.getTotalDistance() }
            val totalTimeMillis = async { analyticsDao.getTotalTimeRun() }
            val maxRunSpeed = async { analyticsDao.getMaxRunSpeed() }
            val avgDistance = async { analyticsDao.getAvgDistancePerRun() }
            val avgPace = async { analyticsDao.getAvgPacePerRun() }

            AnalyticsValues(
                totalDistanceRun = totalDistance.await(),
                totalTimeRun = totalTimeMillis.await().milliseconds,
                fastestEverRun = maxRunSpeed.await(),
                avgDistance = avgDistance.await(),
                avgPace = avgPace.await()
            )
        }
    }
}