package com.shashinthalk.driverchargingsessionauthenticator.authservice.service

import com.shashinthalk.driverchargingsessionauthenticator.api.dto.SessionRequestBody
import com.shashinthalk.driverchargingsessionauthenticator.authservice.dto.CallbackBody
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.reactive.awaitSingle
import kotlinx.coroutines.withTimeout
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.WebClientResponseException
import kotlin.random.Random

@Service
class AuthorizationService(
    private val decisionLogger: DecisionLogger,
    private val webClient: WebClient,
) {

    private val _status = MutableStateFlow("")
    val status: StateFlow<String> get() = _status

    suspend fun executeAuthorizationRequest(request: SessionRequestBody) {
        val (stationId, driverToken, callbackUrl) = request
        try {
            withTimeout(10000) {
                val duration = Random.nextLong(9000L, 11001L)
                delay(duration)
                _status.value = "allowed"
                statusAndLoggerHandler(
                    CallbackBody(
                        stationId,
                        driverToken,
                        _status.value,
                    ),
                    callbackUrl
                )
            }
        } catch (e: TimeoutCancellationException) {
            statusAndLoggerHandler(
                CallbackBody(
                    stationId,
                    driverToken,
                    "unknown"
                ),
                callbackUrl
            )
        }
    }

    suspend fun statusAndLoggerHandler(callback: CallbackBody, callbackUrl: String) {
        try {
            webClient.post()
                .uri(callbackUrl)
                .bodyValue(callback)
                .retrieve()
                .toBodilessEntity()
                .awaitSingle()
            decisionLogger.saveDecisionLog(data = listOf(callback))
        }catch (e: WebClientResponseException) {
            decisionLogger.saveDecisionLog(
                data =
                    listOf(
                        CallbackBody(
                            callback.stationId,
                            callback.driverToken,
                            e.message
                        ),
                    ),
            )
        }
    }
}
