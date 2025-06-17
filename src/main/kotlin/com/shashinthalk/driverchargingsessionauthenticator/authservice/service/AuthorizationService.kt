package com.shashinthalk.driverchargingsessionauthenticator.authservice.service

import com.shashinthalk.driverchargingsessionauthenticator.api.dto.SessionRequestBody
import com.shashinthalk.driverchargingsessionauthenticator.authservice.authenticate.AuthenticateHandler
import com.shashinthalk.driverchargingsessionauthenticator.authservice.dto.CallbackBody
import com.shashinthalk.driverchargingsessionauthenticator.authservice.logger.DecisionLogger
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.delay
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
    private val authenticateHandler: AuthenticateHandler,
) {
    var status: String = ""

    suspend fun executeAuthorizationRequest(request: SessionRequestBody) {
        val (stationId, driverToken, callbackUrl) = request
        try {
            withTimeout(
                10_000,
            ) {
                val duration =
                    Random.nextLong(
                        9_000L,
                        11_001L,
                    )
                status =
                    authenticateHandler.validateDriverAndStationWithAcl(
                        stationId = stationId,
                        driverToken = driverToken,
                    )
                delay(duration)
                statusAndLoggerHandler(
                    CallbackBody(
                        stationId = stationId,
                        driverToken = driverToken,
                        status = status,
                    ),
                    callbackUrl,
                )
            }
        } catch (e: TimeoutCancellationException) {
            statusAndLoggerHandler(
                CallbackBody(
                    stationId = stationId,
                    driverToken = driverToken,
                    status = "unknown",
                ),
                callbackUrl,
            )
        }
    }

    suspend fun statusAndLoggerHandler(
        callback: CallbackBody,
        callbackUrl: String,
    ) {
        try {
            webClient.post()
                .uri(
                    callbackUrl,
                )
                .bodyValue(
                    callback,
                )
                .retrieve()
                .toBodilessEntity()
                .awaitSingle()
            decisionLogger
                .saveDecisionLog(
                    data =
                        listOf(
                            callback,
                        ),
                )
        } catch (e: WebClientResponseException) {
            decisionLogger
                .saveDecisionLog(
                    data =
                        listOf(
                            CallbackBody(
                                stationId = callback.stationId,
                                driverToken = callback.driverToken,
                                status = e.message,
                            ),
                        ),
                )
        }
    }
}
