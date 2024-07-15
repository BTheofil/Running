package hu.tb.auth.domain

import hu.tb.core.domain.util.DataError
import hu.tb.core.domain.util.EmptyResult

interface AuthRepository  {

    suspend fun register(email: String, password: String): EmptyResult<DataError.Network>
}