package hu.tb.auth.data

import hu.tb.auth.domain.AuthRepository
import hu.tb.core.data.network.post
import hu.tb.core.domain.util.DataError
import hu.tb.core.domain.util.EmptyResult
import io.ktor.client.HttpClient

class AuthRepositoryImpl(
    private val httpClient: HttpClient
): AuthRepository {

    override suspend fun register(email: String, password: String): EmptyResult<DataError.Network> {
        return httpClient.post<RegisterRequest, Unit>(
            route = "/register",
            body = RegisterRequest(
                email = email,
                password = password
            )
        )
    }
}