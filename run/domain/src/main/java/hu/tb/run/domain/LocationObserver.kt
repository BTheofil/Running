package hu.tb.run.domain

import hu.tb.core.domain.location.LocationWithAltitude
import kotlinx.coroutines.flow.Flow
import kotlin.time.Duration

interface LocationObserver {
    fun observeLocation(interval: Duration): Flow<LocationWithAltitude>
}