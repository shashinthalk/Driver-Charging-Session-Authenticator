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
import org.springframework.web.reactive.function.client.WebClientRequestException
import org.springframework.web.reactive.function.client.WebClientResponseException
import kotlin.random.Random

@Service
class AuthorizationService(
    private val decisionLogger: DecisionLogger,
    private val webClient: WebClient,
    private val authenticateHandler: AuthenticateHandler,
) {
    var status: String = ""

    /**
     * Executes the authorization process for a given charging session request.
     *
     * @param request - Contains stationId, driverToken, and callbackUrl
     *
     * Validate the driver and station
     * Delay only for the simulation - authorization process is not complex right now
     * Once we implement the real authorization process, no longer needed the delay
     * Sends the authorization status to the provided callback URL.
     * If it times out (after 10 seconds), it sends an "unknown" status.
     */
    suspend fun executeAuthorizationRequest(request: SessionRequestBody) {
        val (stationId, driverToken, callbackUrl) = request
        try {
            withTimeout(10_000) {
                // Simulate processing delay between 9 and 11 seconds (random)
                // Only for simulation
                val duration = Random.nextLong(9_000L, 11_001L)

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

    /**
     * Handles sending the callback to the callback url and log the decision.
     *
     * @param callback - The data containing stationId, driverToken, and status
     * @param callbackUrl - The url to post callback data
     *
     * This method sends a POST request with the callback. If successful,
     * It logs the decision. If the request fails, it logs the error with stationId and driverToken details
     */
    suspend fun statusAndLoggerHandler(
        callback: CallbackBody,
        callbackUrl: String,
    ) {
        try {
            webClient.post()
                .uri(callbackUrl)
                .bodyValue(callback)
                .retrieve()
                .toBodilessEntity()
                .awaitSingle()

            decisionLogger.saveDecisionLog(data = listOf(callback))
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
        } catch (e: WebClientRequestException) {
            decisionLogger
                .saveDecisionLog(
                    data =
                        listOf(
                            CallbackBody(
                                stationId = callback.stationId,
                                driverToken = callback.driverToken,
                                status = e.message.toString(),
                            ),
                        ),
                )
        }
    }
}
