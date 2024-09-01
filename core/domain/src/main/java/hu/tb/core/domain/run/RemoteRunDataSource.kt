package hu.tb.core.domain.run

import hu.tb.core.domain.util.DataError
import hu.tb.core.domain.util.EmptyResult
import hu.tb.core.domain.util.Result

interface RemoteRunDataSource {
    suspend fun getRuns(): Result<List<Run>, DataError.Network>

    suspend fun postRun(run: Run, mapPicture: ByteArray): Result<Run, DataError.Network>

    suspend fun deleteRun(id: String): EmptyResult<DataError.Network>
}