package hu.tb.run.domain

import hu.tb.core.domain.location.LocationTimestamp
import kotlin.math.roundToInt

object LocationDataCalculator {

    fun getTotalDistanceMeters(locations: List<List<LocationTimestamp>>): Int {
        return locations
            .sumOf { timestampsPerLine ->
                timestampsPerLine.zipWithNext { location1, locations2 ->
                    location1.location.location.distanceTo(locations2.location.location)
                }.sum().roundToInt()
            }
    }
}